package com.melodex.repository;

import com.melodex.modules.tracks.Track;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Track entity.
 * Extends JpaRepository to provide CRUD operations on Track.
 */
public interface TracksRepository extends JpaRepository<Track, Integer> {
}
