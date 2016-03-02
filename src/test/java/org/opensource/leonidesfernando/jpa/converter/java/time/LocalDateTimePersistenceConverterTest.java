package org.opensource.leonidesfernando.jpa.converter.java.time;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class LocalDateTimePersistenceConverterTest {

    private LocalDateTimePersistenceConverter converter;

    @BeforeClass
    private void setup(){
        converter = new LocalDateTimePersistenceConverter();
    }

    @Test
    public void convertToDatabaseColumn(){

        final LocalDateTime ldt = LocalDateTime.now();
        final Timestamp timestamp = Timestamp.valueOf(ldt);
        assertNotNull(converter.convertToDatabaseColumn(ldt));
        assertEquals(timestamp, converter.convertToDatabaseColumn(ldt));
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute(){

        final LocalDateTime ldt = LocalDateTime.now();
        final Timestamp timestamp = new Timestamp(new Date().getTime());
        assertNotNull(converter.convertToEntityAttribute(timestamp));

        final LocalDateTime ldtConverter = converter.convertToEntityAttribute(timestamp);

        assertEquals(ldt.getYear(), ldtConverter.getYear());
        assertEquals(ldt.getMonth(), ldtConverter.getMonth());
        assertEquals(ldt.getDayOfMonth(), ldtConverter.getDayOfMonth());
        assertEquals(ldt.getHour(), ldtConverter.getHour());
        assertEquals(ldt.getMinute(), ldtConverter.getMinute());
        assertEquals(ldt.getSecond(), ldtConverter.getSecond());

        assertNull(converter.convertToEntityAttribute(null));
    }
}
