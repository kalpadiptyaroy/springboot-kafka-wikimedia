package com.persys.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Table(name="wikimedia_length")
@Embeddable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Length 
{
    @Column(name = "old_length")
    @JsonProperty("old")
    @Nullable
    private Integer oldLength;

    @Column(name = "new_length")
    @JsonProperty("new")
    @Nullable
    private Integer newLength;

    public Integer getOldLength() {
        return oldLength;
    }

    public void setOldLength(Integer oldLength) {
        this.oldLength = oldLength;
    }

    public Integer getNewLength() {
        return newLength;
    }

    public void setNewLength(Integer newLength) {
        this.newLength = newLength;
    }

    @Override
    public String toString() {
        return "Length [oldLength=" + oldLength + ", newLength=" + newLength + "]";
    }

}
