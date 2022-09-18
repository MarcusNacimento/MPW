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
import model.Peca;
import model.PecaDao;
import model.Peca_loja;
import model.Peca_lojaDao;
import model.Loja;
import model.LojaDao;
import org.primefaces.PrimeFaces;

@Named(value = "peca_lojaBean")
@SessionScoped
public class peca_lojaBean implements Serializable {

    private Peca_loja peca_loja = new Peca_loja();
    private Peca_lojaDao peca_lojaDao = new Peca_lojaDao();
    private Peca_loja selectedPeca_loja;

    private PecaDao pecaDao = new PecaDao();
    private LojaDao lojaDao = new LojaDao();

    private List<Peca_loja> peca_lojas = new ArrayList<Peca_loja>();

    private List<SelectItem> pecas;
    private List<Peca> listaPecas; //aqui coloco itens vindos do Dao

    private List<Loja> listaLojas;
    private List<SelectItem> lojas;

    public LojaDao getLojaDao() {
        return lojaDao;
    }

    public void setLojaDao(LojaDao lojaDao) {
        this.lojaDao = lojaDao;
    }

    public String retorna_pagina_peca_loja() {
        return "index_peca_loja";
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

    public List<Peca> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(List<Peca> listaPecas) {
        this.listaPecas = listaPecas;
    }

    public Peca_lojaDao getPeca_lojaDao() {
        return peca_lojaDao;
    }

    public Peca_loja getSelectedPeca_loja() {
        return selectedPeca_loja;
    }

    public List<Peca_loja> getPeca_lojas() {
        return peca_lojas;
    }

    public List<SelectItem> getPecas() {
        return pecas;

    }

    public List<SelectItem> getLojas() {
        return lojas;
    }

    public void setPeca_loja(Peca_loja peca_loja) {
        this.peca_loja = peca_loja;
    }

    public void setPeca_lojaDao(Peca_lojaDao peca_lojaDao) {
        this.peca_lojaDao = peca_lojaDao;
    }

    public void setSelectedPeca_loja(Peca_loja selectedPeca_loja) {
        this.selectedPeca_loja = selectedPeca_loja;
    }

    public void setPeca_lojas(List<Peca_loja> peca_lojas) {
        this.peca_lojas = peca_lojas;
    }

    public void setPecas(List<SelectItem> pecas) {
        this.pecas = pecas;

    }

    public void setLojas(List<SelectItem> lojas) {
        this.lojas = lojas;
    }

    public String adicionarPeca_loja() {

        peca_lojaDao.addPeca_loja(peca_loja);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_peca_loja";

    }

    public String removerPeca_loja(int id) {

        peca_lojaDao.removerPeca_loja(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_peca_loja";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarPeca_lojaFull() {
        List<Object> objetosGrid;
        return objetosGrid = peca_lojaDao.getListSQL();
    }

    public Peca_loja getPeca_loja() {
        return peca_loja;
    }

    public void setLoja(Peca_loja ec) {
        this.peca_loja = ec;
    }

    // public peca_lojaBean() {
    // }
    @PostConstruct
    public void init() {
        listaPecas = pecaDao.getList();
        pecas = popularSelectItem(listaPecas);

        listaLojas = lojaDao.getList();
        lojas = popularSelectItem2(listaLojas);

    }

    public List<SelectItem> popularSelectItem(List<Peca> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Peca obj : lista) {
            l.add(new SelectItem(obj.getId_peca(), obj.getNome()));
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.peca_loja);
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
        final peca_lojaBean other = (peca_lojaBean) obj;
        if (!Objects.equals(this.peca_loja, other.peca_loja)) {
            return false;
        }
        return true;
    }

}
