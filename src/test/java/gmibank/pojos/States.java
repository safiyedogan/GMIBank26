package gmibank.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class States {
    private int id;
    private String name;
    private Country tpcountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getTpcountry() {
        return tpcountry;
    }

    public void setTpcountry(Country tpcountry) {
        this.tpcountry = tpcountry;
    }


}
