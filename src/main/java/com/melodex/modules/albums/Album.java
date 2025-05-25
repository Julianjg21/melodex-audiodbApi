package com.melodex.modules.albums;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.melodex.modules.artists.Artist;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {

    @Id
    private int idAlbum;

    @ManyToOne
    @JoinColumn(name = "idArtist", referencedColumnName = "idArtist")
    private Artist artist;

    private String albumName;
    private int yearReleased;
    private String genre;
    private double score;

    // Constructor that maps AlbumData to this entity, with Artist injected for the relation
    public Album(AlbumData albumData, Artist artist) {
        this.idAlbum = albumData.idAlbum();
        this.artist = artist; // this establishes the relationship with the Artist entity
        this.albumName = albumData.albumName();
        this.yearReleased = albumData.yearReleased();
        this.genre = albumData.genre();
        this.score = albumData.score();
    }

    // Default constructor required by JPA
    public Album() {
    }

    // Unused constructor, might be removed or implemented later
    public Album(AlbumData albumData) {
    }

    // Getter and Setter for idAlbum
    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    // Getter and Setter for albumName
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    // Getter and Setter for yearReleased
    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and Setter for score
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // Custom toString method to print album details, including artist name
    @Override
    public String toString() {
        return "Album{" +
                ", artist=" + artist.getArtistName().toString() +
                ", albumName='" + albumName + '\'' +
                ", yearReleased=" + yearReleased +
                ", genre='" + genre + '\'' +
                ", score=" + score +
                '}';
    }
}
