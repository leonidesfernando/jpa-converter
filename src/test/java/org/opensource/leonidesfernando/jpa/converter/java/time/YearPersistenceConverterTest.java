package org.opensource.leonidesfernando.jpa.converter.java.time;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Year;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class YearPersistenceConverterTest {

    private YearPersistenceConverter converter;


    @BeforeClass
    private void setup(){
        converter = new YearPersistenceConverter();
    }

    @Test
    public void convertToDatabaseColumn(){

        final Integer ano = 2015;
        final Year year = Year.of(ano);
        assertNotNull(converter.convertToDatabaseColumn(year));
        assertEquals(ano, converter.convertToDatabaseColumn(year));
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute(){
        final int ano = 2015;
        Year year = Year.of(ano);

        assertNotNull(converter.convertToEntityAttribute(ano));
        assertEquals(year, converter.convertToEntityAttribute(ano));
        assertNull(converter.convertToEntityAttribute(null));
    }
}
