package com.melodex;

import com.melodex.main.MainMelodex;
import com.melodex.repository.AlbumsRepository;
import com.melodex.repository.ArtistsRepository;
import com.melodex.repository.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MelodexApplication implements CommandLineRunner {

	@Autowired
	private ArtistsRepository artistsRepository;

	@Autowired
	private AlbumsRepository albumsRepository;

	@Autowired
	private TracksRepository tracksRepository;

	public static void main(String[] args) {
		SpringApplication.run(MelodexApplication.class, args);
	}


	 // It initializes the main menu for the application.

	@Override
	public void run(String... args) throws Exception {
		// Create an instance of MainMelodex with repositories injected
		MainMelodex main = new MainMelodex(artistsRepository, albumsRepository, tracksRepository);
		// Show the main menu to the user
		main.showMenu();
	}
}
