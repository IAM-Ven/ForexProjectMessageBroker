package pl.messageBroker.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "date",
        "time",
        "instrument",
        "bidPriceBucket",
        "askPriceBucket"
})
public class Quotation {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;
    @JsonProperty("instrument")
    private Instrument instrument;
    @JsonProperty("bidPriceBucket")
    private BidPriceBucket bidPriceBucket;
    @JsonProperty("askPriceBucket")
    private AskPriceBucket askPriceBucket;
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

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("instrument")
    public Instrument getInstrument() {
        return instrument;
    }

    @JsonProperty("instrument")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @JsonProperty("bidPriceBucket")
    public BidPriceBucket getBidPriceBucket() {
        return bidPriceBucket;
    }

    @JsonProperty("bidPriceBucket")
    public void setBidPriceBucket(BidPriceBucket bidPriceBucket) {
        this.bidPriceBucket = bidPriceBucket;
    }

    @JsonProperty("askPriceBucket")
    public AskPriceBucket getAskPriceBucket() {
        return askPriceBucket;
    }

    @JsonProperty("askPriceBucket")
    public void setAskPriceBucket(AskPriceBucket askPriceBucket) {
        this.askPriceBucket = askPriceBucket;
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
