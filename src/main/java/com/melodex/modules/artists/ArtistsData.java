package com.melodex.modules.artists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true) 
public record ArtistsData(
        List<ArtistData> artists
) {
    @Override
    public String toString() {
        return  artists.toString();
    }
}
