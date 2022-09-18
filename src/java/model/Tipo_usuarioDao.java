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

public class Tipo_usuarioDao implements Serializable {

    private Session sessao;
    private Transaction trans;
    private SessionFactory sessionFactory;

    // novo código aula 03
    private List<Tipo_usuario> list;

    public List<Tipo_usuario> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Tipo_usuario.class);
        list = cri.list();
        return list;
    }

    public Tipo_usuario GetById(int id) {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Tipo_usuario es = new Tipo_usuario();
        return es = (Tipo_usuario) sessao.get(Tipo_usuario.class, id);
    }

    public void addTipo_usuario(Tipo_usuario tipo_usuario) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.save(tipo_usuario);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void removerTipo_usuario(int id) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();
            trans = sessao.beginTransaction();
            Tipo_usuario tipo_usuario = this.GetById(id);
            sessao.delete(tipo_usuario);
            trans.commit();

        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void atualizarTipo_usuario(Tipo_usuario tipo_usuario) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.update(tipo_usuario);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("SELECT * from tipo_usuario");
        return qry.list();
    }

}
