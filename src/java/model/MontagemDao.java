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

public class MontagemDao implements Serializable {

    private Session sessao;
    private Transaction trans;
    private SessionFactory sessionFactory;

    // novo código aula 03
    private List<Montagem> list;

    public List<Montagem> getList() {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Montagem.class);
        list = cri.list();
        return list;
    }

    public Montagem GetById(int id) {
        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        sessao = sessionFactory.openSession();

        trans = sessao.beginTransaction();
        Montagem es = new Montagem();
        return es = (Montagem) sessao.get(Montagem.class, id);
    }

    public void addMontagem(Montagem montagem) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();

            sessao.save(montagem);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void removerMontagem(int id) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();
            trans = sessao.beginTransaction();
            Montagem montagem = this.GetById(id);
            sessao.delete(montagem);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public void atualizarMontagem(Montagem montagem) {

        try {

            sessionFactory = HibernateUtil.getSessionAnnotationFactory();
            sessao = sessionFactory.openSession();

            trans = sessao.beginTransaction();
            sessao.update(montagem);
            trans.commit();
        } catch (PersistenceException e) {
        } finally {
            sessao.close();
        }
    }

    public List<Object> getListSQL() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SQLQuery qry = session.createSQLQuery("Select * from montagem ");
        return qry.list();
    }

}
