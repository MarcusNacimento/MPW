package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import model.Tipo_peca;
import model.Tipo_pecaDao;
import model.Perfil;
import model.PerfilDao;
import model.Loja;
import model.LojaDao;
import model.Peca;
import model.PecaDao;
import org.primefaces.PrimeFaces;

@Named(value = "pecaBean")
@SessionScoped
public class pecaBean implements Serializable {

    private Peca peca = new Peca();
    private PecaDao pecaDao = new PecaDao();
    private Peca selectedPeca;

    private Tipo_pecaDao tipo_pecaDao = new Tipo_pecaDao();
    private LojaDao lojaDao = new LojaDao();
    private PerfilDao perfilDao = new PerfilDao();

    private List<Peca> pecas = new ArrayList<Peca>();

    private List<Tipo_peca> listaTipo_pecas;
    private List<SelectItem> tipo_pecas;

    private List<Loja> listaLojas;
    private List<SelectItem> lojas;

    private List<Perfil> listaperfils;
    private List<SelectItem> perfils;

    public List<SelectItem> getPerfils() {
        return perfils;

    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setTipo_pecas(List<SelectItem> tipo_pecas) {
        this.tipo_pecas = tipo_pecas;
    }

    public PerfilDao getPerfilDao() {
        return perfilDao;
    }

    public void setPerfilDao(PerfilDao perfilDao) {
        this.perfilDao = perfilDao;
    }

    public List<Perfil> getListaperfils() {
        return listaperfils;
    }

    public void setListaperfils(List<Perfil> listaperfils) {
        this.listaperfils = listaperfils;
    }

    public void setPerfils(List<SelectItem> perfils) {
        this.perfils = perfils;
    }

    public LojaDao getLojaDao() {
        return lojaDao;
    }

    public void setLojaDao(LojaDao lojaDao) {
        this.lojaDao = lojaDao;
    }

    public String retorna_pagina_peca() {
        return "index_peca";
    }

    public List<Loja> getListaLojas() {
        return listaLojas;
    }

    public void setListaLojas(List<Loja> listaLojas) {
        this.listaLojas = listaLojas;
    }

    public PecaDao getPecaDao() {
        return pecaDao;
    }

    public void setPecaDao(PecaDao pecaDao) {
        this.pecaDao = pecaDao;
    }

    public List<Tipo_peca> getListaTipo_pecas() {
        return listaTipo_pecas;
    }

    public void setListaTipo_pecas(List<Tipo_peca> listaTipo_pecas) {
        this.listaTipo_pecas = listaTipo_pecas;
    }

    public Tipo_pecaDao getTipo_pecaDao() {
        return tipo_pecaDao;
    }

    public Peca getSelectedPeca() {
        return selectedPeca;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public List<SelectItem> getTipo_pecas() {
        return tipo_pecas;

    }

    public List<SelectItem> getLojas() {
        return lojas;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public void setTipo_pecaDao(Tipo_pecaDao tipo_pecaDao) {
        this.tipo_pecaDao = tipo_pecaDao;
    }

    public void setSelectedPeca(Peca selectedPeca) {
        this.selectedPeca = selectedPeca;
    }

    public void setLojas(List<SelectItem> lojas) {
        this.lojas = lojas;
    }

    public String adicionarPeca() {

        pecaDao.addPeca(peca);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_peca";

    }

    public String removerPeca(int id) {

        pecaDao.removerPeca(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_peca";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarPecaFull() {
        List<Object> objetosGrid;
        return objetosGrid = pecaDao.getListSQL();
    }

    public Peca getPeca() {
        return peca;
    }

    public void setLoja(Peca ec) {
        this.peca = ec;
    }

    @PostConstruct
    public void init() {
        listaTipo_pecas = tipo_pecaDao.getList();
        tipo_pecas = popularSelectItem(listaTipo_pecas);

        listaLojas = lojaDao.getList();
        lojas = popularSelectItem2(listaLojas);

        listaperfils = perfilDao.getList();
        perfils = popularSelectItem3(listaperfils);

    }

    public List<SelectItem> popularSelectItem(List<Tipo_peca> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Tipo_peca obj : lista) {
            l.add(new SelectItem(obj.getIdTipo_Peca(), obj.getDescricao()));
        }
        return l;
    }

    public List<SelectItem> popularSelectItem2(List<Loja> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Loja obj : lista) {
            l.add(new SelectItem(obj.getId_loja(), obj.getLoja()));
        }
        return l;
    }

    public List<SelectItem> popularSelectItem3(List<Perfil> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Perfil obj : lista) {
            l.add(new SelectItem(obj.getId_perfil(), obj.getPerfil()));
        }
        return l;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.peca);
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
        final pecaBean other = (pecaBean) obj;
        if (!Objects.equals(this.peca, other.peca)) {
            return false;
        }
        return true;
    }

}
