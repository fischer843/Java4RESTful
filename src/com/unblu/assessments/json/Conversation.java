
package com.unblu.assessments.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "$_type",
    "id",
    "accountId",
    "topic",
    "recipient",
    "participants",
    "assigneePersonId",
    "contextPersonId",
    "state",
    "initialEngagementType",
    "tokboxSessionId",
    "conversationTemplateId",
    "links",
    "configuration",
    "text"
})
@Generated("jsonschema2pojo")
public class Conversation {

    @JsonProperty("$_type")
    private String $Type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("topic")
    private Object topic;
    @JsonProperty("recipient")
    private Recipient recipient;
    @JsonProperty("participants")
    private List<Participant> participants = new ArrayList<Participant>();
    @JsonProperty("assigneePersonId")
    private String assigneePersonId;
    @JsonProperty("contextPersonId")
    private String contextPersonId;
    @JsonProperty("state")
    private String state;
    @JsonProperty("initialEngagementType")
    private String initialEngagementType;
    @JsonProperty("tokboxSessionId")
    private Object tokboxSessionId;
    @JsonProperty("conversationTemplateId")
    private String conversationTemplateId;
    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    @JsonProperty("configuration")
    private Object configuration;
    @JsonProperty("text")
    private Object text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Conversation() {
    }

    /**
     * 
     * @param contextPersonId
     * @param initialEngagementType
     * @param configuration
     * @param tokboxSessionId
     * @param assigneePersonId
     * @param accountId
     * @param conversationTemplateId
     * @param recipient
     * @param topic
     * @param links
     * @param id
     * @param state
     * @param text
     * @param $Type
     * @param participants
     */
    public Conversation(String $Type, String id, String accountId, Object topic, Recipient recipient, List<Participant> participants, String assigneePersonId, String contextPersonId, String state, String initialEngagementType, Object tokboxSessionId, String conversationTemplateId, List<Link> links, Object configuration, Object text) {
        super();
        this.$Type = $Type;
        this.id = id;
        this.accountId = accountId;
        this.topic = topic;
        this.recipient = recipient;
        this.participants = participants;
        this.assigneePersonId = assigneePersonId;
        this.contextPersonId = contextPersonId;
        this.state = state;
        this.initialEngagementType = initialEngagementType;
        this.tokboxSessionId = tokboxSessionId;
        this.conversationTemplateId = conversationTemplateId;
        this.links = links;
        this.configuration = configuration;
        this.text = text;
    }

    @JsonProperty("$_type")
    public String get$Type() {
        return $Type;
    }

    @JsonProperty("$_type")
    public void set$Type(String $Type) {
        this.$Type = $Type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("topic")
    public Object getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(Object topic) {
        this.topic = topic;
    }

    @JsonProperty("recipient")
    public Recipient getRecipient() {
        return recipient;
    }

    @JsonProperty("recipient")
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @JsonProperty("participants")
    public List<Participant> getParticipants() {
        return participants;
    }

    @JsonProperty("participants")
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @JsonProperty("assigneePersonId")
    public String getAssigneePersonId() {
        return assigneePersonId;
    }

    @JsonProperty("assigneePersonId")
    public void setAssigneePersonId(String assigneePersonId) {
        this.assigneePersonId = assigneePersonId;
    }

    @JsonProperty("contextPersonId")
    public String getContextPersonId() {
        return contextPersonId;
    }

    @JsonProperty("contextPersonId")
    public void setContextPersonId(String contextPersonId) {
        this.contextPersonId = contextPersonId;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("initialEngagementType")
    public String getInitialEngagementType() {
        return initialEngagementType;
    }

    @JsonProperty("initialEngagementType")
    public void setInitialEngagementType(String initialEngagementType) {
        this.initialEngagementType = initialEngagementType;
    }

    @JsonProperty("tokboxSessionId")
    public Object getTokboxSessionId() {
        return tokboxSessionId;
    }

    @JsonProperty("tokboxSessionId")
    public void setTokboxSessionId(Object tokboxSessionId) {
        this.tokboxSessionId = tokboxSessionId;
    }

    @JsonProperty("conversationTemplateId")
    public String getConversationTemplateId() {
        return conversationTemplateId;
    }

    @JsonProperty("conversationTemplateId")
    public void setConversationTemplateId(String conversationTemplateId) {
        this.conversationTemplateId = conversationTemplateId;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonProperty("configuration")
    public Object getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(Object configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("text")
    public Object getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(Object text) {
        this.text = text;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
