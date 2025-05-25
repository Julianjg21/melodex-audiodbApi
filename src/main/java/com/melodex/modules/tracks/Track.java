package com.melodex.modules.tracks;

import com.melodex.modules.albums.Album;
import jakarta.persistence.*;

@Entity
public class Track {
    @Id
    private int idTrack;

    @ManyToOne
    @JoinColumn(name = "idAlbum", referencedColumnName = "idAlbum")
    private Album album;

    private String trackName;
    private String genre;
    private double score;

    // Constructor que recibe TrackData y la entidad Album asociada
    public Track(TrackData trackData, Album album) {
        this.idTrack = trackData.idTrack();
        this.album = album;
        this.trackName = trackData.trackName();
        this.genre = trackData.genre();
        this.score = trackData.score();
    }

    // Constructor vacío necesario para JPA
    public Track() {}

    // Getters y setters
    public double getScore() {
        return score;
    }

    public void setScore(double score) {  // Cambié int por double para coincidir con el tipo
        this.score = score;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(int idTrack) {
        this.idTrack = idTrack;
    }

    @Override
    public String toString() {
        return "Track{" +
                "album=" + (album != null ? album.getAlbumName() : "null") +
                ", trackName='" + trackName + '\'' +
                ", genre='" + genre + '\'' +
                ", score=" + score +
                '}';
    }
}
