package com.galvanize;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ObjectToJsonConverterTest {
    @Test
    public void givenObjectNotSerializedThenExceptionThrown() {
        Object object = new Object();
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        assertThrows(JsonSerializationException.class, () -> converter.convertToJson(object));
    }

    @Test
    public void givenObjectSerializedReturnJson() throws JsonSerializationException, InvocationTargetException, IllegalAccessException {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String expected = "{\"personAge\":\"34\",\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}";
        String actual = converter.convertToJson(person);
        assertEquals(expected, actual);
    }
}