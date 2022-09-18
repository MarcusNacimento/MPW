/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author labinf
 */
@ManagedBean
public class LojaManaged {

    public String doEscolherLoja() {

        return "Selecionar_perfil";

    }

    public LojaManaged() {
    }

}
