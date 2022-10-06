package com.example.talamapp.repositories;

import com.example.talamapp.dao.MapTalamAngaaDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MapTalamAngaaRepository extends CrudRepository<MapTalamAngaaDao, Long>
{
//    @Query(value = "SELECT * FROM talam INNER JOIN talam_angaa ON talam.id = talam_angaa.talam_id WHERE talam.id = ?1 ORDER by sequence ", nativeQuery = true)
      @Query(value = "SELECT * FROM talam_angaa where talam_id=?1", nativeQuery = true)
      List<MapTalamAngaaDao> findAllByTalam(Long talamId);

      @Query(value = "SELECT * FROM talam_angaa ORDER BY talam_id, sequence", nativeQuery = true)
      List<MapTalamAngaaDao> findAllMappings();

}