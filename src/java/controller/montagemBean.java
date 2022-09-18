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
import model.Usuario;
import model.UsuarioDao;
import model.Montagem;
import model.MontagemDao;
import org.primefaces.PrimeFaces;

@Named(value = "montagemBean")
@SessionScoped
public class montagemBean implements Serializable {

    private Montagem montagem = new Montagem();
    private MontagemDao montagemDao = new MontagemDao();
    private Montagem selectedMontagem;
    private UsuarioDao usuarioDao = new UsuarioDao();
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private List<Montagem> montagems = new ArrayList<Montagem>();

    private List<Usuario> listaUsuarios; //aqui coloco itens vindos do Dao
    private List<SelectItem> usuarios;

    public String retorna_pagina_montagem() {
        return "index_montagem";
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public MontagemDao getMontagemDao() {
        return montagemDao;
    }

    public Montagem getSelectedMontagem() {
        return selectedMontagem;
    }

    public List<Montagem> getMontagems() {
        return montagems;
    }

    public List<SelectItem> getUsuarios() {
        return usuarios;

    }

    public void setMontagem(Montagem montagem) {
        this.montagem = montagem;
    }

    public void setMontagemDao(MontagemDao montagemDao) {
        this.montagemDao = montagemDao;
    }

    public void setSelectedMontagem(Montagem selectedMontagem) {
        this.selectedMontagem = selectedMontagem;
    }

    public void setMontagems(List<Montagem> montagems) {
        this.montagems = montagems;
    }

    public void setUsuarios(List<SelectItem> usuarios) {
        this.usuarios = usuarios;

    }

    public String addMontagem() {

        montagemDao.addMontagem(montagem);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_montagem";

    }

    public String removerMontagem(int id) {

        montagemDao.removerMontagem(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_montagem";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarMontagemFull() {
        List<Object> objetosGrid;
        return objetosGrid = montagemDao.getListSQL();
    }

    public Montagem getMontagem() {
        return montagem;
    }

    public void setUsuario(Montagem ec) {
        this.montagem = ec;
    }

    // public montagemBean() {
    // }
    @PostConstruct
    public void init() {
        listaUsuarios = usuarioDao.getList();
        usuarios = popularSelectItem(listaUsuarios);

        //aqui não é usuarios?
        //isso, peças é só em usuario_montagem
    }

    public List<SelectItem> popularSelectItem(List<Usuario> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Usuario obj : lista) {
            l.add(new SelectItem(obj.getIdUsuario(), obj.getNome() + "--" + obj.getDescricao()));

            //era para aparecer o getusuario né?
        }
        return l;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.montagem);
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
        final montagemBean other = (montagemBean) obj;
        if (!Objects.equals(this.montagem, other.montagem)) {
            return false;
        }
        return true;
    }

}
