/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author labinf
 */
@ManagedBean
//@Named("tela_PecaManaged")
//@ViewScoped///////
public class Tela_PecaManaged {

    private Tela_Peca tela_Peca = new Tela_Peca();

    private PecaDao pecaDao = new PecaDao();

    private List<SelectItem> pecas;
    private List<Peca> listaPecas; //aqui coloco itens vindos do Dao

    public String doPuxarlabel() {
        if ("123".equals(tela_Peca.getPlaca_de_video()) && "123".equals(tela_Peca.getProcessador()) && "123".equals(tela_Peca.getMemoria_ram()) && "123".equals(tela_Peca.getCooler())
                && "123".equals(tela_Peca.getArmazenamento()) && "123".equals(tela_Peca.getPlaca_de_video()) && "123".equals(tela_Peca.getGabinete())) {
            /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
            return "Selecionar_perfil";
        } else {
            /* Cria uma mensagem. */
            FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
            /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("erro", msg);
            return null;

        }
    }

    public Tela_Peca getTela_Peca() {
        return tela_Peca;
    }

    public void setTela_Peca(Tela_Peca tela_Peca) {
        this.tela_Peca = tela_Peca;
    }

    public Tela_PecaManaged() {
    }

    @PostConstruct
    public void init() {
        listaPecas = pecaDao.getListByIdTipoPeca(1);
        pecas = popularSelectItem(listaPecas);

    }

    public List<SelectItem> popularSelectItem(List<Peca> lista) {
        List<SelectItem> l = new ArrayList<SelectItem>();
        for (Peca obj : lista) {
            l.add(new SelectItem(obj.getId_peca(), obj.getNome()));
        }
        return l;
    }

}
