package com.example.talamapp.services;

import com.example.talamapp.dao.RagamDao;
import com.example.talamapp.dao.SongDao;
import com.example.talamapp.dao.TalamDao;
import com.example.talamapp.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<SongDao> getAllSongs() {
        List<SongDao> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    public SongDao getSong(Long id) {
        return songRepository.findById(id).get(); //might want to return Optional<Song> instead of Song
//        return song;
    }

    public List<SongDao> getSongsByTalam(TalamDao talamDao) {
        Long talamId = talamDao.getId();
        List<SongDao> songs = songRepository.findAllByTalam(talamId);
        return songs;
    }

    public List<SongDao> findAllByTalamAndRagamId(Long talamId, Long ragamId) {
        if (talamId != null && ragamId != null) {
            return songRepository.findAllByTalamIdAndRagamId(talamId, ragamId);
        } else if (talamId != null) {
            return songRepository.findAllByTalam(talamId);
        } else if (ragamId != null) {
            return songRepository.findAllByRagam(ragamId);
        } else {
            return getAllSongs();
        }
    }

    public List<SongDao> getSongsByTalamId(Long talamId) {
        List<SongDao> songs = songRepository.findAllByTalam(talamId);
        return songs;
    }

    public List<SongDao> getSongsByRagam(RagamDao ragam) {
        Long ragamId = ragam.getId();
        List<SongDao> songs = songRepository.findAllByRagam(ragamId);
        return songs;
    }

    public List<SongDao> getSongsByRagamId(Long ragamId) {
        List<SongDao> songs = songRepository.findAllByRagam(ragamId);
        return songs;
    }

    public void addOrUpdateSong(SongDao song) {
        songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}