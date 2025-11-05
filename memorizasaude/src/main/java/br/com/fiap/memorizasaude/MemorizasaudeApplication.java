package br.com.fiap.memorizasaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.fiap.memorizasaude")
public class MemorizasaudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemorizasaudeApplication.class, args);
	}

}
