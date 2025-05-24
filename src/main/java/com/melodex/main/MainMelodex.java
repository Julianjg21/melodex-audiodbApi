package com.melodex.main;
import com.melodex.modules.artists.Artists;
import com.melodex.services.ConvertData;
import com.melodex.services.HttpClientService;
import com.melodex.modules.artists.ArtistData;

import java.util.Scanner;

public class MainMelodex {
    private final String url = "https://www.theaudiodb.com/api/v1/json/2/";
    ConvertData Converter = new ConvertData();
    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int option = 0;
        while (option != 99) {
            System.out.println("Welcome to the Melodex. \nEnter the option you want to use:");
            System.out.println("""
                    🧑‍💼1.Search an Artist.
                    """);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    searchArtist();
                    break;
            }
        }

    }

    public ArtistData getArtists() {
        System.out.println("Enter Artist Name: ");
        String artistName = sc.nextLine();
        String json = HttpClientService.sendGetRequest(url + "search.php?s=" + artistName);
        ArtistData artistsData = Converter.getData(json, ArtistData.class);
        return artistsData;
    }

    public void searchArtist() {
        ArtistData artistData = getArtists();
        Artists artists = new Artists(artistData);
        System.out.println(artists.getArtists());
    }


    
}
