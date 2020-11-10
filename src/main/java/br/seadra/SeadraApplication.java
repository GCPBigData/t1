package br.seadra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 06/11/2020
 */

@ComponentScan(basePackages = {"br.seadra"})
@SpringBootApplication
public class SeadraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeadraApplication.class, args);
	}
}
