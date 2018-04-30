package DBConnection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

/**
 * Created by George on 21/11/2017.
 */
public class SunHotelsMainServerHibernateUtil {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/SunHotelsMainServer.cfg.xml");
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static StatelessSession getSession() throws HibernateException {
        return ourSessionFactory.openStatelessSession();
    }
    public static Session getSessiongetNonStatlessSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
