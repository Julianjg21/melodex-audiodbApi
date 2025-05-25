package com.melodex.modules.albums;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumData(
        int idAlbum,
        int idArtist,
        @JsonAlias("strAlbum") String albumName,
        @JsonAlias("intYearReleased") int yearReleased,
        @JsonAlias("strGenre") String genre,
        @JsonAlias("intScore") double score
) {
 
}
