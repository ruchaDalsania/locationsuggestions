
package com.beyondbanking.ssh.model;

import java.util.List;

import com.beyondbanking.ssh.specific.OpeningHours;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "geometry",
    "icon",
    "id",
    "name",
    "opening_hours",
    "photos",
    "place_id",
    "price_level",
    "rating",
    "scope",
    "alt_ids",
    "reference",
    "types",
    "vicinity"
})
public class Result {

    @JsonProperty("name")
    private String name;
    @JsonProperty("opening_hours")
    private OpeningHours openingHours;
    @JsonProperty("price_level")
    private Double price_level;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("types")
    private List<String> types = null;



    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("opening_hours")
    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    @JsonProperty("opening_hours")
    public void setOpeningHours(OpeningHours openingHours) {
        this.openingHours = openingHours;
    }


    @JsonProperty("types")
    public List<String> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<String> types) {
        this.types = types;
    }


    @JsonProperty("price_level")
    public Double getPrice_level() {
        return price_level;
    }

    @JsonProperty("price_level")
    public void setPrice_level(Double price_level) {
        this.price_level = price_level;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

}
