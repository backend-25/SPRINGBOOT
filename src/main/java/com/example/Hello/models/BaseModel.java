package com.example.Hello.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class BaseModel
{
    private long Id;
    private Date CreatedAt;
    private Date lastUpdatedAt;
    private State state;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
