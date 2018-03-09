package com.eyun.cloud.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.eyun.cloud.domain.enumeration.State;


/**
 * A Message.
 */
@Entity
@Table(name = "message")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appkey")
    private String appkey;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "target")
    private String target;

    @Column(name = "addedtime")
    private Instant addedtime;

    @Column(name = "senttime")
    private Instant senttime;

    @Column(name = "retries")
    private Integer retries;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @ManyToOne
    private Source sourcename;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppkey() {
        return appkey;
    }

    public Message appkey(String appkey) {
        this.appkey = appkey;
        return this;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getTitle() {
        return title;
    }

    public Message title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Message content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTarget() {
        return target;
    }

    public Message target(String target) {
        this.target = target;
        return this;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Instant getAddedtime() {
        return addedtime;
    }

    public Message addedtime(Instant addedtime) {
        this.addedtime = addedtime;
        return this;
    }

    public void setAddedtime(Instant addedtime) {
        this.addedtime = addedtime;
    }

    public Instant getSenttime() {
        return senttime;
    }

    public Message senttime(Instant senttime) {
        this.senttime = senttime;
        return this;
    }

    public void setSenttime(Instant senttime) {
        this.senttime = senttime;
    }

    public Integer getRetries() {
        return retries;
    }

    public Message retries(Integer retries) {
        this.retries = retries;
        return this;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public State getState() {
        return state;
    }

    public Message state(State state) {
        this.state = state;
        return this;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Source getSourcename() {
        return sourcename;
    }

    public Message sourcename(Source source) {
        this.sourcename = source;
        return this;
    }

    public void setSourcename(Source source) {
        this.sourcename = source;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        if (message.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), message.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Message{" +
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
