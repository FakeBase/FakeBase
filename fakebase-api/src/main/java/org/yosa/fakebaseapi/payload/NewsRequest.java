package org.yosa.fakebaseapi.payload;

import org.springframework.lang.NonNull;
import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.domain.Type;

import java.util.Date;

public class NewsRequest {
    private String title;
    @NonNull
    private String text;
    @NonNull
    private String type;

    public NewsRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }
}
