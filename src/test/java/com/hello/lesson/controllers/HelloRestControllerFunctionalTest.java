package com.hello.lesson.controllers;

import com.hello.lesson.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerFunctionalTest {
    @Autowired
    public TestRestTemplate template;
    @Test
    void greetWithName() {
        assertThat(template.getForObject("/rest?name=name",
            String.class)).contains("Hello, name!");
    }

    @Test
    void greetWithoutName() {
        ResponseEntity<String> entity = template.getForEntity("/rest", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        String response = entity.getBody();
        if (response != null) {
            assertEquals("{\"message\":\"Hello, World!\"}", response);
        }
    }

    @Test
    void greetWithName0() {
        Greeting response = template.getForObject("/rest?name=name", Greeting.class);
        assertEquals("Hello, name!", response.getMessage());
    }

    @Test
    void greetWithoutName0() {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        if (response != null) {
            assertEquals("Hello, World!", response.getMessage());
        }
    }
}