package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import model.Tipo_usuario;
import model.Tipo_usuarioDao;
import org.primefaces.PrimeFaces;

@Named(value = "tipo_usuarioBean")
@SessionScoped
public class tipo_usuarioBean implements Serializable {

    private Tipo_usuario tipo_usuario = new Tipo_usuario();
    private Tipo_usuarioDao tipo_usuarioDao = new Tipo_usuarioDao();

    private Tipo_usuario selectedTipo_usuario;
    private List<Tipo_usuario> tipo_usuarios = new ArrayList<Tipo_usuario>();

    public Tipo_usuarioDao getTipo_usuarioDao() {
        return tipo_usuarioDao;
    }

    public void setTipo_usuarioDao(Tipo_usuarioDao tipo_usuarioDao) {
        this.tipo_usuarioDao = tipo_usuarioDao;
    }

    public Tipo_usuario getSelectedTipo_usuario() {
        return selectedTipo_usuario;
    }

    public void setSelectedTipo_usuario(Tipo_usuario selectedTipo_usuario) {
        this.selectedTipo_usuario = selectedTipo_usuario;
    }

    public List<Tipo_usuario> getTipo_usuarios() {
        return tipo_usuarios;
    }

    public void setTipo_usuarios(List<Tipo_usuario> tipo_usuarios) {
        this.tipo_usuarios = tipo_usuarios;
    }

    public String retorna_pagina_tipo_usuario() {
        return "index_tipo_usuario";
    }

    public String retorna_menu() {
        return "menu";

    }

    public String adicionarTipo_usuario() {

        tipo_usuarioDao.addTipo_usuario(tipo_usuario);
        tipo_usuario.setDescricao("");
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_tipo_usuario";

    }

    public String removerTipo_usuario(int id) {

        tipo_usuarioDao.removerTipo_usuario(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_tipo_usuario";

    }

    public String atualizarTipo_usuario(Tipo_usuario tipo_usuario) {

        tipo_usuarioDao.atualizarTipo_usuario(tipo_usuario);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Atualizados.");
        return "index_tipo_usuario";

    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarTipo_usuarioFull() {
        List<Object> objetosGrid;
        return objetosGrid = tipo_usuarioDao.getListSQL();
    }

    public Tipo_usuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Tipo_usuario ec) {
        this.tipo_usuario = ec;
    }

    public tipo_usuarioBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.tipo_usuario);
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
        final tipo_usuarioBean other = (tipo_usuarioBean) obj;
        if (!Objects.equals(this.tipo_usuario, other.tipo_usuario)) {
            return false;
        }
        return true;
    }

}
