package com.admin.saita.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Created by KaushiRajapakshe on 4/07/2021.
 */

/**
 * Feedback Database Sequences Model
 */

@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;

    private int sequence;

    public DatabaseSequence() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
