package io.meighen.service_bulder.entity_flow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    public int x;
    public int y;
    public int deltaX;
    public int deltaY;
    public int lastX;
    public int lastY;
}
