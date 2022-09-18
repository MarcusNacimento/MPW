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
public class LoginManaged {

    private Usuario_Login usuario_Login = new Usuario_Login();

    public String doEfetuarLogin() {
        if ("adminstrador@gmail.com".equals(usuario_Login.getLogin())
                && "123".equals(usuario_Login.getSenha())) {
            /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
            return "menu";
        }
        if ("tecnico@gmail.com".equals(usuario_Login.getLogin())
                && "123".equals(usuario_Login.getSenha())) {
            /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
            return "menu";
        }
        if ("cliente@gmail.com".equals(usuario_Login.getLogin())
                && "123".equals(usuario_Login.getSenha())) {
            /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
            return "montagem";

        } else {
            /* Cria uma mensagem. */
            FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
            /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
            FacesContext.getCurrentInstance().addMessage("erro", msg);
            return null;

        }
    }

    public Usuario_Login getUsuario_Login() {
        return usuario_Login;
    }

    public void setUsuario_Login(Usuario_Login usuario_Login) {
        this.usuario_Login = usuario_Login;
    }

    public LoginManaged() {
    }

}
