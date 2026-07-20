package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {

    private String comment;
    private String date;

    public Comment(String comment) {
        this.comment = comment;
        this.date = getCurrentDateTime();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentDateTime(){
        LocalDateTime now = LocalDateTime.now();
        // Example output: "Monday, July 20, 2026 • 03:45 PM"
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy • hh:mm a");
        
        return now.format(customFormatter);
    }
}
