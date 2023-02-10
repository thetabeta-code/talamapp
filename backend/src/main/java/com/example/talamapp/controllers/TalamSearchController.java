package com.example.talamapp.controllers;

import com.example.talamapp.model.TalamSearch;
import com.example.talamapp.services.TalamSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TalamSearchController
{
    @Autowired
    private TalamSearchService talamSearchService;

    @RequestMapping("/talamSearches")
    public List<TalamSearch> getAllTalamSearches()
    {
        return talamSearchService.getAllTalams();
    }

    @RequestMapping("/talamSearches/{id}")
    public TalamSearch getTalamSearch(@PathVariable("id") Long id)
    {
        return talamSearchService.getTalamSearch(id);
    }
}