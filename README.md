# jpa-converter
É uma biblioteca para ajudar os desenvolvedores Java que fazem uso da JPA, persistir os principais tipos do pacote <code>java.time</code> do _Java8_.
A versão `0.7` suporta os tipos:

```java
  java.time.LocalDate
  java.time.LocalDateTime
  java.time.YearMonth
  java.time.Year
```

Usar o *jpa-converter* no seu projeto é muito simples, bastam 3 passos:

## 1. Configurar o repositório e a dependência *_Maven_*

Repositório: https://oss.sonatype.org/content/groups/public

No _pom.xml_ defina o repositório e a dependência

```xml
		 <repository>
			 <id>sonatype</id>
			 <name>Sonatype</name>
			 <url>https://oss.sonatype.org/content/groups/public</url>
		 </repository>
```
```xml
		<dependency>
			<groupId>com.github.leonidesfernando</groupId>
			<artifactId>jpa-converter</artifactId>
			<version>0.7</version>
		</dependency>
```


## 2. No *persistence.xml* adicione os conversores que fará uso

```xml
	<persistence-unit name="minhaUnidadeDePersistencia" >
		<class>com.github.leonidesfernando.jpa.converter.java.time.LocalDatePersistenceConverter</class>
		<class>com.github.leonidesfernando.jpa.converter.java.time.LocalDateTimePersistenceConverter</class>
		<class>com.github.leonidesfernando.jpa.converter.java.time.YearMonthPersistenceConverter</class>
		<class>com.github.leonidesfernando.jpa.converter.java.time.YearPersistenceConverter</class>
	</persistence-unit>
```


## 3. Mapeie os tipos suportados pelo jpa-converter nas suas entidades
O mapeamento fica totalmente transparente, não é necessário realizar nenhuma outra configuração.

```java
	@NotNull(message="{data.cadastro.notnull}")
	@Column(name="data_cadastro")
	private LocalDateTime dataCadastro;
	
	@NotNull(message="{data.hora.ultima.alteracao.notnull}")
	@Column(name="data_hora_ultima_alteracao")
	private LocalDateTime dataHoraUltimaAlteracao;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull(message="{ultimo.mes.ano.sincronizado.notnull}")
	@Column(name="ultimo_mes_ano_sincronizado")
	private YearMonth ultimoMesAnoSincronizado;
```
## 4. Changelog
Versão 0.7 otimizando persistência `YearMonth` de `String` para `Integer`.

Guia de migração as versões anteriores para a 0.7:

Sql's para o _Postgresql_

Na(s) tabela(s) que possui o tipo Year, criar uma coluna que passará armazenar o tipo YearMonth persistido:
```sql
alter table tabela_com_mes_ano add colum mesAnoInteger integer;
```

Em seguida dispara um update na(s) tabelas envolvidas:
```sql
update tabela_com_mes_ano set mesAnoInteger = 
(select cast ((substring(mesAnoString FROM '[0-9]*')) as int) * 100 + cast(substring(mesAnoString FROM '..$') as int) from tabela_com_mes_ano);
```

Remover a(s) coluna antiga das tabelas envolvidas:
```sql
alter table tabela_com_mes_ano drop column mesAnoString;
```        
                                       
# Quer contribuir com o projeto?
Você pode ajudar, codificando, enviando sugestões, documentando ou reportando bugs.
Basta entrar no grupo [JPA-Conveter Group] (https://groups.google.com/forum/#!forum/jpa-converter)
	
# Licença
O *jpa-converter* está sob a licença LGPl 2.1.Veja a licença inclusa no projeto para mais detalhes ou acesse: http://www.gnu.org/licenses/lgpl-2.1.html

# Site
http://leonidesfernando.github.io/jpa-converter/
