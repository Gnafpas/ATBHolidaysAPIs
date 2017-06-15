package DB_Connection;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by George on 15/06/2017.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            System.out.print("*****************************************************");
            Configuration configuration = new Configuration();
            System.out.print("**********************************6666666666666666666666");
            configuration.configure();
            System.out.print("********************************121212121212121212121212121");

            ourSessionFactory = configuration.buildSessionFactory();
            System.out.print("********************************34343343434343434344343434343");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }




//    static {
//        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml)
//            // config file.
//            System.out.print("*****************************************************");
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            System.out.print("*********************************13131313131131131313131");
//            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//            System.out.print("*****************************************121212122121212121212");
//            ourSessionFactory = configuration.buildSessionFactory(ssrb.build());
//            System.out.print("***********************************565556565656565656");
//        } catch (Throwable ex) {
//            // Log the exception.
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        System.out.print("*****************************************************");
//        return ourSessionFactory;
//    }

//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }
}