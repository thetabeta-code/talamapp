package com.example.talamapp.services;

import com.example.talamapp.dao.*;
import com.example.talamapp.model.Angaa;
import com.example.talamapp.model.Talam;
import com.example.talamapp.repositories.MapTalamAngaaRepository;
import com.example.talamapp.repositories.TalamRepository;
import com.example.talamapp.utils.ComparatorTalamAngaa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TalamService
{
    @Autowired
    private TalamRepository talamRepository;

    @Autowired
    private MapTalamAngaaService mapTalamAngaaService;

    @Autowired
    private MapTalamAngaaRepository mapTalamAngaaRepository;

    public List<Talam> getAllTalams()
    {
        List<Talam> talams = new ArrayList<>();
        List<TalamDao> talamDaos = (List<TalamDao>) talamRepository.findAll();
        List<MapTalamAngaaDao> mapTalamAngaaDaos= mapTalamAngaaService.getAllMapTalamAngaas();
        for(TalamDao talamDao:talamDaos)
        {
            Talam talam = convertTalamDaoToTalam(talamDao);
            List<MapTalamAngaaDao> mapTalamAngaasOfTalam = new ArrayList<>();
            List<Angaa> angaasOfTalam = new ArrayList<>();
            mapTalamAngaaDaos.stream() //give all mappings one by one
                    .filter(mapTalamAngaaDao -> (talam.getId()).equals(mapTalamAngaaDao.getTalamId())) //check if the talam id of the mapping matches
                    .forEach(mapTalamAngaasOfTalam::add);//add mapping to the list of mappings for each one that matches
            for(MapTalamAngaaDao mapTalamAngaaDao : mapTalamAngaasOfTalam)
            {
                AngaaDao angaaDao = mapTalamAngaaDao.getAngaaDao();
                Angaa angaa = new Angaa();
                BeanUtils.copyProperties(angaaDao, angaa);
                angaasOfTalam.add(angaa);
            }
            talam.setAngaas(angaasOfTalam);
            talams.add(talam);
        }
        return talams;
    }

    public Talam getTalam(Long id)
    {
        //From maptalamangaaservice.findbytalamid, find all objects that match talam id DONE
        //Loop through maptalamangaas and add angaas by sequence number
        //populate the talam object with angaas (initialize the talam model object with angaas)
        //utility 1 - take talamdao and return talam DONE
        //utility 2 - take angaadao and return angaa DONE

        TalamDao talamDao = talamRepository.findById(id).get();

        Talam talam = convertTalamDaoToTalam(talamDao);

        List<MapTalamAngaaDao> mapTalamAngaaDaos = mapTalamAngaaService.getMapTalamAngaasbyTalamId(id);
        List<Angaa> angaas = new ArrayList<>();
        for (MapTalamAngaaDao mapTalamAngaaDao: mapTalamAngaaDaos) {
            Angaa angaa = new Angaa();
            BeanUtils.copyProperties(mapTalamAngaaDao.getAngaaDao(), angaa);
            angaas.add(angaa);
        }

//        Collections.sort(mapTalamAngaaDaos, new ComparatorTalamAngaa(MapTalamAngaaDao));
//        Angaa[] angaaArray = new Angaa[mapTalamAngaaDaos.size() ];
//        for(int i = 0; i < mapTalamAngaaDaos.size(); i++)
//        {
//            MapTalamAngaaDao mapTalamAngaaDao = mapTalamAngaaDaos.get(i);
//            int sequence = mapTalamAngaaDao.getSequence();
//            AngaaDao angaaDao = mapTalamAngaaDao.getAngaaDao();
//            Angaa angaa = convertAngaaDaoToAngaa(angaaDao);
//            angaaArray[sequence - 1] = angaa;
//        }

//        List<Angaa> angaas = Arrays.asList(angaaArray);

        talam.setAngaas(angaas);
        
        return talam;
    }

    public void addTalam(Talam talam)
    {
        TalamDao talamDao = convertTalamToTalamDao(talam);

        TalamDao savedTalam = talamRepository.save(talamDao);
        Long talamId = savedTalam.getId();
        List<Angaa> angaas = talam.getAngaas();
 
        for (int i = 0; i < angaas.size(); i++) 
        {
            Angaa angaa = angaas.get(i);
            AngaaDao angaaDao = convertAngaaToAngaaDao(angaa);
            Long angaaId = angaaDao.getId();
            MapTalamAngaaDao mapTalamAngaa = new MapTalamAngaaDao(talamId, angaaId, talamDao, angaaDao, i+1);
            //mapTalamAngaaService.addMapTalamAngaa(mapTalamAngaa);
            mapTalamAngaaRepository.save(mapTalamAngaa);

        }
    }

    public void updateTalam( Talam talam)
    {
        List<MapTalamAngaaDao> mapTalamAngaas = mapTalamAngaaService.getMapTalamAngaasbyTalamId(talam.getId());
        for (int i = 0; i < mapTalamAngaas.size(); i++) 
        {
            MapTalamAngaaDao mapTalamAngaa = mapTalamAngaas.get(i);
            Long mapTalamAngaaId = mapTalamAngaa.getId();
            //mapTalamAngaaService.deleteMapTalamAngaa(mapTalamAngaaId);
            mapTalamAngaaRepository.deleteById(mapTalamAngaaId);
        }
        TalamDao talamDao = convertTalamToTalamDao(talam);
        Long talamId = talamDao.getId();
        talamRepository.save(talamDao);
//@TODO
        List<Angaa> angaas = talam.getAngaas();
 
        for (int i = 0; i < angaas.size(); i++) 
        {
            Angaa angaa = angaas.get(i);
            AngaaDao angaaDao = convertAngaaToAngaaDao(angaa);
            Long angaaId = angaaDao.getId();
            MapTalamAngaaDao mapTalamAngaa = new MapTalamAngaaDao(talamId, angaaId, talamDao, angaaDao, i+1);
            //mapTalamAngaaService.addMapTalamAngaa(mapTalamAngaa);
            mapTalamAngaaRepository.save(mapTalamAngaa);
        }
    }

    public void deleteTalam(Long id)
    {
        if(mapTalamAngaaService.getMapTalamAngaasbyTalamId(id).size() > 0)
        {
            List<MapTalamAngaaDao> mapTalamAngaas = mapTalamAngaaService.getMapTalamAngaasbyTalamId(id);
            for (int i = 0; i < mapTalamAngaas.size(); i++) 
            {
                MapTalamAngaaDao mapTalamAngaa = mapTalamAngaas.get(i);
                Long mapTalamAngaaId = mapTalamAngaa.getId();
                //mapTalamAngaaService.deleteMapTalamAngaa(mapTalamAngaaId);
                mapTalamAngaaRepository.deleteById(mapTalamAngaaId);
            }

            talamRepository.deleteById(id);
        }
        else
        {
            talamRepository.deleteById(id);
        }
    }

    public TalamDao convertTalamToTalamDao(Talam talam)
    {
        TalamDao talamDao = new TalamDao();
        if(talam.getId() != null)
        {
            talamDao.setId(talam.getId());
        }
        talamDao.setName(talam.getName());
        return talamDao;
    }

    public Talam convertTalamDaoToTalam(TalamDao talamDao)
    {
        Talam talam = new Talam();
        if(talamDao.getId() != null)
        {
            talam.setId(talamDao.getId());
        }
        talam.setName(talamDao.getName());
        return talam;
    }

    public AngaaDao convertAngaaToAngaaDao(Angaa angaa)
    {
        AngaaDao angaaDao = new AngaaDao();
        if(angaa.getId() != null)
        {
            angaaDao.setId(angaa.getId());
        }
        angaaDao.setName(angaa.getName());
        return angaaDao;
    }

    public Angaa convertAngaaDaoToAngaa(AngaaDao angaaDao)
    {
        Angaa angaa = new Angaa();
        if(angaaDao.getId() != null)
        {
            angaa.setId(angaaDao.getId());
        }
        angaa.setName(angaaDao.getName());

        return angaa;
    }
}