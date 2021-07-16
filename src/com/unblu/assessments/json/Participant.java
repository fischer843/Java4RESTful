
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
    "state",
    "personId"
})
@Generated("jsonschema2pojo")
public class Participant {

    @JsonProperty("$_type")
    private String $Type;
    @JsonProperty("state")
    private String state;
    @JsonProperty("personId")
    private String personId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Participant() {
    }

    /**
     * 
     * @param personId
     * @param state
     * @param $Type
     */
    public Participant(String $Type, String state, String personId) {
        super();
        this.$Type = $Type;
        this.state = state;
        this.personId = personId;
    }

    @JsonProperty("$_type")
    public String get$Type() {
        return $Type;
    }

    @JsonProperty("$_type")
    public void set$Type(String $Type) {
        this.$Type = $Type;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("personId")
    public String getPersonId() {
        return personId;
    }

    @JsonProperty("personId")
    public void setPersonId(String personId) {
        this.personId = personId;
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
