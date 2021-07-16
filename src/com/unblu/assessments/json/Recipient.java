
package com.unblu.assessments.json;

import java.util.HashMap;
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
    "displayName",
    "avatar"
})
@Generated("jsonschema2pojo")
public class Recipient {

    @JsonProperty("$_type")
    private String $Type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("avatar")
    private Object avatar;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Recipient() {
    }

    /**
     * 
     * @param displayName
     * @param id
     * @param avatar
     * @param $Type
     */
    public Recipient(String $Type, String id, String displayName, Object avatar) {
        super();
        this.$Type = $Type;
        this.id = id;
        this.displayName = displayName;
        this.avatar = avatar;
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

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("avatar")
    public Object getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Object avatar) {
        this.avatar = avatar;
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
