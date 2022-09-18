package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;

@Named(value = "menuBean")
@SessionScoped
public class menuBean implements Serializable {

    private Object menu;

    public String retorna_menu() {
        return "menu";

    }

    public String retorna_login() {
        return "login";

    }

    public menuBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.menu);
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
        final menuBean other = (menuBean) obj;
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        return true;
    }

}
