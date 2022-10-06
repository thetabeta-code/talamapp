package com.example.talamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.talamapp.dao.SongDao;

public interface SongRepository extends CrudRepository<SongDao, Long>
{
    @Query(value = "SELECT * FROM song WHERE song.talam_id = ?1", nativeQuery = true)
    List<SongDao> findAllByTalam(Long talamId);

    @Query(value="SELECT * FROM song WHERE song.ragam_id = ?1", nativeQuery = true)
    List<SongDao> findAllByRagam(Long ragamId);

    /*@Query(value="SELECT * FROM song WHERE song.talam_id = ?1 AND song.ragam_id = ?2", nativeQuery = true)
    List<SongDao> findAllByTalamAndRagamId(Long talamId, Long ragamId);*/

    List<SongDao> findAllByTalamIdAndRagamId(Long talamId, Long ragamId);

}