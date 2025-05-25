package com.melodex.repository;

import com.melodex.modules.albums.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlbumsRepository extends JpaRepository<Album, Integer> {

   
    @Query("SELECT al.idAlbum FROM Album al WHERE al.albumName = :name")
    Optional<Long> findIdByAlbumName(@Param("name") String albumName);

    /**
     * Finds an Album by its idAlbum.
     * @param idAlbum the album id
     * @return Optional containing the Album if it exists
     */
    Optional<Album> findByIdAlbum(Long idAlbum);

}
