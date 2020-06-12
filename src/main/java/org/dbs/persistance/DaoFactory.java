package org.dbs.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DaoFactory {
    private static  SessionFactory sessionFactory = null;
    private static  StandardServiceRegistry registry = null;

    public static IDaoPerson getPersonDao() { return new DaoPersonImpl(); }

    public static SessionFactory giveSessionFactory() throws Exception {
        if (sessionFactory == null) {
            registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception exception) {
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                throw new JPAException(exception.getMessage());
            }
        }
        return sessionFactory;
    }

    public static Session getSession() throws JPAException {
        try {
            return giveSessionFactory().openSession();
        } catch (Exception exception) {
            throw new JPAException(exception.getMessage());
        }
    }

}
