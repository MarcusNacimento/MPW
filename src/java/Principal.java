
import model.Peca;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Principal {

    public static void main(String[] args) {

        Session session;//sessao hibernate
        SessionFactory sessionFactory;
        Transaction transaction = null;

        sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        session = sessionFactory.openSession();

        try {
            transaction = session.beginTransaction();

            Peca p = new Peca();

            session.save(p);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
