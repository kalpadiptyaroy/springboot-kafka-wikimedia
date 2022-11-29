package com.persys.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Table(name = "wikimedia_revision")
@Embeddable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Revision 
{

    @Column(name = "old_revision")
    @JsonProperty("old")
    @Nullable
    private Integer oldRevision;

    @Column(name = "new_revision")
    @JsonProperty("new")
    @Nullable
    private Integer newRevision;


    public Integer getOldRevision() {
        return oldRevision;
    }

    public void setOldRevision(Integer oldRevision) {
        this.oldRevision = oldRevision;
    }

    public Integer getNewRevision() {
        return newRevision;
    }

    public void setNewRevision(Integer newRevision) {
        this.newRevision = newRevision;
    }

    @Override
    public String toString() {
        return "Revision [oldRevision=" + oldRevision + ", newRevision=" + newRevision + "]";
    }

    
    
}
