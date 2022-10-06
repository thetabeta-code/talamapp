package com.example.talamapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.talamapp.dao.RagamDao;
import com.example.talamapp.services.RagamService;

@RestController
@CrossOrigin
class RagamController
{
    @Autowired
    private RagamService ragamService;

    @RequestMapping("/ragams")
    public List<RagamDao> getAllRagams()
    {
        return ragamService.getAllRagams();
    }

    @RequestMapping("/ragams/{id}")
    public RagamDao getRagam(@PathVariable("id") Long id)
    {
        return ragamService.getRagam(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ragams")
    public void addRagam(@RequestBody RagamDao ragam)
    {
        ragamService.addRagam(ragam);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/ragams/{id}")
    public void updateRagam(@RequestBody RagamDao ragam, @PathVariable("id") Long id)
    {
        ragamService.updateRagam(id, ragam);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/ragams/{id}")
    public void deleteRagam(@PathVariable("id") Long id)
    {
        ragamService.deleteRagam(id);
    }
}