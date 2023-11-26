package com.example.proba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;


@SpringBootApplication
public class ProbaApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ProbaApplication.class, args);
	}
}
