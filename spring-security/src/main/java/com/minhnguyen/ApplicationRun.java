package com.minhnguyen;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class ApplicationRun implements CommandLineRunner {

  public static void main(String[] args) {
    try {
      SpringApplication.run(ApplicationRun.class, args);
    } catch (Exception ex) {
      log.error("(ApiApplicationRun) ERROR", ex);
    }
  }

  @Override
  public void run(String... args) throws Exception {
  }
}