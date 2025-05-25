package com.melodex.modules.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TrackData(
        int idTrack,
        int idAlbum,
        @JsonAlias("strTrack") String trackName,
        @JsonAlias("strGenre") String genre,
        @JsonAlias("intScore") double score
) {
}
