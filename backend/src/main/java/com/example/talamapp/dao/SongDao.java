package com.example.talamapp.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "song")
public class SongDao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(nullable = false, name = "notes")
    private String notes;

    @Column(name = "talam_id")
    private Long talamId;

    @Column(name = "ragam_id")
    private Long ragamId;

    @ManyToOne
    @JoinColumn(name = "talam_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TalamDao talamDao;

    @ManyToOne
    @JoinColumn(name = "ragam_id", referencedColumnName = "id", insertable = false, updatable = false)
    private RagamDao ragamDao;


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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TalamDao getTalamDao() {
        return this.talamDao;
    }

    public void setTalamDao(TalamDao talamDao) {
        this.talamDao = talamDao;
    }

    public RagamDao getRagamDao() {
        return this.ragamDao;
    }

    public void setRagamDao(RagamDao ragamDao) {
        this.ragamDao = ragamDao;
    }

    public Long getTalamId() {
        return talamId;
    }

    public void setTalamId(Long talamId) {
        this.talamId = talamId;
    }

    public Long getRagamId() {
        return ragamId;
    }

    public void setRagamId(Long ragamId) {
        this.ragamId = ragamId;
    }
}