package com.melodex.modules.artists;

import java.util.List;

public class Artists {
    // List to hold multiple ArtistData records
    List<ArtistData> artists;

    // Constructor that initializes the list from ArtistsData object
    public Artists(ArtistsData artistsData) {
        this.artists = artistsData.artists();
    }

    // Getter method to access the list of ArtistData
    public List<ArtistData> getArtists() {
        return artists;
    }
}
