/**
 * Persistence of java.time classes as of Java 8.
 * Excluded from persistence here is {@link java.time.ZoneOffset} because
 * that is not a static value.
 * <p>
 * The converters are portable and require <cite>JPA 2.1</cite>. In order
 * to do that a simple persistence to a {@link java.lang.String} was
 * implemented in some cases. The converters do not
 * support special types supported by database vendors, such as TimestampZ.
 * Nor do they separate values out into more than one column. If you want that,
 * then you will have to create a custom converter using the conventions of
 * your persistence provider.
 *
 * @since 1.0
 */
package com.github.leonidesfernando.jpa.converter.java.time;
