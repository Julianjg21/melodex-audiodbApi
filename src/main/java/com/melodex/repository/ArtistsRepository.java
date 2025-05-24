package com.melodex.repository;

import com.melodex.modules.artists.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
}
