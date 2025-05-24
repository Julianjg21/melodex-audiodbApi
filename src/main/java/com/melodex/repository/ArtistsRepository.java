package com.melodex.repository;

import com.melodex.modules.artists.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArtistsRepository extends JpaRepository<Artist, Integer> {

   
    @Query("SELECT a.idArtist FROM Artist a WHERE a.artistName = :name")
    Optional<Long> findIdByArtistName(@Param("name") String artistName);

    /**
     * Finds an Artist by its idArtist.
     * @param idArtist the artist id
     * @return Optional containing the Artist if it exists
     */
    Optional<Artist> findByIdArtist(Long idArtist);

}
