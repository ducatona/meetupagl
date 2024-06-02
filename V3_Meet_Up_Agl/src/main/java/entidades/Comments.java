/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "comments")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @javax.persistence.NamedQuery(name = "Comments.findByIdComment", query = "SELECT c FROM Comments c WHERE c.idComment = :idComment"),
    @javax.persistence.NamedQuery(name = "Comments.findByTimestamp", query = "SELECT c FROM Comments c WHERE c.timestamp = :timestamp")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_comment")
    private Integer idComment;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Lob
    @javax.persistence.Column(name = "content")
    private String content;
    @javax.persistence.Column(name = "timestamp")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timestamp;
    @javax.persistence.JoinColumn(name = "id_post", referencedColumnName = "id_post")
    @javax.persistence.ManyToOne(optional = false)
    private Posts idPost;
    @javax.persistence.JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser;

    public Comments() {
    }

    public Comments(Integer idComment) {
        this.idComment = idComment;
    }

    public Comments(Integer idComment, String content) {
        this.idComment = idComment;
        this.content = content;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Posts getIdPost() {
        return idPost;
    }

    public void setIdPost(Posts idPost) {
        this.idPost = idPost;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComment != null ? idComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.idComment == null && other.idComment != null) || (this.idComment != null && !this.idComment.equals(other.idComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Comments[ idComment=" + idComment + " ]";
    }
    
}
