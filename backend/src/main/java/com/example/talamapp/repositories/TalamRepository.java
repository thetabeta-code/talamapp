package com.example.talamapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.talamapp.dao.TalamDao;

public interface TalamRepository extends CrudRepository<TalamDao, Long>
{
    
}