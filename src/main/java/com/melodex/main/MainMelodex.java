package com.melodex.main;

// Modules for entity structure and response handling
import com.melodex.modules.albums.Album;
import com.melodex.modules.albums.Albums;
import com.melodex.modules.albums.AlbumsData;
import com.melodex.modules.artists.Artist;
import com.melodex.modules.artists.Artists;
import com.melodex.modules.artists.ArtistsData;
import com.melodex.modules.tracks.Track;
import com.melodex.modules.tracks.Tracks;
import com.melodex.modules.tracks.TracksData;

// Repositories for DB interactions
import com.melodex.repository.AlbumsRepository;
import com.melodex.repository.ArtistsRepository;
import com.melodex.repository.TracksRepository;

// Services for HTTP and JSON data handling
import com.melodex.services.ConvertData;
import com.melodex.services.HttpClientService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMelodex {

    // API base URL
    private final String url = "https://www.theaudiodb.com/api/v1/json/2/";

    // Converter service for JSON to POJO
    ConvertData Converter = new ConvertData();

    // Repositories
    ArtistsRepository artistsRepository;
    AlbumsRepository albumsRepository;
    TracksRepository tracksRepository;

    // Variables for request data and user input
    String json;
    Scanner sc = new Scanner(System.in);

    // Constructor to inject the repositories
    public MainMelodex(ArtistsRepository artistsRepository, AlbumsRepository albumsRepository, TracksRepository tracksRepository) {
        this.artistsRepository = artistsRepository;
        this.albumsRepository = albumsRepository;
        this.tracksRepository = tracksRepository;
    }

    // Show main menu options for user interaction
    public void showMenu() {
        int option = 0;
        while (option != 99) {
            System.out.println("Welcome to the Melodex🎶. \nEnter the option you want to use:");
            System.out.println("""
                    🧑‍💼1.Search an Artist.
                    📂2.Show albums from an artist previously searched.
                    🔮3.Show tracks from an Album previously searched.
                    """);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> searchArtist();
                case 2 -> searchAlbums();
                case 3 -> searchTracks();
            }
        }
    }

    // Request and parse JSON data of artist by name
    public ArtistsData getArtists() {
        System.out.println("Enter Artist Name: ");
        String artistName = sc.nextLine();
        json = HttpClientService.sendGetRequest(url + "search.php?s=" + artistName);
        ArtistsData artistsData = Converter.getData(json, ArtistsData.class);
        return artistsData;
    }

    // Get artist data and save the first result into the DB
    public void searchArtist() {
        ArtistsData artistsData = getArtists();
        Artists artists = new Artists(artistsData);
        Artist artist = new Artist(artists.getArtists().stream().findFirst().get());
        artistsRepository.save(artist);
    }

    // Request and parse JSON data of albums by selected artist name
    public AlbumsData getAlbums() {
        System.out.println("Artists previously searched:");
        List<Artist> artists = artistsRepository.findAll();
        artists.forEach(System.out::println);

        System.out.println("Enter the name of The Artist from whom you want to look for your albums");
        String artistName = sc.nextLine();

        Optional<Long> optionalId = artistsRepository.findIdByArtistName(artistName);
        int idArtist = optionalId.map(Long::intValue)
                .orElseThrow(() -> new RuntimeException("Artists not found"));

        json = HttpClientService.sendGetRequest(url + "album.php?i=" + idArtist);
        AlbumsData albumsData = Converter.getData(json, AlbumsData.class);
        return albumsData;
    }

    // Get album data and save all albums into the DB
    public void searchAlbums() {
        AlbumsData albumsData = getAlbums();
        Albums albums = new Albums(albumsData);

        List<Album> albumList = albums.getAlbums()
                .stream()
                .map(data -> {
                    Artist artist = artistsRepository.findById(data.idArtist())
                            .orElseThrow(() -> new RuntimeException("Artist not found with the  ID: " + data.idArtist()));
                    return new Album(data, artist);
                })
                .collect(Collectors.toList());

        albumsRepository.saveAll(albumList);
        albumList.forEach(System.out::println);
    }

    // Request and parse JSON data of tracks by selected album name
    public TracksData getTracks() {
        System.out.println("Albums previously searched:");
        List<Album> albums = albumsRepository.findAll();
        albums.forEach(System.out::println);

        System.out.println("Please enter the name of the album from which you want to get your tracks");
        String albumName = sc.nextLine();

        Optional<Long> optionalId = albumsRepository.findIdByAlbumName(albumName);
        int idAlbum = optionalId.map(Long::intValue)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        json = HttpClientService.sendGetRequest(url + "track.php?m=" + idAlbum);
        TracksData tracksData = Converter.getData(json, TracksData.class);
        return tracksData;
    }

    // Get track data and save all tracks into the DB
    public void searchTracks() {
        TracksData tracksData = getTracks();
        Tracks tracks = new Tracks(tracksData);

        List<Track> trackList = tracks.getTracks()
                .stream()
                .map(data -> {
                    Album album = albumsRepository.findById(data.idAlbum())
                            .orElseThrow(() -> new RuntimeException("Album not found with the ID: " + data.idAlbum()));
                    return new Track(data, album);
                })
                .collect(Collectors.toList());

        tracksRepository.saveAll(trackList);
        trackList.forEach(System.out::println);
    }

}
