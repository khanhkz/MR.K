package com.toeic.core.data.daoimpl;

import com.toeic.core.common.constant.CoreConstant;
import com.toeic.core.common.utils.HibernateUtil;
import com.toeic.core.data.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;


public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private Class<T> persistenceClass;

    //create contructor replace getter and setter on the class
    public AbstractDao ( ) {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName ( ) {
        return persistenceClass.getSimpleName();
    }
//because erross public
//    protected Session getSession ( ) {
//        return HibernateUtil.getSessionFactory().openSession();
//    }

    @Override
    public List<T> findAll ( ) {
        List list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        try {
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            //trả về list
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }


        return list;
    }

    @Override
    public T update (T entity) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void save (T etity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(etity);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }


    }

    @Override
    public T findById (ID id) {
        T result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            //lấy đối tượng theo id
            result = session.get(persistenceClass, id);
            if (result == null) {
                throw new ObjectNotFoundException("Not Found " + id, null);

            }

        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }


        return result;
    }

    @Override
    public Object[] findByProperty (String property, Object value, String sortExepression, String sortDirection) {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;
        try {
            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(this.getPersistenceClassName());
            if (property != null && value != null) {
                sql1.append(" where ").append(property).append("= :value");
            }
            if (sortExepression != null && sortDirection != null) {
                sql1.append(" order by ").append(sortExepression);
                sql1.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC) ? "asc" : "desc"));
            }
            Query query = session.createQuery(sql1.toString());
            if (value != null) {
                query.setParameter("value", value);
            }

            list = query.list();
            //trả về size list
            StringBuilder sql2 = new StringBuilder("select count(*) from ");

            sql2.append(this.getPersistenceClassName());
            if (property != null && value != null) {
                sql2.append(" where ").append(property).append("= :value");
            }
            Query query1 = session.createQuery(sql2.toString());
            if (value != null) {
                query1.setParameter("value", value);
            }
            totalItem = query1.list().get(0);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }

        return new Object[]{totalItem, list};
    }

    @Override
    public Integer delete (List<ID> ids) {
        Integer cout = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (ID item : ids) {
                T t = (T) session.get(persistenceClass, item);
                session.delete(t);
                //if succsseer tăng cout
                cout++;
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return cout;
    }


}
