package com.persys.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Entity
@Table(name = "wikimedia_recentchange")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikimediaData 
{
    @OneToOne(targetEntity = com.persys.entity.Meta.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Meta meta;

    @Transient
    @JsonIgnore
    private List<String> logParams;

    @Id
    @JsonProperty("$schema")
    private String schema; 
    
    @Embedded
    private Length length;

    @Embedded
    private Revision revision;

    @Nullable
    private Integer id;

    @Nullable
    private Long logId;

    @Nullable
    private String logType;

    @Transient
    private String parsedcomment;

    @Transient
    private String comment;

    @Transient
    private String logActionComment;        // Marked Transient - to avoid error: Incorrect string value: '\x92utili...'

    private String type;
    private Integer namespace;
    private String title;
    private Integer timestamp;
    private String user;
    private boolean bot;
    private boolean minor;
    private boolean patrolled;
    private String logAction;
    private String serverUrl;
    private String serverName;
    private String serverScriptPath;
    private String wiki;

    public Length getLength() {
        return length;
    }
    public void setLength(Length length) {
        this.length = length;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSchema() {
        return schema;
    }
    public void setSchema(String schema) {
        this.schema = schema;
    }
    public Meta getMeta() {
        return meta;
    }
    public void setMeta(Meta meta) {
        this.meta = meta;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getNamespace() {
        return namespace;
    }
    public void setNamespace(Integer namespace) {
        this.namespace = namespace;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Integer getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public boolean isBot() {
        return bot;
    }
    public void setBot(boolean bot) {
        this.bot = bot;
    }
    public Long getLogId() {
        return logId;
    }
    public void setLogId(Long logId) {
        this.logId = logId;
    }
    public String getLogType() {
        return logType;
    }
    public void setLogType(String logType) {
        this.logType = logType;
    }
    public List<String> getLogParams() {
        return logParams;
    }
    public void setLogParams(List<String> logParams) {
        this.logParams = logParams;
    }
    public String getLogActionComment() {
        return logActionComment;
    }
    public void setLogActionComment(String logActionComment) {
        this.logActionComment = logActionComment;
    }
    public String getServerUrl() {
        return serverUrl;
    }
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
    public String getServerName() {
        return serverName;
    }
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    public String getServerScriptPath() {
        return serverScriptPath;
    }
    public void setServerScriptPath(String serverScriptPath) {
        this.serverScriptPath = serverScriptPath;
    }
    public String getWiki() {
        return wiki;
    }
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
    public String getParsedcomment() {
        return parsedcomment;
    }
    public void setParsedcomment(String parsedcomment) {
        this.parsedcomment = parsedcomment;
    }
    public boolean isMinor() {
        return minor;
    }
    public void setMinor(boolean minor) {
        this.minor = minor;
    }
    public boolean isPatrolled() {
        return patrolled;
    }
    public void setPatrolled(boolean patrolled) {
        this.patrolled = patrolled;
    }
    public Revision getRevision() {
        return revision;
    }
    public void setRevision(Revision revision) {
        this.revision = revision;
    }
    public String getLogAction() {
        return logAction;
    }
    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }
    
    @Override
    public String toString() {
        return "WikimediaData [id=" + id + ", meta=" + meta + ", logParams=" + logParams + ", schema=" + schema
                + ", length=" + length + ", revision=" + revision + ", type=" + type + ", namespace=" + namespace
                + ", title=" + title + ", comment=" + comment + ", timestamp=" + timestamp + ", user=" + user + ", bot="
                + bot + ", minor=" + minor + ", patrolled=" + patrolled + ", logId=" + logId + ", logType=" + logType
                + ", logAction=" + logAction + ", logActionComment=" + logActionComment + ", serverUrl=" + serverUrl
                + ", serverName=" + serverName + ", serverScriptPath=" + serverScriptPath + ", wiki=" + wiki
                + ", parsedcomment=" + parsedcomment + "]";
    }
}