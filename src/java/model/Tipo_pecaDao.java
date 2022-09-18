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

public class Tipo_pecaDao implements Serializable {

    private Session sessao;
    private Transaction trans;
    private SessionFactory sessionFactory;

    // novo código aula 03
    private List<Tipo_peca> list;

    public List<Tipo_peca> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Tipo_peca.class);
        list = cri.list();
        return list;
    }

    public Tipo_peca GetById(int id) {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Tipo_peca es = new Tipo_peca();
        return es = (Tipo_peca) sessao.get(Tipo_peca.class, id);
    }

    public void addTipo_peca(Tipo_peca tipo_peca) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.save(tipo_peca);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void removerTipo_peca(int id) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();
            trans = sessao.beginTransaction();
            Tipo_peca tipo_peca = this.GetById(id);
            sessao.delete(tipo_peca);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void atualizarTipo_peca(Tipo_peca tipo_peca) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.update(tipo_peca);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("SELECT * from tipo_peca");
        return qry.list();
    }

}
