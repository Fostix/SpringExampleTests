package com.hello.lesson.json;

import org.springframework.stereotype.Component;

//@Component
public class Greeting {
    private String message;

    public Greeting() { // for test easier
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
