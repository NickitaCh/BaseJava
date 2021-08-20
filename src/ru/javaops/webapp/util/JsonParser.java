package ru.javaops.webapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.javaops.webapp.model.AbstractSection;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(AbstractSection.class, new JsonSectionAdapter())
            .create();

    public static <T> T read(Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void write(T object, Writer writer) {
        GSON.toJson(object, writer);
    }

    public static <T> T read(String content, Class<T> anyClass) {
        return GSON.fromJson(content, anyClass);
    }

    public static <T> String write(T object, Class<T> anyClass) {
        return GSON.toJson(object, anyClass);
    }
}
