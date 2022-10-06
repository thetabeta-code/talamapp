package com.example.talamapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.talamapp.dao.MapTalamAngaaDao;
import com.example.talamapp.services.MapTalamAngaaService;

@RestController
@CrossOrigin
public class MapTalamAngaaController
{
    @Autowired
    private MapTalamAngaaService mapTalamAngaaService;

    @RequestMapping("/mapTalamAngaas")
    public List<MapTalamAngaaDao> getAllMapTalamAngaas()
    {
        return mapTalamAngaaService.getAllMapTalamAngaas();
    }

    @RequestMapping("/mapTalamAngaas/{id}")
    public MapTalamAngaaDao getMapTalamAngaa(@PathVariable("id") Long id)
    {
        return mapTalamAngaaService.getMapTalamAngaa(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mapTalamAngaas")
    public void addMapTalamAngaa(@RequestBody MapTalamAngaaDao mapTalamAngaa)
    {
        mapTalamAngaaService.addMapTalamAngaa(mapTalamAngaa);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/mapTalamAngaas/{id}")
    public void updateMapTalamAngaa(@RequestBody MapTalamAngaaDao mapTalamAngaa, @PathVariable("id") Long id)
    {
        mapTalamAngaaService.updateMapTalamAngaa(id, mapTalamAngaa);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/mapTalamAngaas/{id}")
    public void deleteMapTalamAngaa(@PathVariable("id") Long id)
    {
        mapTalamAngaaService.deleteMapTalamAngaa(id);
    }
}