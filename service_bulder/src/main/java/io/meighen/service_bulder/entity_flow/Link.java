package io.meighen.service_bulder.entity_flow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    public String id;
    public From from;
    @JsonProperty("to")
    public To to;
    public Properties properties;
}
