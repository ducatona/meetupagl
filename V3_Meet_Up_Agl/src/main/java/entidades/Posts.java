/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "posts")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p"),
    @javax.persistence.NamedQuery(name = "Posts.findByIdPost", query = "SELECT p FROM Posts p WHERE p.idPost = :idPost"),
    @javax.persistence.NamedQuery(name = "Posts.findByTimestamp", query = "SELECT p FROM Posts p WHERE p.timestamp = :timestamp")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_post")
    private Integer idPost;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Lob
    @javax.persistence.Column(name = "content")
    private String content;
    @javax.persistence.Column(name = "timestamp")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timestamp;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idPost")
    private Collection<Comments> commentsCollection;
    @javax.persistence.JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser;

    public Posts() {
    }

    public Posts(Integer idPost) {
        this.idPost = idPost;
    }

    public Posts(Integer idPost, String content) {
        this.idPost = idPost;
        this.content = content;
    }

    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
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

    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
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
        hash += (idPost != null ? idPost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.idPost == null && other.idPost != null) || (this.idPost != null && !this.idPost.equals(other.idPost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Posts[ idPost=" + idPost + " ]";
    }
    
}
