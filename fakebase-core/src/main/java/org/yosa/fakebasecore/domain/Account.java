package org.yosa.fakebasecore.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.Set;

@Document(collection = "account")
public class Account {
    @Id
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private String token;
    @NonNull
    private Date regDate;
    @NonNull
    private Set<Role> roles;

    public Account() {
    }

    public Account(@NonNull String username, @NonNull String email, @NonNull String password, @NonNull Date regDate, @NonNull Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @NonNull
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(@NonNull Date regDate) {
        this.regDate = regDate;
    }

    @NonNull
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(@NonNull Set<Role> roles) {
        this.roles = roles;
    }
}
