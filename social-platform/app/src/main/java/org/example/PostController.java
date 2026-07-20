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

public class PostController implements Initializable {

    @FXML
    private TextField postInput;

    @FXML
    private Button postButton;

    @FXML
    private TextField commentInput;

    @FXML
    private Button commentButton;

    @FXML
    private Accordion feedAccordion;

    @FXML
    private Button editPostButton;

    @FXML
    private Button deletePostButton;

    @FXML
    private Button likePostButton;

    @FXML
    private Label likesLabel;

    @FXML
    private VBox commentsBox;

    private Post post;

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

    @FXML
    private void deletePost() {
        if (post == null) {
            return;
        }

        post.clearComments();
        post = null;
        refreshView();
    }

    @FXML
    private void likePost() {
        if (post == null) {
            return;
        }

        post.incrementLikes();
        updateLikesLabel();
    }

    private void updateLikesLabel() {
        if (post == null) {
            likesLabel.setText("0 likes");
            return;
        }

        likesLabel.setText(post.getLikes() + " likes");
    }

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
