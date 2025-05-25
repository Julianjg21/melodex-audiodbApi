package com.melodex.modules.tracks;

import java.util.List;

public class Tracks {
    private final List<TrackData> tracks;

    public Tracks(TracksData tracksData) {
        this.tracks = tracksData.tracks();
    }

    public List<TrackData> getTracks() {
        return tracks;
    }
}
