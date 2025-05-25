package com.melodex.modules.tracks;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TracksData(
        @JsonAlias("track") List<TrackData> tracks
) {
    
}
