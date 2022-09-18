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
import model.Tipo_usuario;
import model.Tipo_usuarioDao;
import model.Usuario;
import model.UsuarioDao;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioBean")
@SessionScoped
public class usuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private UsuarioDao usuarioDao = new UsuarioDao();
    private Usuario selectedUsuario;

    private Tipo_usuarioDao tipo_usuarioDao = new Tipo_usuarioDao();

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    private List<Tipo_usuario> listaTipo_usuarios; //aqui coloco itens vindos do Dao
    private List<SelectItem> tipo_usuarios;

    public Usuario getUsuario() {
        return usuario;
    }

    public String retorna_pagina_usuario() {

        return "index_usuario";

    }

    //precisamos criar os get e set para tornar o acesso public, senão, a view não enxerga, pois inicialmente é privado
    public Tipo_usuarioDao getTipo_usuarioDao() {
        return tipo_usuarioDao;
    }

    public void setTipo_usuarioDao(Tipo_usuarioDao tipo_usuarioDao) {
        this.tipo_usuarioDao = tipo_usuarioDao;
    }

    public List<Tipo_usuario> getListaTipo_usuarios() {
        return listaTipo_usuarios;
    }

    public void setListaTipo_usuarios(List<Tipo_usuario> listaTipo_usuarios) {
        this.listaTipo_usuarios = listaTipo_usuarios;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<SelectItem> getTipo_usuarios() {
        return tipo_usuarios;

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setTipo_usuarios(List<SelectItem> tipo_usuarios) {
        this.tipo_usuarios = tipo_usuarios;

    }

    public String adicionarUsuario() {

        usuarioDao.addUsuario(usuario);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Gravados.");
        return "index_usuario";

    }

    public String removerUsuario(int id) {

        usuarioDao.removerUsuario(id);
        addMessage(FacesMessage.SEVERITY_INFO, "Confirmação", "Dados Apagados.");
        return "index_usuario";
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        PrimeFaces.current().dialog().showMessageDynamic(message);

    }

    public List<Object> listarUsuarioFull() {
        List<Object> objetosGrid;
        return objetosGrid = usuarioDao.getListSQL();
    }

    // public usuarioBean() {
    // }
    @PostConstruct
    public void init() {
        listaTipo_usuarios = tipo_usuarioDao.getList();
        tipo_usuarios = popularSelectItem(listaTipo_usuarios);

    }

    public List<SelectItem> popularSelectItem(List<Tipo_usuario> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Tipo_usuario obj : lista) {
            l.add(new SelectItem(obj.getId_tipo_usuario(), obj.getDescricao()));
        }
        return l;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.usuario);
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
        final usuarioBean other = (usuarioBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

}
