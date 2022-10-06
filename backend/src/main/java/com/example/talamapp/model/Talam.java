package com.example.talamapp.model;

import java.util.List;

public class Talam
{
    private Long id;

    private String name;

    private List<Angaa> angaas;
    
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

    public List<Angaa> getAngaas() {
        return this.angaas;
    }

    public void setAngaas(List<Angaa> angaas) {
        this.angaas = angaas;
    }
}