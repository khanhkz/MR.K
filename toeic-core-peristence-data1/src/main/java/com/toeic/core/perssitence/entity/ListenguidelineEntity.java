package com.toeic.core.perssitence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguideline")
public class ListenguidelineEntity {
    //mappming vừa khóa chính vừa tự tăng hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer listenguidelineid;
    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String iMage;

    @Column(name = "content")
    private String conTent;

    @Column(name = "creareddate")
    private Timestamp crearedDate;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "listenguidelineEntity",fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public List<CommentEntity> getCommentList ( ) {
        return commentEntityList;
    }

    public void setCommentList (List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public Integer getListenguidelineid ( ) {
        return listenguidelineid;
    }

    public void setListenguidelineid (Integer listenguidelineid) {
        this.listenguidelineid = listenguidelineid;
    }

    public String getTitle ( ) {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getiMage ( ) {
        return iMage;
    }

    public void setiMage (String iMage) {
        this.iMage = iMage;
    }

    public String getConTent ( ) {
        return conTent;
    }

    public void setConTent (String conTent) {
        this.conTent = conTent;
    }

    public Timestamp getCrearedDate ( ) {
        return crearedDate;
    }

    public void setCrearedDate (Timestamp crearedDate) {
        this.crearedDate = crearedDate;
    }

    public Timestamp getModifiedDate ( ) {
        return modifiedDate;
    }

    public void setModifiedDate (Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
