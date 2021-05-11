package com.toeic.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
    T update(T entity);
    void save(T etity);
    T findById(ID id);
    Object []findByProperty(String property,Object value,String sortExepression,String sortDirection);
    Integer delete(List<ID> ids);
}
