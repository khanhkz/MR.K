package com.toeic.core.perssitence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

//1-n =>user n
@Entity
@Table(name = "user")

public class UseridEntity {

    //mappming vừa khóa chính vừa tự tăng hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "creareddate")
    private Timestamp creareddate;


    //mappming khóa ngoại
    @ManyToOne
    @JoinColumn(name = "roleid" )
    //gọi kết nối với role bên 1 chứa roleidEntity bên user 1-n
    private RoleidEntity roleidEntity;
    ///////////////////////////////////////////////////
    @OneToMany(mappedBy = "useridEntity",fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public Integer getUserId ( ) {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getFullname ( ) {
        return fullname;
    }

    public void setFullname (String fullname) {
        this.fullname = fullname;
    }

    public Timestamp getCreareddate ( ) {
        return creareddate;
    }

    public void setCreareddate (Timestamp creareddate) {
        this.creareddate = creareddate;
    }

    public RoleidEntity getRole ( ) {
        return roleidEntity;
    }

    public void setRole (RoleidEntity role) {
        this.roleidEntity = role;
    }
}
