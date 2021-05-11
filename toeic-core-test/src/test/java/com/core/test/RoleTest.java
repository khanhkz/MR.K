package com.core.test;

import com.toeic.core.dao.RoleDao;
import com.toeic.core.impl.RoleDaoimpl;
import com.toeic.core.perssitence.entity.RoleidEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {

    @Test
    public void checkFindAll ( ) {
        //create method interface chiled
        //because inrterface không khởi tạo chính nó phải khởi tạo đối tượng implements của nó
        RoleDao dao = new RoleDaoimpl();
        List<RoleidEntity> list = dao.findAll();
    }

    @Test
    public void checkUpdate ( ) {
        RoleDao roleDao = new RoleDaoimpl();
        RoleidEntity entity = new RoleidEntity();
        entity.setRoleId(2);
        entity.setName("User");
        roleDao.update(entity);
    }

    @Test
    public void checkSave ( ) {
        RoleDao roleDao = new RoleDaoimpl();
        RoleidEntity entity = new RoleidEntity();
        entity.setRoleId(1);
        entity.setName("ADMIN");
        RoleidEntity entity1 = new RoleidEntity();
        entity1.setRoleId(2);
        entity1.setName("USER");
        roleDao.update(entity);
        roleDao.update(entity1);
    }

    @Test
    public void checkFindByID ( ) {
        RoleDao roleDao = new RoleDaoimpl();
        RoleidEntity entity = roleDao.findById(1);

    }

    @Test
    public void checkFindProperty ( ) {
        RoleDao roleDao = new RoleDaoimpl();
        //nhập null all <=> findAll
        String property = null;
        String value = null;
        String sortExpression = null;
        String sortDirection = null;
        Object[] objects = roleDao.findByProperty(property, value, sortExpression, sortDirection);
    }

    @Test
    public void checkDelete ( ) {
        //xóa theo list phải khơi tạo
        List<Integer> listId = new ArrayList<Integer>();
        listId.add(1);
        listId.add(2);
        listId.add(3);
        RoleDao roleDao = new RoleDaoimpl();
        Integer count = roleDao.delete(listId);
    }
}





