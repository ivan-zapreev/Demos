/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Posting {

    private Long id;
    private String title;
    private String content;
    private Date date;
    private List<Comment> comments;

    public Posting(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
    }

    public Posting(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<Comment>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
