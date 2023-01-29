import createEngine, { DiagramModel } from "@projectstorm/react-diagrams";
import * as React from "react";
import { DemoWorkspaceWidget } from "../DemoWorkspaceWidget";
import { CanvasWidget } from "@projectstorm/react-canvas-core";
import { DemoCanvasWidget } from "../DemoCanvasWidget";

import jsonGraph from "./utils/two-node-graph.json";
import styled from "@emotion/styled";

export default () => {
  // setup the diagram engine
  var engine = createEngine();

  //!------------- DESERIALIZE ----------------

  const Tray = styled.div`
		min-width: 200px;
		background: rgb(20, 20, 20);
		flex-grow: 0;
		flex-shrink: 0;
	`;

  var model = new DiagramModel();
  console.log("jsonGraph", jsonGraph);
  model.deserializeModel(jsonGraph, engine);
  engine.setModel(model);

  return (
    <DemoWorkspaceWidget>
      <Tray />

      <div onDrop={(event) => {
        var data = JSON.parse(event.dataTransfer.getData('storm-diagram-node'));
        var nodesCount = _.keys(this.props.app.getDiagramEngine().getModel().getNodes()).length;

        var node = null;
        if (data.type === 'in') {
          node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(192,255,0)');
          node.addInPort('In');
        } else {
          node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(0,192,255)');
          node.addOutPort('Out');
        }
        var point = this.props.app.getDiagramEngine().getRelativeMousePoint(event);
        node.setPosition(point);
        this.props.app.getDiagramEngine().getModel().addNode(node);
        this.forceUpdate();
      }}
           onDragOver={(event) => {
             event.preventDefault();
           }}>

      </div>
      <DemoCanvasWidget>
        <CanvasWidget engine={engine} />
      </DemoCanvasWidget>

    </DemoWorkspaceWidget>

  );
};