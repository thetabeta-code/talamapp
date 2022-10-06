package com.example.talamapp.services;

import com.example.talamapp.dao.AngaaDao;
import com.example.talamapp.repositories.AngaaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AngaaService
{
    @Autowired
    private AngaaRepository angaaRepository;

    public List<AngaaDao> getAllAngaas()
    {
        List<AngaaDao> angaas = new ArrayList<>();
        angaaRepository.findAll().forEach(angaas::add);
        return angaas;
    }

    public AngaaDao getAngaa(Long id)
    {
        AngaaDao angaa = angaaRepository.findById(id).get(); //might want to return Optional<Angaa> instead of Angaa
        return angaa;
    }

    public void addAngaa(AngaaDao angaa)
    {
        angaaRepository.save(angaa);
    }

    public void updateAngaa(Long id, AngaaDao angaa)
    {
        angaaRepository.save(angaa);
    }

    public void deleteAngaa(Long id)
    {
        angaaRepository.deleteById(id);
    }
}