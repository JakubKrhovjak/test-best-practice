package com.example.testbestpractice;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.javacrumbs.jsonunit.core.Option;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import io.vavr.control.Try;
import lombok.experimental.UtilityClass;

/**
 * Created by Jakub Krhovják on 1/6/23.
 */

@UtilityClass
public class TestUtils {

    private static final ObjectMapper OB = new ObjectMapper();

    public String readFileAsString(String name) {
        return Try.of(() -> new String(Files.readAllBytes(Paths.get(
                        Objects.requireNonNull(TestUtils.class.getClassLoader().getResource(name)).toURI()))))
                .getOrElseThrow(e -> new RuntimeException("Cannot load test file: " + name, e));
    }

    public <R> R readJsonAsType(final String json, final TypeReference<R> clazz) {
        return Try.of(() -> OB.readValue(json, clazz))
                .getOrElseThrow(e -> new RuntimeException(e));
    }

    public static void assertJsonEquals(String result, String expected) {
        assertThatJson(result)
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(expected);
    }

}
