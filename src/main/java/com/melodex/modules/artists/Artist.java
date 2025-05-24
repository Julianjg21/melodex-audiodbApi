package com.melodex.modules.artists;

import jakarta.persistence.*;

// This entity represents an artist and maps to a database table
@Entity
public class Artist {

    // Primary key for the Artist entity
    @Id
    private int idArtist;

    private String artistName;
    private int bornYear;
    private String diedYear;
    private String musicalGenre;

    // Biography can be long text, so we set column type to TEXT
    @Column(columnDefinition = "TEXT")
    private String biography;

    private String country;

    // Constructor that initializes an Artist from ArtistData (record)
    public Artist(ArtistData artistData) {
        this.idArtist = artistData.idArtist();
        this.artistName = artistData.artistName();
        this.bornYear = artistData.bornYear();
        this.diedYear = artistData.diedYear();
        this.musicalGenre = artistData.musicalGenre();
        this.biography = artistData.biography();
        this.country = artistData.country();
    }

    // Default constructor required by JPA
    public Artist() {
    }

    // Getters and Setters
    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getDiedYear() {
        return diedYear;
    }

    public void setDiedYear(String diedYear) {
        this.diedYear = diedYear;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
