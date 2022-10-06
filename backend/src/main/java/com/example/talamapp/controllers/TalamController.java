package com.example.talamapp.controllers;

import java.util.List;

import com.example.talamapp.model.Talam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.talamapp.services.TalamService;

@RestController
@CrossOrigin
public class TalamController
{
    @Autowired
    private TalamService talamService;

    @RequestMapping("/talams")
    public List<Talam> getAllTalams()
    {
        return talamService.getAllTalams();
    }

    @RequestMapping("/talams/{id}")
    public Talam getTalam(@PathVariable("id") Long id)
    {
        return talamService.getTalam(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/talams")
    public void addTalam(@RequestBody Talam talam)
    {
        talamService.addTalam(talam);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/talams")
    public void updateTalam(@RequestBody Talam talam)
    {
        talamService.updateTalam( talam);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/talams/{id}")
    public void deleteTalam(@PathVariable("id") Long id)
    {
        talamService.deleteTalam(id);
    }
}