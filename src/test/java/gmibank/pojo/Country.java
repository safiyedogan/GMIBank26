package gmibank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String id;
    private String name;
    private String states;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public Country(String id, String name, String states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public Country() {
    }
    @Override
    public String toString() {
        return "Country [id=" + id + ", name=" + name + ", states=" + states + "]";
    }
}