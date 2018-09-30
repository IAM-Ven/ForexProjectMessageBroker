package pl.messageBroker.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "price",
        "liquidity"
})
public class AskPriceBucket {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("liquidity")
    private Integer liquidity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("liquidity")
    public Integer getLiquidity() {
        return liquidity;
    }

    @JsonProperty("liquidity")
    public void setLiquidity(Integer liquidity) {
        this.liquidity = liquidity;
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
