package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.Loja;
import model.LojaDao;

@Named(value = "lojaBean")
@SessionScoped
public class lojaBean implements Serializable {

    private Loja loja = new Loja();
    private LojaDao lojaDao = new LojaDao();

    private Loja selectedLoja;
    private List<Loja> lojas = new ArrayList<Loja>();

    public LojaDao getLojaDao() {
        return lojaDao;
    }

    public void setLojaDao(LojaDao lojaDao) {
        this.lojaDao = lojaDao;
    }

    public Loja getSelectedLoja() {
        return selectedLoja;
    }

    public void setSelectedLoja(Loja selectedLoja) {
        this.selectedLoja = selectedLoja;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }

    public String retorna_pagina_loja() {
        return "index_loja";
    }

    public String retorna_menu() {
        return "menu";

    }

    public String adicionarLoja() {

        lojaDao.addLoja(loja);
        return "index_loja";

    }

    public String removerLoja(int id) {
        lojaDao.removerLoja(id);

        return "index_loja";
    }

    public List<Object> listarLojaFull() {
        List<Object> objetosGrid;
        return objetosGrid = lojaDao.getListSQL();
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja ec) {
        this.loja = ec;
    }

    public lojaBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.loja);
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
        final lojaBean other = (lojaBean) obj;
        if (!Objects.equals(this.loja, other.loja)) {
            return false;
        }
        return true;
    }

}
