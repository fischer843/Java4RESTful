
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
    "type",
    "url"
})
@Generated("jsonschema2pojo")
public class Link {

    @JsonProperty("$_type")
    private String $Type;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param type
     * @param $Type
     * @param url
     */
    public Link(String $Type, String type, String url) {
        super();
        this.$Type = $Type;
        this.type = type;
        this.url = url;
    }

    @JsonProperty("$_type")
    public String get$Type() {
        return $Type;
    }

    @JsonProperty("$_type")
    public void set$Type(String $Type) {
        this.$Type = $Type;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
