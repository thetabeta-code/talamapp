package com.example.talamapp.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "talam_angaa")
public class MapTalamAngaaDao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "talam_id")
    private Long talamId;

    @Column(name = "angaa_id")
    private Long angaaId;

    @ManyToOne
    @JoinColumn(name = "talam_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TalamDao talamDao;  

    @ManyToOne
    @JoinColumn(name = "angaa_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AngaaDao angaaDao;

    @Column(nullable = false, name = "sequence")
    private int sequence;

    public MapTalamAngaaDao() {

    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TalamDao getTalamDao() {
        return this.talamDao;
    }

    public void setTalamDao(TalamDao talamDao) {
        this.talamDao = talamDao;
    }

    public AngaaDao getAngaaDao() {
        return this.angaaDao;
    }

    public void setAngaaDao(AngaaDao angaaDao) {
        this.angaaDao = angaaDao;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Long getTalamId() {
        return talamId;
    }

    public void setTalamId(Long talamId) {
        this.talamId = talamId;
    }

    public Long getAngaaId() {
        return angaaId;
    }

    public void setAngaaId(Long angaaId) {
        this.angaaId = angaaId;
    }

    public MapTalamAngaaDao(Long talamId, Long angaaId, TalamDao talamDao, AngaaDao angaaDao, int sequence) {
        this.talamId = talamId;
        this.angaaId = angaaId;
        this.talamDao = talamDao;
        this.angaaDao = angaaDao;
        this.sequence = sequence;
    }
    
}