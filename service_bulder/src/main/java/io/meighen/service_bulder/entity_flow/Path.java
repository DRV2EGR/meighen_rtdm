package io.meighen.service_bulder.entity_flow;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Path {
    public Offset offset;
    public List<Node> nodes;
    public List<Link> links;
    public Selected selected;
    public Hovered hovered;
    public ArrayList<String> preNodes;
    public boolean isModelShow;
    public String nodeName;
    public String nodeId;
    public String newNodeId;
    public ArrayList<String> preLinks;
    public String showModelName;
    public String linkLabel;
    public String newLinkId;
    public String clickNodeId;
    public String modelOption;
    public String nodeRoleOption;
    public String clickLinkId;
    public String alertMessageInfo;
    public String alertMessageStatus;
    public String moduleName;
}
