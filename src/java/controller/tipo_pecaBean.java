package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import model.Loja;
import model.LojaDao;
import model.Tipo_peca;
import model.Tipo_pecaDao;

@Named(value = "tipo_pecaBean")
@SessionScoped
public class tipo_pecaBean implements Serializable {

    private Tipo_peca tipo_peca = new Tipo_peca();
    private Tipo_pecaDao tipo_pecaDao = new Tipo_pecaDao();
    
    private Loja loja = new Loja();
    private LojaDao lojaDao = new LojaDao();

    private List<SelectItem> selectedTipo_peca;
    private List<Tipo_peca> tipopecas;
    
    private List<SelectItem> selectedLoja;
    private List<Loja> lojas;

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public LojaDao getLojaDao() {
        return lojaDao;
    }

    public void setLojaDao(LojaDao lojaDao) {
        this.lojaDao = lojaDao;
    }

    public List<Tipo_peca> getTipopecas() {
        return tipopecas;
    }

    public void setTipopecas(List<Tipo_peca> tipopecas) {
        this.tipopecas = tipopecas;
    }

    public List<SelectItem> getSelectedLoja() {
        return selectedLoja;
    }

    public void setSelectedLoja(List<SelectItem> selectedLoja) {
        this.selectedLoja = selectedLoja;
    }

    public List<Loja> getLojas() {
        return lojas;
    }

    public void setLojas(List<Loja> lojas) {
        this.lojas = lojas;
    }
    
    

    
    
    
    
    public List<SelectItem> getSelectedTipo_peca() {
        return selectedTipo_peca;
    }

    public void setSelectedTipo_peca(List<SelectItem> selectedTipo_peca) {
        this.selectedTipo_peca = selectedTipo_peca;
    }

    
    
    public Tipo_pecaDao getTipo_pecaDao() {
        return tipo_pecaDao;
    }

    public void setTipo_pecaDao(Tipo_pecaDao tipo_pecaDao) {
        this.tipo_pecaDao = tipo_pecaDao;
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
    @PostConstruct
    public void init() {
        
        tipopecas = tipo_pecaDao.getList();
        selectedTipo_peca = popularSelectItem(tipopecas);
        
    
    }

       public List<SelectItem> popularSelectItem(List<Tipo_peca> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Tipo_peca obj : lista) {
            l.add(new SelectItem(obj.getIdTipo_Peca(), obj.getNome()));
        }
        return l;
    }
}
