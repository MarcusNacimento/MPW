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

public class Peca_lojaDao implements Serializable {

    private Session sessao;
    private Transaction trans;
    private SessionFactory sessionFactory;

    // novo código aula 03
    private List<Peca_loja> list;

    public List<Peca_loja> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Peca_loja.class);
        list = cri.list();
        return list;
    }

    public Peca_loja GetById(int id) {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Peca_loja es = new Peca_loja();
        return es = (Peca_loja) sessao.get(Peca_loja.class, id);
    }

    public void addPeca_loja(Peca_loja peca_loja) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.save(peca_loja);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void removerPeca_loja(int id) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();
            trans = sessao.beginTransaction();
            Peca_loja peca_loja = this.GetById(id);
            sessao.delete(peca_loja);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void atualizarPeca_loja(Peca_loja peca_loja) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.update(peca_loja);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("SELECT * from peca_loja");
        return qry.list();
    }

}
