package com.example.demo;

import com.example.demo.translate.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner runner(TranslationService service) {
        return args -> {
           log.info(service.translate("አቶ አብዲ ሙመድ ሀሰን"));

        };

    }

}
