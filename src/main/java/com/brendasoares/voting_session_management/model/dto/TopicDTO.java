package com.brendasoares.voting_session_management.model.dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;


public class TopicDTO {

    @NotNull
    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
