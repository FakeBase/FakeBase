package org.yosa.fakebasecore.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.lang.NonNull;
import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.domain.Type;

import java.util.Date;

@Document(indexName = "news")
public class NewsEs {
    @Id
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String text;
    @NonNull
    @Field(type = FieldType.Date)
    private Date date;
    @NonNull
    @Field(type = FieldType.Nested, includeInParent = true)
    private Type type;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Account addedBy;

    public NewsEs() {
    }

    public NewsEs(@NonNull String title, @NonNull String text, @NonNull Date date, @NonNull Type type) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.type = type;
    }

    public NewsEs(@NonNull String title, @NonNull String text, @NonNull Date date, @NonNull Type type, Account addedBy) {
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
