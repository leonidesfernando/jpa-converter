package org.opensource.leonidesfernando.jpa.converter.java.time;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.YearMonth;

import static org.testng.Assert.*;

public class YearMonthPersistenceConverterTest {

    private YearMonthPersistenceConverter converter;

    @BeforeClass
    private void setup(){
        converter = new YearMonthPersistenceConverter();
    }


    @Test
    public void convertToDatabaseColumn(){

        final int mes = 12;
        final int ano = 2015;
        final YearMonth mesAno = YearMonth.of(ano, mes);
        assertNotNull(converter.convertToDatabaseColumn(mesAno));
        assertEquals(mesAno.toString(), converter.convertToDatabaseColumn(mesAno));
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute(){
        final int mes = 12;
        final int ano = 2015;
        final String mesAno = "2015-12";
        YearMonth yearMonth = YearMonth.of(ano, mes);

        assertNotNull(converter.convertToEntityAttribute(mesAno));
        assertEquals(yearMonth.toString().trim(), converter.convertToEntityAttribute(mesAno).toString().trim());
        assertNull(converter.convertToEntityAttribute(null));
    }
}
