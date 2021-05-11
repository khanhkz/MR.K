package com.toeic.core.perssitence.entity;


import javax.persistence.*;
import java.util.List;

// qh 1-n =>role 1
@Entity
@Table(name = "role")
public class RoleidEntity {
    //mappming mặc định khóa chính k tăng
    @Id
    @Column(name = "roleid")
    private Integer roleId;

    @Column(name = "name")
    private String name;
    //mapby đúng qh role biến role table userid
    //phải báo 1 list userid map đúng qh user

    public List<UseridEntity> getUserList ( ) {
        return userList;
    }

    public void setUserList (List<UseridEntity> userList) {
        this.userList = userList;
    }

    @OneToMany(mappedBy = "roleidEntity", fetch = FetchType.LAZY)
    private List<UseridEntity> userList;


    public Integer getRoleId ( ) {
        return roleId;
    }

    public void setRoleId (Integer roleId) {
        this.roleId = roleId;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
