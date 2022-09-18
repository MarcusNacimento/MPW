package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Perfil;
import model.PerfilDao;

@Named(value = "perfilBean")
@SessionScoped
public class perfilBean implements Serializable {

    private Perfil perfil = new Perfil();
    private PerfilDao perfilDao = new PerfilDao();

    private Perfil selectedPerfil;
    private List<Perfil> perfils = new ArrayList<Perfil>();

    public PerfilDao getPerfilDao() {
        return perfilDao;
    }

    public void setPerfilDao(PerfilDao perfilDao) {
        this.perfilDao = perfilDao;
    }

    public Perfil getSelectedPerfil() {
        return selectedPerfil;
    }

    public void setSelectedPerfil(Perfil selectedPerfil) {
        this.selectedPerfil = selectedPerfil;
    }

    public List<Perfil> getPerfils() {
        return perfils;
    }

    public void setPerfils(List<Perfil> perfils) {
        this.perfils = perfils;
    }

    public String retorna_pagina_perfil() {
        return "index_perfil";
    }

    public String retorna_menu() {
        return "menu";

    }

    public String adicionarPerfil() {

        perfilDao.addPerfil(perfil);
        return "index_perfil";

    }

    public String removerPerfil(int id) {
        perfilDao.removerPerfil(id);

        return "index_perfil";
    }

    public List<Object> listarPerfilFull() {
        List<Object> objetosGrid;
        return objetosGrid = perfilDao.getListSQL();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil ec) {
        this.perfil = ec;
    }

    public perfilBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.perfil);
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
        final perfilBean other = (perfilBean) obj;
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        return true;
    }

}
