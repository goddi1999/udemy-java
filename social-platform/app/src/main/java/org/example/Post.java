package org.example;

import java.util.ArrayList;

public class Post {

    private String message;
    private int likes;
    private ArrayList<Comment> comments;

    public Post(String message, ArrayList<Comment> comments) {
        this.message = message;
        this.likes = 0;
        this.comments = comments;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void incrementLikes() {
        this.likes++;
    }

    public void decrementLikes() {
        if (this.likes > 0) {
            this.likes--;
        }
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void clearComments() {
        comments.clear();
    }
}
