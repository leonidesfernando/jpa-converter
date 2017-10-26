package com.github.leonidesfernando.jpa.converter.java.time;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyyMM" );
        assertNotNull(converter.convertToDatabaseColumn(mesAno));
        assertEquals(Integer.valueOf(formatter.format(mesAno)) , converter.convertToDatabaseColumn(mesAno));
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute(){
        final int mes = 12;
        final int ano = 2015;
        final int mesAno = 201512;
        YearMonth yearMonth = YearMonth.of(ano, mes);

        assertNotNull(converter.convertToEntityAttribute(mesAno));
        assertEquals(yearMonth.toString().trim(), converter.convertToEntityAttribute(mesAno).toString().trim());
        assertNull(converter.convertToEntityAttribute(null));
    }

    public static void main(String[] args) {
        YearMonth mesAno = YearMonth.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyyMM" );
        System.out.println(formatter.format(mesAno));
    }
}
