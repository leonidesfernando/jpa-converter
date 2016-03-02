package org.opensource.leonidesfernando.jpa.converter.java.time;


import org.opensource.leonidesfernando.jpa.converter.util.Util;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class LocalDatePersistenceConverterTest {

    private LocalDatePersistenceConverter converter;

    @BeforeClass
    private void setup(){
        converter = new LocalDatePersistenceConverter();
    }

    @Test
    public void convertToDatabaseColumn(){

        final LocalDate ld = LocalDate.now();
        final Date date = new Date();
        assertNotNull(converter.convertToDatabaseColumn(ld));
        assertEquals(Util.dateFormat.format(date), converter.convertToDatabaseColumn(ld).toString());
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute(){

        final LocalDate ld = LocalDate.now();
        final java.sql.Date date = new java.sql.Date(new Date().getTime());
        assertNotNull(converter.convertToEntityAttribute(date));
        assertEquals(ld.toString(), converter.convertToEntityAttribute(date).toString());
        assertNull(converter.convertToEntityAttribute(null));
    }
}
