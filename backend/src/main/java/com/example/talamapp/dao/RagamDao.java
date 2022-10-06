package com.example.talamapp.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.OneToMany;

@Entity(name = "ragam")
public class RagamDao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "arohana")
    private String arohana;

    @Column(nullable = false, name = "avarohana")
    private String avarohana;

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

    public String getArohana() {
        return this.arohana;
    }

    public void setArohana(String arohana) {
        this.arohana = arohana;
    }

    public String getAvarohana() {
        return this.avarohana;
    }

    public void setAvarohana(String avarohana) {
        this.avarohana = avarohana;
    }

    // public Song getSong() {
    //     return this.song;
    // }

    // public void setSong(Song song) {
    //     this.song = song;
    // }
}