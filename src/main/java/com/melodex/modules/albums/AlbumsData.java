package com.melodex.modules.albums;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AlbumsData(
       @JsonAlias("album") List<AlbumData> albums
) {
    @Override
    public String toString() {
        return albums.toString();
    }
}
