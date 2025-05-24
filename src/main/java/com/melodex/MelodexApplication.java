package com.melodex;

import com.melodex.main.MainMelodex;
import com.sun.tools.javac.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MelodexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MelodexApplication.class, args);
	}

	// This method runs after the application starts
	@Override
	public void run(String... args) throws Exception {
		// Creating an instance of the Library class
		MainMelodex main = new MainMelodex();
		main.showMenu();
		
	}
}
