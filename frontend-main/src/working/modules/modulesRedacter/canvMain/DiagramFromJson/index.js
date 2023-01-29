import createEngine, { DefaultNodeModel, DiagramModel } from "@projectstorm/react-diagrams";
import * as React from "react";
import { DemoWorkspaceWidget } from "../DemoWorkspaceWidget";
import { CanvasWidget } from "@projectstorm/react-canvas-core";
import { DemoCanvasWidget } from "../DemoCanvasWidget";

// import jsonGraph from "../utils/two-node-graph.json";
import styled from "@emotion/styled";

import * as _ from 'lodash';
import TrayItemWidget from "../TrayItemWidget";
import { Cookies } from "react-cookie";
// import TrayWidget from "../TrayWidget";

export class DiagramFromJson extends React.Component {

  render() {
    var engine = createEngine();

    //!------------- DESERIALIZE ----------------

    var model = new DiagramModel();

    // model.addListener({
    //   nodesUpdated: function(e){
    //     // Do something here
    //     console.log("SELECTED!");
    //   },
    // });

    const cookies = new Cookies();

    let jsonGraph = "";
    if (cookies.get('localChanged') == "true") {
      jsonGraph = cookies.get('jsonGraph');
    } else {
      try {
        jsonGraph = JSON.parse(this.props.body);
      } catch (e) {
        
      }
    }

    console.log("jsonGraph", jsonGraph);
    // model.deserializeModel(this.props.body, engine);
    try {
      model.deserializeModel(jsonGraph, engine);
      console.log("new model ", model);
    } catch (e) {
      // PASS
      console.log("UNSERIALIZED!");
    }
    engine.setModel(model);

    const Tray = styled.div`
		min-width: 200px;
		background: rgb(20, 20, 20);
		flex-grow: 0;
		flex-shrink: 0;
	`;

    const Body = styled.div`
		flex-grow: 1;
		display: flex;
		flex-direction: column;
		min-height: 100%;
	`;

    const Header = styled.div`
		display: flex;
		background: rgb(30, 30, 30);
		flex-grow: 0;
		flex-shrink: 0;
		color: white;
		font-family: Helvetica, Arial, sans-serif;
		padding: 10px;
		align-items: center;
	`;

    const Content = styled.div`
		display: flex;
		flex-grow: 1;
	`;

    const Layer = styled.div`
		position: relative;
		flex-grow: 1;
	`;

    const NTray = styled.div`
		min-width: 100px;
		background: rgb(20, 20, 20);
		flex-grow: 0;
		flex-shrink: 0;
	`;

    return (
      <Body>
        {/*<Header>*/}
        {/*  <div className="title">Storm React Diagrams - DnD demo</div>*/}
        {/*</Header>*/}
        <Content>
          <NTray>
            <TrayItemWidget model={{ type: 'in' }} name="In Node" color="rgb(192,255,0)" />
            <TrayItemWidget model={{ type: 'out' }} name="Out Node" color="rgb(0,192,255)" />
          </NTray>
          <Layer
            onDrop={(event) => {
              var data = JSON.parse(event.dataTransfer.getData('storm-diagram-node'));
              var nodesCount = _.keys(engine.getModel().getNodes()).length;

              var node= new DefaultNodeModel();
              if (data.type === 'in') {
                node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(192,255,0)');
                node.addInPort('In');
              } else {
                node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(0,192,255)');
                node.addOutPort('Out');
              }
              var point = engine.getRelativeMousePoint(event);
              node.setPosition(point);
              // node.addListener({
              //   selectionChanged: () => { console.log("selectionChanged") }
              // });

              engine.getModel().addNode(node);

              // console.log(engine.getModel().serialize());
              cookies.set('localChanged', "true", {path: '/'});
              cookies.set('jsonGraph', JSON.stringify(engine.getModel().serialize()), {path: '/'});
              // this.props.writeBody(JSON.stringify(engine.getModel().serialize()));

              model.deserializeModel(JSON.stringify(engine.getModel().serialize()), engine)

              // this.jsonGraph = model.serialize();
              this.forceUpdate();
            }}
            onDragOver={(event) => {
              event.preventDefault();
            }}
          >
            <DemoCanvasWidget>
              <CanvasWidget engine={engine} />
            </DemoCanvasWidget>
          </Layer>
        </Content>
      </Body>
    );
  }
}

export default DiagramFromJson;

// export default () => {
//   // setup the diagram engine
//   var engine = createEngine();
//
//   //!------------- DESERIALIZE ----------------
//
//   var model = new DiagramModel();
//   console.log("jsonGraph", jsonGraph);
//   model.deserializeModel(jsonGraph, engine);
//   engine.setModel(model);
//
//   const Tray = styled.div`
// 		min-width: 200px;
// 		background: rgb(20, 20, 20);
// 		flex-grow: 0;
// 		flex-shrink: 0;
// 	`;
//
//    const Body = styled.div`
// 		flex-grow: 1;
// 		display: flex;
// 		flex-direction: column;
// 		min-height: 100%;
// 	`;
//
//    const Header = styled.div`
// 		display: flex;
// 		background: rgb(30, 30, 30);
// 		flex-grow: 0;
// 		flex-shrink: 0;
// 		color: white;
// 		font-family: Helvetica, Arial, sans-serif;
// 		padding: 10px;
// 		align-items: center;
// 	`;
//
//    const Content = styled.div`
// 		display: flex;
// 		flex-grow: 1;
// 	`;
//
//    const Layer = styled.div`
// 		position: relative;
// 		flex-grow: 1;
// 	`;
//
//   const NTray = styled.div`
// 		min-width: 100px;
// 		background: rgb(20, 20, 20);
// 		flex-grow: 0;
// 		flex-shrink: 0;
// 	`;
//
//   return (
//     <Body>
//       {/*<Header>*/}
//       {/*  <div className="title">Storm React Diagrams - DnD demo</div>*/}
//       {/*</Header>*/}
//       <Content>
//         <NTray>
//           <TrayItemWidget model={{ type: 'in' }} name="In Node" color="rgb(192,255,0)" />
//           <TrayItemWidget model={{ type: 'out' }} name="Out Node" color="rgb(0,192,255)" />
//         </NTray>
//         <Layer
//           onDrop={(event) => {
//             var data = JSON.parse(event.dataTransfer.getData('storm-diagram-node'));
//             var nodesCount = _.keys(this.props.app.getDiagramEngine().getModel().getNodes()).length;
//
//             var node: DefaultNodeModel = null;
//             if (data.type === 'in') {
//               node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(192,255,0)');
//               node.addInPort('In');
//             } else {
//               node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(0,192,255)');
//               node.addOutPort('Out');
//             }
//             var point = this.props.app.getDiagramEngine().getRelativeMousePoint(event);
//             node.setPosition(point);
//             this.props.app.getDiagramEngine().getModel().addNode(node);
//             this.forceUpdate();
//           }}
//           onDragOver={(event) => {
//             event.preventDefault();
//           }}
//         >
//                <DemoCanvasWidget>
//                  <CanvasWidget engine={engine} />
//                </DemoCanvasWidget>
//         </Layer>
//       </Content>
//     </Body>
//
//     // <div>
//     //   <Tray />
//     //
//     //   123321
//     //
//     //   <div onDrop={(event) => {
//     //     var data = JSON.parse(event.dataTransfer.getData('storm-diagram-node'));
//     //     var nodesCount = _.keys(this.props.app.getDiagramEngine().getModel().getNodes()).length;
//     //
//     //     var node: DefaultNodeModel = null;
//     //     if (data.type === 'in') {
//     //       node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(192,255,0)');
//     //       node.addInPort('In');
//     //     } else {
//     //       node = new DefaultNodeModel('Node ' + (nodesCount + 1), 'rgb(0,192,255)');
//     //       node.addOutPort('Out');
//     //     }
//     //     var point = this.props.app.getDiagramEngine().getRelativeMousePoint(event);
//     //     node.setPosition(point);
//     //     this.props.app.getDiagramEngine().getModel().addNode(node);
//     //     this.forceUpdate();
//     //   }}
//     //        onDragOver={(event) => {
//     //          event.preventDefault();
//     //        }}>
//     //
//     //   </div>
//     //
//     //   <DemoWorkspaceWidget>
//     //     <DemoCanvasWidget>
//     //       <CanvasWidget engine={engine} />
//     //     </DemoCanvasWidget>
//     //   </DemoWorkspaceWidget>
//     // </div>
//   );
// };
//
//
