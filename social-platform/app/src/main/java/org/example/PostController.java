package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Button deletePostButton;

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
    private void deletePost() {
        if (post == null) {
            return;
        }

        post.clearComments();
        post = null;
        refreshView();
    }

    private void refreshView() {
        feedAccordion.getPanes().clear();
        commentsBox.getChildren().clear();

        if (post == null) {
            deletePostButton.setDisable(true);
            commentButton.setDisable(true);
            return;
        }

        deletePostButton.setDisable(false);
        commentButton.setDisable(false);

        feedAccordion.getPanes().add(createPostPane(post));
        feedAccordion.setExpandedPane(feedAccordion.getPanes().get(0));

        for (Comment comment : post.getComments()) {
            commentsBox.getChildren().add(createCommentRow(comment));
        }
    }

    private TitledPane createPostPane(Post post) {
        VBox commentsOnly = new VBox(6);
        commentsOnly.setStyle("-fx-padding: 8;");

        for (Comment comment : post.getComments()) {
            commentsOnly.getChildren().add(new Label(comment.getComment()));
        }

        return new TitledPane(post.getMessage(), commentsOnly);
    }

    private HBox createCommentRow(Comment comment) {
        Label contentLabel = new Label(comment.getComment());
        HBox.setHgrow(contentLabel, Priority.ALWAYS);

        Label dateLabel = new Label(comment.getDate());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            post.removeComment(comment);
            refreshView();
        });

        return new HBox(12, contentLabel, dateLabel, deleteButton);
    }
}
