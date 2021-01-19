package org.yosa.fakebasecore.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.Date;

@Document(collection = "news")
public class News {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String text;
    @NonNull
    private Date date;
    @NonNull
    private Type type;
    private Account addedBy;

    public News() {
    }

    public News(@NonNull String title, @NonNull String text, @NonNull Date date, @NonNull Type type) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public News(@NonNull String title, @NonNull String text, @NonNull Date date, @NonNull Type type, Account addedBy) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.type = type;
        this.addedBy = addedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public Type getType() {
        return type;
    }

    public void setType(@NonNull Type type) {
        this.type = type;
    }

    public Account getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Account addedBy) {
        this.addedBy = addedBy;
    }
}
