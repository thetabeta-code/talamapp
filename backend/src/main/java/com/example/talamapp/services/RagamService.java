package com.example.talamapp.services;

import com.example.talamapp.dao.RagamDao;
import com.example.talamapp.repositories.RagamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RagamService
{
    @Autowired
    private RagamRepository ragamRepository;

    public List<RagamDao> getAllRagams()
    {
        List<RagamDao> ragams = new ArrayList<>();
        ragamRepository.findAll().forEach(ragams::add);
        return ragams;
    }

    public RagamDao getRagam(Long id)
    {
        RagamDao ragam = ragamRepository.findById(id).get(); //might want to return Optional<Ragam> instead of Ragam
        return ragam;
    }

    public void addRagam(RagamDao ragam)
    {
        ragamRepository.save(ragam);
    }

    public void updateRagam(Long id, RagamDao ragam)
    {
        ragamRepository.save(ragam);
    }

    public void deleteRagam(Long id)
    {
        ragamRepository.deleteById(id);
    }
}