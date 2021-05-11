package com.toeic.core.perssitence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class CommentEntity {
    //mappming mặc định khóa chính k tăng
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer commentId;

    @Column(name = "content")
    private String conTent;

    @Column(name = "creareddate")
    private Timestamp crearedDate;


    @ManyToOne
    @JoinColumn(name = "userid")
    private UseridEntity useridEntity;

    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenguidelineEntity listenguidelineEntity;

    public Integer getCommentId ( ) {
        return commentId;
    }

    public void setCommentId (Integer commentId) {
        this.commentId = commentId;
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

    public UseridEntity getUserid ( ) {
        return useridEntity;
    }

    public void setUserid (UseridEntity useridEntity) {
        this.useridEntity = useridEntity;
    }

    public ListenguidelineEntity getListenguideline ( ) {
        return listenguidelineEntity;
    }

    public void setListenguideline (ListenguidelineEntity listenguidelineEntity) {
        this.listenguidelineEntity = listenguidelineEntity;
    }
}
