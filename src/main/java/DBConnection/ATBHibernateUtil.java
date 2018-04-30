package DBConnection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

/**
 * Created by George on 08/08/2017.
 */
public class ATBHibernateUtil {

        private static final SessionFactory ourSessionFactory;

        static {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("/ATBDBHibernate.cfg.xml");
                ourSessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static StatelessSession getSession() throws HibernateException {
            return ourSessionFactory.openStatelessSession();
        }

    public static Session getNormalSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}
