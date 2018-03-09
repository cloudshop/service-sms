package com.eyun.cloud.service.dto;


import java.time.Instant;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.eyun.cloud.domain.enumeration.State;

/**
 * A DTO for the Message entity.
 */
public class MessageDTO implements Serializable {

    private Long id;

    private String appkey;

    private String title;

    private String content;

    private String target;

    private Instant addedtime;

    private Instant senttime;

    private Integer retries;

    private State state;

    private Long sourcenameId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Instant getAddedtime() {
        return addedtime;
    }

    public void setAddedtime(Instant addedtime) {
        this.addedtime = addedtime;
    }

    public Instant getSenttime() {
        return senttime;
    }

    public void setSenttime(Instant senttime) {
        this.senttime = senttime;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getSourcenameId() {
        return sourcenameId;
    }

    public void setSourcenameId(Long sourceId) {
        this.sourcenameId = sourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MessageDTO messageDTO = (MessageDTO) o;
        if(messageDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), messageDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
            "id=" + getId() +
            ", appkey='" + getAppkey() + "'" +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", target='" + getTarget() + "'" +
            ", addedtime='" + getAddedtime() + "'" +
            ", senttime='" + getSenttime() + "'" +
            ", retries=" + getRetries() +
            ", state='" + getState() + "'" +
            "}";
    }
}
