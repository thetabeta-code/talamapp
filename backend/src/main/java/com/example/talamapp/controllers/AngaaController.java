package com.example.talamapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.talamapp.dao.AngaaDao;
import com.example.talamapp.services.AngaaService;

@RestController
class AngaaController
{
    @Autowired
    private AngaaService angaaService;

    @RequestMapping("/angaas")
    public List<AngaaDao> getAllAngaas()
    {
        return angaaService.getAllAngaas();
    }

    @RequestMapping("/angaas/{id}")
    public AngaaDao getAngaa(@PathVariable("id") Long id)
    {
        return angaaService.getAngaa(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/angaas")
    public void addAngaa(@RequestBody AngaaDao angaa)
    {
        angaaService.addAngaa(angaa);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/angaas/{id}")
    public void updateAngaa(@RequestBody AngaaDao angaa, @PathVariable("id") Long id)
    {
        angaaService.updateAngaa(id, angaa);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/angaas/{id}")
    public void deleteAngaa(@PathVariable("id") Long id)
    {
        angaaService.deleteAngaa(id);
    }
}