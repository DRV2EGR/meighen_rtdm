package io.meighen.service_bulder.entity_flow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public String id;
    public Position position;
    public int orientation;
    public String type;
    public Ports ports;
    public Properties properties;
    public Size size;
}
