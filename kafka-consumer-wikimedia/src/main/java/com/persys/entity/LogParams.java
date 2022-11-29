package com.persys.entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Table(name = "wikimedia_logparams")
@Embeddable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LogParams 
{
    
    private String duration;
    private String flags;
    private boolean sitewide;
    
    
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getFlags() {
        return flags;
    }
    public void setFlags(String flags) {
        this.flags = flags;
    }
    public boolean isSitewide() {
        return sitewide;
    }
    public void setSitewide(boolean sitewide) {
        this.sitewide = sitewide;
    }
    
    @Override
    public String toString() {
        return "LogParams [duration=" + duration + ", flags=" + flags + ", sitewide=" + sitewide + "]";
    }

    
    
}
