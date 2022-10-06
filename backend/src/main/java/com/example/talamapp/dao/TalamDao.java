package com.example.talamapp.dao;

//import java.util.List;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
//import javax.persistence.ManyToMany;

@Entity(name = "talam")
public class TalamDao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    // @OneToMany(mappedBy="song")
    // @JoinColumn()
    // private List<Song> songs;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public List<Angaa> getAngaas() {
    //     return this.angaas;
    // }

    // public void setAngaas(List<Angaa> angaas) {
    //     this.angaas = angaas;
    // }

    // public List<Song> getSong() {
    //     return this.songs;
    // }

    // public void setSong(List<Song> songs) {
    //     this.songs = songs;
    // }
}