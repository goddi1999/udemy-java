package org.example;

import java.util.ArrayList;

/**
 * Represents a social media post with a message, like count, and linked comments.
 * Likes start at zero and can only be changed through increment or decrement.
 */
public class Post {

    /** The text content of the post. */
    private String message;

    /** The number of likes on this post. */
    private int likes;

    /** The list of comments linked to this post. */
    private ArrayList<Comment> comments;

    /**
     * Creates a new post with the given message and comments.
     * Likes are always initialized to {@code 0}.
     *
     * @param message  the post text shown as the accordion title
     * @param comments the initial list of comments for this post
     */
    public Post(String message, ArrayList<Comment> comments) {
        this.message = message;
        this.likes = 0;
        this.comments = comments;
    }

    /**
     * Returns the post message.
     *
     * @return the current message text
     */
    public String getMessage() {
        return message;
    }

    /**
     * Updates the post message.
     *
     * @param message the new message text
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the current like count.
     *
     * @return the number of likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Increases the like count by one.
     */
    public void incrementLikes() {
        this.likes++;
    }

    /**
     * Decreases the like count by one.
     * The count will not go below zero.
     */
    public void decrementLikes() {
        if (this.likes > 0) {
            this.likes--;
        }
    }

    /**
     * Returns the list of comments linked to this post.
     *
     * @return the comments list
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Replaces the entire comments list.
     *
     * @param comments the new comments list
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Removes a single comment from this post.
     *
     * @param comment the comment to remove
     */
    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    /**
     * Adds a comment to this post.
     *
     * @param comment the comment to add
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * Removes all comments linked to this post.
     */
    public void clearComments() {
        comments.clear();
    }
}
