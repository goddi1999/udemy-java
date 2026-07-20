package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * FXML controller for the social platform UI.
 * Handles creating, editing, liking, and deleting a post,
 * as well as adding and removing comments in the feed and comments tab.
 */
public class PostController implements Initializable {

    /** Input field for creating a new post. */
    @FXML
    private TextField postInput;

    /** Button that creates a new post from {@link #postInput}. */
    @FXML
    private Button postButton;

    /** Input field for adding a comment to the current post. */
    @FXML
    private TextField commentInput;

    /** Button that adds a comment from {@link #commentInput}. */
    @FXML
    private Button commentButton;

    /** Accordion that displays the current post and its comments. */
    @FXML
    private Accordion feedAccordion;

    /** Button that opens a dialog to edit the current post. */
    @FXML
    private Button editPostButton;

    /** Button that deletes the current post and all linked comments. */
    @FXML
    private Button deletePostButton;

    /** Button that increments the like count of the current post. */
    @FXML
    private Button likePostButton;

    /** Label that shows the current like count. */
    @FXML
    private Label likesLabel;

    /** Container in the Comments tab that lists all comments. */
    @FXML
    private VBox commentsBox;

    /** The currently active post, or {@code null} if none exists. */
    private Post post;

    /**
     * Initializes the controller after FXML loading.
     * Creates a sample post with hardcoded comments and refreshes the UI.
     *
     * @param location  the location used to resolve relative paths for the root object
     * @param resources the resources used to localize the root object
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        post = new Post(
                "Just finished my JavaFX project!",
                new ArrayList<>(Arrays.asList(
                        new Comment("Looks great!"),
                        new Comment("Nice work on the Accordion."),
                        new Comment("Keep going!")
                ))
        );

        refreshView();
    }

    /**
     * Creates a new post from the post input field.
     * Replaces any existing post and clears its previous comments.
     */
    @FXML
    private void addPost() {
        String message = postInput.getText().trim();
        if (message.isEmpty()) {
            return;
        }

        post = new Post(message, new ArrayList<>());
        postInput.clear();
        refreshView();
    }

    /**
     * Adds a new comment to the current post from the comment input field.
     * Does nothing if there is no post or the input is empty.
     */
    @FXML
    private void addComment() {
        if (post == null) {
            return;
        }

        String text = commentInput.getText().trim();
        if (text.isEmpty()) {
            return;
        }

        post.addComment(new Comment(text));
        commentInput.clear();
        refreshView();
    }

    /**
     * Opens a dialog to edit the current post message.
     * Shows a warning alert if the new message is empty.
     */
    @FXML
    private void editPost() {
        if (post == null) {
            return;
        }

        TextInputDialog dialog = new TextInputDialog(post.getMessage());
        dialog.setTitle("Edit Post");
        dialog.setHeaderText("Edit your post");
        dialog.setContentText("Post:");

        dialog.showAndWait().ifPresent(newMessage -> {
            String trimmed = newMessage.trim();
            if (trimmed.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Post cannot be empty.", ButtonType.OK);
                alert.setHeaderText(null);
                alert.showAndWait();
                return;
            }

            post.setMessage(trimmed);
            refreshView();
        });
    }

    /**
     * Deletes the current post and clears all linked comments from the UI.
     */
    @FXML
    private void deletePost() {
        if (post == null) {
            return;
        }

        post.clearComments();
        post = null;
        refreshView();
    }

    /**
     * Increments the like count of the current post and updates the likes label.
     */
    @FXML
    private void likePost() {
        if (post == null) {
            return;
        }

        post.incrementLikes();
        updateLikesLabel();
    }

    /**
     * Updates the likes label to match the current post's like count.
     */
    private void updateLikesLabel() {
        if (post == null) {
            likesLabel.setText("0 likes");
            return;
        }

        likesLabel.setText(post.getLikes() + " likes");
    }

    /**
     * Rebuilds the feed accordion and comments list from the current post.
     * Disables post actions when no post exists.
     */
    private void refreshView() {
        feedAccordion.getPanes().clear();
        commentsBox.getChildren().clear();

        if (post == null) {
            editPostButton.setDisable(true);
            deletePostButton.setDisable(true);
            likePostButton.setDisable(true);
            commentButton.setDisable(true);
            updateLikesLabel();
            return;
        }

        editPostButton.setDisable(false);
        deletePostButton.setDisable(false);
        likePostButton.setDisable(false);
        commentButton.setDisable(false);
        updateLikesLabel();

        feedAccordion.getPanes().add(createPostPane(post));
        feedAccordion.setExpandedPane(feedAccordion.getPanes().get(0));

        for (Comment comment : post.getComments()) {
            commentsBox.getChildren().add(createCommentRow(comment));
        }
    }

    /**
     * Builds an accordion pane for the given post.
     * The pane title is the post message; the content lists its comments.
     *
     * @param post the post to display
     * @return a titled pane representing the post
     */
    private TitledPane createPostPane(Post post) {
        VBox commentsOnly = new VBox(8);
        commentsOnly.setPadding(new javafx.geometry.Insets(4));

        for (Comment comment : post.getComments()) {
            Label label = new Label(comment.getComment());
            label.getStyleClass().add("feed-comment");
            commentsOnly.getChildren().add(label);
        }

        return new TitledPane(post.getMessage(), commentsOnly);
    }

    /**
     * Builds a comment row for the Comments tab with text, date, and a delete button.
     *
     * @param comment the comment to display
     * @return an {@link HBox} row for the comment
     */
    private HBox createCommentRow(Comment comment) {
        Label contentLabel = new Label(comment.getComment());
        contentLabel.getStyleClass().add("comment-text");
        contentLabel.setWrapText(true);
        HBox.setHgrow(contentLabel, Priority.ALWAYS);

        Label dateLabel = new Label(comment.getDate());
        dateLabel.getStyleClass().add("comment-date");

        Button deleteButton = new Button("Delete");
        deleteButton.getStyleClass().add("button-action");
        deleteButton.setOnAction(event -> {
            post.removeComment(comment);
            refreshView();
        });

        HBox row = new HBox(12, contentLabel, dateLabel, deleteButton);
        row.setAlignment(Pos.CENTER_LEFT);
        row.getStyleClass().add("comment-row");
        return row;
    }
}
