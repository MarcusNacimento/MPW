package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Tipo_peca;
import model.Tipo_pecaDao;

@Named(value = "tipo_pecaBean")
@SessionScoped
public class tipo_pecaBean implements Serializable {

    private Tipo_peca tipo_peca = new Tipo_peca();
    private Tipo_pecaDao tipo_pecaDao = new Tipo_pecaDao();

    private Tipo_peca selectedTipo_peca;
    private List<Tipo_peca> tipo_pecas = new ArrayList<Tipo_peca>();

    public Tipo_pecaDao getTipo_pecaDao() {
        return tipo_pecaDao;
    }

    public void setTipo_pecaDao(Tipo_pecaDao tipo_pecaDao) {
        this.tipo_pecaDao = tipo_pecaDao;
    }

    public List<Tipo_peca> getTipo_pecas() {
        return tipo_pecas;
    }

    public void setTipo_pecas(List<Tipo_peca> tipo_pecas) {
        this.tipo_pecas = tipo_pecas;
    }

    public String retorna_pagina_tipo_peca() {
        return "index_tipo_peca";
    }

    public String retorna_menu() {
        return "menu";

    }

    public String addTipo_peca() {

        tipo_pecaDao.addTipo_peca(tipo_peca);
        return "index_tipo_peca";

    }

    public Tipo_peca getSelectedTipo_peca() {
        return selectedTipo_peca;
    }

    public void setSelectedTipo_peca(Tipo_peca selectedTipo_peca) {
        this.selectedTipo_peca = selectedTipo_peca;
    }

    public String removerTipo_peca(int id) {
        tipo_pecaDao.removerTipo_peca(id);

        return "index_tipo_peca";
    }

    public List<Object> listarTipo_pecaFull() {
        List<Object> objetosGrid;
        return objetosGrid = tipo_pecaDao.getListSQL();
    }

    public Tipo_peca getTipo_peca() {
        return tipo_peca;
    }

    public void setTipo_peca(Tipo_peca ec) {
        this.tipo_peca = ec;
    }

    public tipo_pecaBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.tipo_peca);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final tipo_pecaBean other = (tipo_pecaBean) obj;
        if (!Objects.equals(this.tipo_peca, other.tipo_peca)) {
            return false;
        }
        return true;
    }

}
