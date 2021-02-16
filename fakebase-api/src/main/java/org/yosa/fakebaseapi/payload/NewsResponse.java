package org.yosa.fakebaseapi.payload;

import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.domain.Type;

import java.util.Date;

public class NewsResponse {
    private String id;
    private String title;
    private String text;
    private Date date;
    private Type type;
    private Account addedBy;

    public NewsResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Account getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Account addedBy) {
        this.addedBy = addedBy;
    }
}
