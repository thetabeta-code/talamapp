package com.example.talamapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.talamapp.dao.SongDao;
import com.example.talamapp.services.SongService;

@RestController
@CrossOrigin
class SongController
{
    @Autowired
    private SongService songService;

    @RequestMapping("/songs")
    public List<SongDao> getAllSongs()
    {
        return songService.getAllSongs();
    }

    @RequestMapping("/songs/{id}")
    public SongDao getSong(@PathVariable("id") Long id)
    {
        return songService.getSong(id);
    }

    @RequestMapping("/songs/ragam/{ragamId}")
    public List<SongDao> getSongsByRagam(@PathVariable("ragamId") Long ragamId)
    {
        return songService.getSongsByRagamId(ragamId);
    } //obsolete

    @RequestMapping("/songs/talam/{talamId}")
    public List<SongDao> getSongsByTalam(@PathVariable("talamId") Long talamId)
    {
        return songService.getSongsByTalamId(talamId);
    }//obsolete

    @RequestMapping("/songs/search")
    public List<SongDao> getSongsByTalamIdAndRagamId(@RequestParam(name = "talamId", required = false) Long talamId,
                                                     @RequestParam(name = "ragamId", required = false) Long ragamId)
    {
        return songService.findAllByTalamAndRagamId(talamId, ragamId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/songs")
    public void addSong(@RequestBody SongDao song)
    {
        songService.addOrUpdateSong(song);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/songs")
    public void updateSong(@RequestBody SongDao song)
    {
        songService.addOrUpdateSong(song);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/songs/{id}")
    public void deleteSong(@PathVariable("id") Long id)
    {
        songService.deleteSong(id);
    }
}