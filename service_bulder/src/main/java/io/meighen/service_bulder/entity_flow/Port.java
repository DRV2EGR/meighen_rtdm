package io.meighen.service_bulder.entity_flow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    public String id;
    public String type;
    public Position position;
}
