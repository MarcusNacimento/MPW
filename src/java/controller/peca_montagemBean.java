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
import model.Peca_montagem;
import model.Peca_montagemDao;
import model.Montagem;
import model.MontagemDao;
import org.primefaces.PrimeFaces;

@Named(value = "peca_montagemBean")
@SessionScoped
public class peca_montagemBean implements Serializable {

    private Peca_montagem peca_montagem = new Peca_montagem();
    private Peca_montagemDao peca_montagemDao = new Peca_montagemDao();
    private Peca_montagem selectedPeca_montagem;

    private PecaDao pecaDao = new PecaDao();
    private MontagemDao montagemDao = new MontagemDao();
    
    private List<SelectItem> pecasPlacaMae;
    private List<Peca> listaPecasPlacaMae; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasProcessador;
    private List<Peca> listaPecasProcessador; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasMemoriaRam;
    private List<Peca> listaPecasMemoriaRam; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasCooler;
    private List<Peca> listaPecasCooler; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasArmazenamento;
    private List<Peca> listaPecasArmazenamento; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasPlacadeVideo;
    private List<Peca> listaPecasPlacadeVideo; //aqui coloco itens vindos do Dao
    
    private List<SelectItem> pecasGabinete;
    private List<Peca> listaPecasGabinete; //aqui coloco itens vindos do Dao

    public List<SelectItem> getPecasPlacaMae() {
        return pecasPlacaMae;
    }

    public void setPecasPlacaMae(List<SelectItem> pecasPlacaMae) {
        this.pecasPlacaMae = pecasPlacaMae;
    }

    public List<SelectItem> getPecasProcessador() {
        return pecasProcessador;
    }

    public void setPecasProcessador(List<SelectItem> pecasProcessador) {
        this.pecasProcessador = pecasProcessador;
    }

    public List<SelectItem> getPecasMemoriaRam() {
        return pecasMemoriaRam;
    }

    public void setPecasMemoriaRam(List<SelectItem> pecasMemoriaRam) {
        this.pecasMemoriaRam = pecasMemoriaRam;
    }

    public List<SelectItem> getPecasCooler() {
        return pecasCooler;
    }

    public void setPecasCooler(List<SelectItem> pecasCooler) {
        this.pecasCooler = pecasCooler;
    }

    public List<SelectItem> getPecasArmazenamento() {
        return pecasArmazenamento;
    }

    public void setPecasArmazenamento(List<SelectItem> pecasArmazenamento) {
        this.pecasArmazenamento = pecasArmazenamento;
    }

    public List<SelectItem> getPecasPlacadeVideo() {
        return pecasPlacadeVideo;
    }

    public void setPecasPlacadeVideo(List<SelectItem> pecasPlacadeVideo) {
        this.pecasPlacadeVideo = pecasPlacadeVideo;
    }

    public List<SelectItem> getPecasGabinete() {
        return pecasGabinete;
    }

    public void setPecasGabinete(List<SelectItem> pecasGabinete) {
        this.pecasGabinete = pecasGabinete;
    }
    
    
    
    

    private List<Peca_montagem> peca_montagems = new ArrayList<Peca_montagem>();

    

    private List<Montagem> listaMontagems;
    private List<SelectItem> montagems;

    public MontagemDao getMontagemDao() {
        return montagemDao;
    }

    public void setMontagemDao(MontagemDao montagemDao) {
        this.montagemDao = montagemDao;
    }

    public String retorna_pagina_peca_montagem() {
        return "index_peca_montagem";
    }

    public List<Montagem> getListaMontagems() {
        return listaMontagems;
    }

    public void setListaMontagems(List<Montagem> listaMontagems) {
        this.listaMontagems = listaMontagems;
    }

    public PecaDao getPecaDao() {
        return pecaDao;
    }

    public void setPecaDao(PecaDao pecaDao) {
        this.pecaDao = pecaDao;
    }

    

    public Peca_montagemDao getPeca_montagemDao() {
        return peca_montagemDao;
    }

    public Peca_montagem getSelectedPeca_montagem() {
        return selectedPeca_montagem;
    }

    public List<Peca_montagem> getPeca_montagems() {
        return peca_montagems;
   
    }

    public List<SelectItem> getMontagems() {
        return montagems;
    }

    public void setPeca_montagem(Peca_montagem peca_montagem) {
        this.peca_montagem = peca_montagem;
    }

    public void setPeca_montagemDao(Peca_montagemDao peca_montagemDao) {
        this.peca_montagemDao = peca_montagemDao;
    }

    public void setSelectedPeca_montagem(Peca_montagem selectedPeca_montagem) {
        this.selectedPeca_montagem = selectedPeca_montagem;
    }

    public void setPeca_montagems(List<Peca_montagem> peca_montagems) {
        this.peca_montagems = peca_montagems;
    }

   

    public void setMontagems(List<SelectItem> montagems) {
        this.montagems = montagems;
    }

    public String adicionarPeca_montagem() {

        peca_montagemDao.addPeca_montagem(peca_montagem);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_peca_montagem";

    }

    public String removerPeca_montagem(int id) {

        peca_montagemDao.removerPeca_montagem(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_peca_montagem";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarPeca_montagemFull() {
        List<Object> objetosGrid;
        return objetosGrid = peca_montagemDao.getListSQL();
    }

    public Peca_montagem getPeca_montagem() {
        return peca_montagem;
    }

    public void setMontagem(Peca_montagem ec) {
        this.peca_montagem = ec;
    }

    @PostConstruct
    public void init() {
        listaPecasPlacaMae = pecaDao.getListByIdTipoPeca(1);
        pecasPlacaMae = popularSelectItem(listaPecasPlacaMae);
        ///////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        listaPecasProcessador = pecaDao.getListByIdTipoPeca(3);
        pecasProcessador = popularSelectItem(listaPecasProcessador);
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
       // listaPecasPlacaMae = pecaDao.getListByIdTipoPeca(1);
       // pecasPlacaMae = popularSelectItem(listaPecasPlacaMae);
        ///////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        //listaPecasProcessador = pecaDao.getListByIdTipoPeca(3);
        //pecasProcessador = popularSelectItem(listaPecasProcessador);
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //listaPecasPlacaMae = pecaDao.getListByIdTipoPeca(1);
        //pecasPlacaMae = popularSelectItem(listaPecasPlacaMae);
        ///////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        //listaPecasProcessador = pecaDao.getListByIdTipoPeca(3);
       // pecasProcessador = popularSelectItem(listaPecasProcessador);
        //////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////
        //listaPecasPlacaMae = pecaDao.getListByIdTipoPeca(1);
        //pecasPlacaMae = popularSelectItem(listaPecasPlacaMae);
        ///////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////
        
        

        listaMontagems = montagemDao.getList();
        montagems = popularSelectItem2(listaMontagems);

    }

    public List<SelectItem> popularSelectItem(List<Peca> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Peca obj : lista) {
            l.add(new SelectItem(obj.getId_peca(), obj.getNome()));
        }
        return l;
    }

    public List<SelectItem> popularSelectItem2(List<Montagem> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Montagem obj : lista) {
            l.add(new SelectItem(obj.getId_montagem(), obj.getData_montagem()));
        }
        return l;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.peca_montagem);
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
        final peca_montagemBean other = (peca_montagemBean) obj;
        if (!Objects.equals(this.peca_montagem, other.peca_montagem)) {
            return false;
        }
        return true;
    }

}
