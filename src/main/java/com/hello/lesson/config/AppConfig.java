package com.hello.lesson.config;

import com.hello.lesson.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.NumberFormat;
import java.util.Locale;

@Configuration
public class AppConfig {
    @Bean
    public Greeting defaultGreeting() {
        return new Greeting("Hello, World!");
    }

    @Bean
    public Greeting whatUpGreeting() {
        return new Greeting("What up?");
    }

    @Bean
    public NumberFormat defaultNumberFormat() {
        return NumberFormat.getCurrencyInstance(Locale.getDefault());
    }

    @Bean
    // @Scope("prototype")
    public NumberFormat indiaNumberFormat() {
        return NumberFormat.getCurrencyInstance(new Locale("hin", "IN"));
    }
}
