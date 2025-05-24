package com.melodex.modules.artists;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistData(
        int idArtist,
        @JsonAlias("strArtist") String artistName,
        @JsonAlias("intBornYear") int bornYear,
        @JsonAlias("diedYear") String diedYear,
        @JsonAlias("strGenre") String musicalGenre,
        @JsonAlias("strBiographyEN") String biography,
        @JsonAlias("strCountry") String country
) {
    
}
