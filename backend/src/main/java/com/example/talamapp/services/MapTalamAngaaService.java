package com.example.talamapp.services;

import com.example.talamapp.dao.MapTalamAngaaDao;
import com.example.talamapp.dao.TalamDao;
import com.example.talamapp.repositories.MapTalamAngaaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapTalamAngaaService
{
    @Autowired
    private MapTalamAngaaRepository mapTalamAngaaRepository;

    public List<MapTalamAngaaDao> getAllMapTalamAngaas()
    {
        List<MapTalamAngaaDao> mapTalamAngaas = new ArrayList<>();
        //mapTalamAngaaRepository.findAll().forEach(mapTalamAngaas::add);
        mapTalamAngaaRepository.findAllMappings().forEach(mapTalamAngaas::add);
        return mapTalamAngaas;
    }

    public MapTalamAngaaDao getMapTalamAngaa(Long id)
    {
        MapTalamAngaaDao mapTalamAngaa = mapTalamAngaaRepository.findById(id).get(); //might want to return Optional<MapTalamAngaa> instead of MapTalamAngaa
        return mapTalamAngaa;
    }

    public List<MapTalamAngaaDao> getMapTalamAngaasbyTalam(TalamDao talamDao)
    {
        Long talamId = talamDao.getId();
        List<MapTalamAngaaDao> mapTalamAngaas = mapTalamAngaaRepository.findAllByTalam(talamId);
        return mapTalamAngaas;
    }

    public List<MapTalamAngaaDao> getMapTalamAngaasbyTalamId(Long talamId)
    {
        List<MapTalamAngaaDao> mapTalamAngaas = mapTalamAngaaRepository.findAllByTalam(talamId);
        return mapTalamAngaas;
    }

    public void addMapTalamAngaa(MapTalamAngaaDao mapTalamAngaa)
    {
        mapTalamAngaaRepository.save(mapTalamAngaa);
    }

    public void updateMapTalamAngaa(Long id, MapTalamAngaaDao mapTalamAngaa)
    {
        mapTalamAngaaRepository.save(mapTalamAngaa);
    }

    public void deleteMapTalamAngaa(Long id)
    {
        mapTalamAngaaRepository.deleteById(id);
    }
}