package br.com.etec.arthur.locadoraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocadoraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApiApplication.class, args);
		System.out.println("Api running!");
	}

}
