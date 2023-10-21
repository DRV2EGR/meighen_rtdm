package io.meighen.service_bulder.entity_flow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Properties {
    public String name;
    @JsonProperty("Id")
    public String id;
    public String nodeRole;

    public String nodeScript;
}
