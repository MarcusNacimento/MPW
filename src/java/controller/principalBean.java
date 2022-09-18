package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;

@Named(value = "principalBean")
@SessionScoped
public class principalBean implements Serializable {

    private Object principal;

    public String retorna_principal() {
        return "principal";

    }

    public String retorna_login() {
        return "login";

    }

    public principalBean() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.principal);
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
        final principalBean other = (principalBean) obj;
        if (!Objects.equals(this.principal, other.principal)) {
            return false;
        }
        return true;
    }

}
