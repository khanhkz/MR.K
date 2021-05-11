package com.toeic.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory ( ) {
        try {
            //create SesstionFactory on mehtod hibernate.cfg.xl
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Cannot get the hibernate object");
            throw new ExceptionInInitializerError(e);
        }


    }

    //method use extends
    public static SessionFactory getSessionFactory ( ) {
        return sessionFactory;
    }


}