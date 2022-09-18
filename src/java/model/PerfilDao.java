package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PerfilDao implements Serializable {

    private Session sessao;
    private Transaction trans;
    private SessionFactory sessionFactory;

    // novo código aula 03
    private List<Perfil> list;

    public List<Perfil> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Perfil.class);
        list = cri.list();
        return list;
    }

    public Perfil GetById(int id) {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Perfil es = new Perfil();
        return es = (Perfil) sessao.get(Perfil.class, id);
    }

    public void addPerfil(Perfil perfil) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.save(perfil);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void removerPerfil(int id) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();
            trans = sessao.beginTransaction();
            Perfil perfil = this.GetById(id);
            sessao.delete(perfil);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void atualizarPerfil(Perfil perfil) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.update(perfil);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("SELECT * from perfil");
        return qry.list();
    }

}
