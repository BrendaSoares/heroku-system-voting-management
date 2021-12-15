package com.brendasoares.voting_session_management.model.entity;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Entity
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    @NotNull
    private String userName;

    @OneToMany(mappedBy = "associate")
    private List<Vote> votes;

    public Associate(long id, String userName, List<Vote> votes) {
        this.id = id;
        this.userName = userName;
        this.votes = votes;
    }

    public Associate() {
    }

    public Associate(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
