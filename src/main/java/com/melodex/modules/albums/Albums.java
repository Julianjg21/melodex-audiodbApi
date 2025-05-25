package com.melodex.modules.albums;

import java.util.List;

public class Albums {

    // This list stores the raw album data coming from the API response
    List<AlbumData> albums;

    // Constructor that takes AlbumsData and extracts the list of AlbumData
    public Albums(AlbumsData albums) {
        this.albums = albums.albums();
    }

    // Getter to access the list of AlbumData
    public List<AlbumData> getAlbums() {
        return albums;
    }
}
