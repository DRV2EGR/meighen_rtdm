import React, {Component} from 'react';
import createEngine, {
  DefaultLinkModel,
  DefaultNodeModel,
  DiagramModel
} from '@projectstorm/react-diagrams';

import {
  CanvasWidget
} from '@projectstorm/react-canvas-core';

import './CnvMain.css';
import { DemoCanvasWidget } from "./DemoCanvasWidget";
import { FlowChartWithState, Page, Sidebar, SidebarItem } from "react-conductor-workflows";
import { Content } from "./DemoWorkspaceWidget";

import styled from 'styled-components'
import DragAndDropSidebar from "./nFlawer/DragAndDropFlow";

class CanvMain extends Component {
  constructor(props) {
    super(props);

    const engine = createEngine();

    const node1 = new DefaultNodeModel({
      name: 'Node 1',
      color: 'rgb(0,192,255)',
    });
    node1.setPosition(100, 100);
    let port12 = node1.addInPort('In');
    let port1 = node1.addOutPort('Out');
//
// node 2
    const node2 = new DefaultNodeModel({
      name: 'Node 1',
      color: 'rgb(0,192,255)',
    });
    node2.setPosition(100, 100);
    let port2 = node2.addInPort('In');
//
//     const link = port1.link < DefaultLinkModel > (port2);
//     link.addLabel('Hello World!');

    const model = new DiagramModel();
    model.addAll(node1, node2/*, link*/);

    const graph = model.serialize();
    console.log("graph", graph);

    engine.setModel(model);

    this.state = {
      engine: engine,
      code: props.code ? props.code : '999',
      description: props.description ? props.description : 'Unknown error'
    }
  }

  async componentDidMount() {


    // await this.setState({ engine: engine });
  }

  render() {
    const {code, description, engine} = this.state;
    const tasks = [
      {rGuid: "task1", rName: "task1"},
      {rGuid: "task2", rName: "task2"},
      {rGuid: "task3", rName: "task3"},
      {rGuid: "task4", rName: "task4"},
    ]

    const base = {
      offset: {
        "x": 0,
        "y": 0
      },
      selected: {},
      hovered: {},
      nodes: {
        "0": {
          "id": "0",
          "position": {
            "x": 382,
            "y": 82,
            "deltaX": 0,
            "deltaY": -1,
            "lastX": 382,
            "lastY": 83
          },
          "orientation": 0,
          "type": "simple-task",
          "ports": {
            "port1": {
              "id": "port1",
              "type": "top",
              "position": {
                "x": 100,
                "y": -2
              }
            },
            "port2": {
              "id": "port2",
              "type": "bottom",
              "position": {
                "x": 100,
                "y": 122
              }
            }
          },
          "properties": {
            "name": "task1",
            "Id": "",
            "taskReferenceName": "a",
            "inputParameters": "a",
            "caseValueParam": "",
            "defaultExclusiveJoinTask": "",
            "nodeType": "",
            "envVariables": []
          },
          "size": {
            "width": 200,
            "height": 120
          }
        },
        "1": {
          "id": "1",
          "position": {
            "x": 383,
            "y": 306,
            "deltaX": 0,
            "deltaY": -1,
            "lastX": 383,
            "lastY": 307
          },
          "orientation": 0,
          "type": "system-task",
          "ports": {
            "port1": {
              "id": "port1",
              "type": "top",
              "position": {
                "x": 100,
                "y": -2
              }
            },
            "port2": {
              "id": "port2",
              "type": "bottom",
              "position": {
                "x": 100,
                "y": 122
              }
            }
          },
          "properties": {
            "name": "task2",
            "Id": "",
            "taskReferenceName": "b",
            "inputParameters": "b",
            "caseValueParam": "b",
            "defaultExclusiveJoinTask": "",
            "nodeType": "DECISION",
            "envVariables": []
          },
          "size": {
            "width": 200,
            "height": 120
          }
        },
        "2": {
          "id": "2",
          "position": {
            "x": 218,
            "y": 579,
            "deltaX": -1,
            "deltaY": 2,
            "lastX": 219,
            "lastY": 577
          },
          "orientation": 0,
          "type": "simple-task",
          "ports": {
            "port1": {
              "id": "port1",
              "type": "top",
              "position": {
                "x": 100,
                "y": -2
              }
            },
            "port2": {
              "id": "port2",
              "type": "bottom",
              "position": {
                "x": 100,
                "y": 122
              }
            }
          },
          "properties": {
            "name": "task3",
            "Id": "",
            "taskReferenceName": "c",
            "inputParameters": "c",
            "caseValueParam": "",
            "defaultExclusiveJoinTask": "",
            "nodeType": "SIMPLE",
            "envVariables": []
          },
          "size": {
            "width": 200,
            "height": 120
          }
        },
        "3": {
          "id": "3",
          "position": {
            "x": 579,
            "y": 580,
            "deltaX": 0,
            "deltaY": -1,
            "lastX": 579,
            "lastY": 581
          },
          "orientation": 0,
          "type": "simple-task",
          "ports": {
            "port1": {
              "id": "port1",
              "type": "top",
              "position": {
                "x": 100,
                "y": -2
              }
            },
            "port2": {
              "id": "port2",
              "type": "bottom",
              "position": {
                "x": 100,
                "y": 122
              }
            }
          },
          "properties": {
            "name": "task4",
            "Id": "",
            "taskReferenceName": "d",
            "inputParameters": "d",
            "caseValueParam": "",
            "defaultExclusiveJoinTask": "",
            "nodeType": "SIMPLE",
            "envVariables": []
          },
          "size": {
            "width": 200,
            "height": 120
          }
        }
      },
      links: {
        "1c01e8e9-8808-45f0-b846-4ab1ca2e5003": {
          "id": "1c01e8e9-8808-45f0-b846-4ab1ca2e5003",
          "from": {
            "nodeId": "0",
            "portId": "port2"
          },
          "to": {
            "nodeId": "1",
            "portId": "port1"
          },
          "properties": {
            "label": "link1"
          }
        },
        "69326e43-0fcc-483e-9296-55deadf01e6d": {
          "id": "69326e43-0fcc-483e-9296-55deadf01e6d",
          "from": {
            "nodeId": "1",
            "portId": "port2"
          },
          "to": {
            "nodeId": "3",
            "portId": "port1"
          },
          "properties": {
            "label": "link3"
          }
        },
        "0b7f6c05-aa03-445b-95aa-e7b7ab976d5c": {
          "id": "0b7f6c05-aa03-445b-95aa-e7b7ab976d5c",
          "from": {
            "nodeId": "1",
            "portId": "port2"
          },
          "to": {
            "nodeId": "2",
            "portId": "port1"
          },
          "properties": {
            "label": "link2"
          }
        }
      }
    }

    let workFlowValue = {}
    let getWorkFlowChartValue = (newWorkFlowValue) => {
      workFlowValue = newWorkFlowValue
      console.log("work-flow 的JSON数据： ", workFlowValue)
    }

    const validateLink = ({ linkId, fromNodeId, fromPortId, toNodeId, toPortId, chart }) => {

      if (fromNodeId === toNodeId) {
        return false
      }

      return true;
    }

    const chartSimple = {
      offset: {
        x: 0,
        y: 0
      },
      nodes: {
      },
      links: {
      },
      selected: {},
      hovered: {}
    }

    const simpleTaskPorts = {
      port1: {
        id: 'port1',
        type: 'top',
      },
      port2: {
        id: 'port2',
        type: 'bottom',
      }
    }

    // ================================
    const nodeRoleOptions = [
      {
        rGuid: "001-guid",
        rName: "001"
      },
      {
        rGuid: "002-guid",
        rName: "002"
      },
      {
        rGuid: "003-guid",
        rName: "003"
      },
      {
        rGuid: "004-guid",
        rName: "004"
      }
    ]

    const NodeCustom = React.forwardRef(({ node, children, ...otherProps }, ref) => {
      switch (node.type) {
        case "start":
          return (
            <StartPoint ref={ref} {...otherProps}>
              {children}
            </StartPoint>
          )
        case "end":
          return (
            <EndPoint ref={ref} {...otherProps}>
              {children}
            </EndPoint>
          )
        case "process-queue":
          return (
            <ProcessQueue ref={ref} {...otherProps}>
              {children}
            </ProcessQueue>
          )
        case "process-point":
          return (
            <ProcessPoint ref={ref} {...otherProps}>
              {children}
            </ProcessPoint>
          )
      }
    })

    const PortCustom = (props) => {
      return <PortDefaultOuter />
    }

    // const LinkCustom = (props) => {
    //   // console.log("----props---- ", props)
    //   const { startPos, endPos, link, onLabelDoubleClick } = props
    //   // const { centerX, centerY } = generateLabelPosition(startPos, endPos)
    //   return (
    //     <>
    //       <LinkDefault {...props} />
    //       <Label style={{ left: centerX, top: centerY }} onDoubleClick={ () => { onLabelDoubleClick({linkId: link.id}) } }>
    //         { props.link.properties && props.link.properties.label && (
    //           <LabelContent>{props.link.properties && props.link.properties.label}</LabelContent>
    //         )}
    //       </Label>
    //     </>
    //   )
    // }

    const Message = styled.div`
margin: 10px;
padding: 10px;
background: rgba(0,0,0,0.05);
`

    const PortDefaultOuter = styled.div`
  width: 20px;
  height: 20px;
  border-radius: 20px;
  background: cornflowerblue;
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  
  &:hover {
    background: cornflowerblue;
  }
  & svg {
    width: 15px;
    height: 15px;
  }
`

    const ProcessQueue = styled.div`
  width: 200px;
  height: 120px;
  position: absolute;
  padding: 30px;
  background: rgb(217, 207, 138);
  color: white;
  border-radius: 10px;
  & div {
    padding: 0px;
    margin: 0px;
  }
`

    const ProcessPoint = styled.div`
  width: 200px;
  height: 120px;
  position: absolute;
  padding: 30px;
  background: rgb(155, 127, 105);
  color: white;
  & div {
    padding: 0px;
    margin: 0px;
  }
`

    const StartPoint = styled.div`
  position: absolute;
  width: 100px;
  height: 100px;
  padding: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgb(148, 80, 81);
  color: white;
  border-radius: 50%;
`

    const EndPoint = styled.div`
  position: absolute;
  width: 100px;
  height: 100px;
  padding: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgb(110, 97, 107);
  color: white;
  border-radius: 50%;
`

    const Input = styled.input`
  padding: 10px;
  border: 1px solid cornflowerblue;
  width: 100%;
`
    const Label = styled.div`
  position: absolute;
  width: 120px;
`

    const LabelContent = styled.div`
  padding: 5px 10px;
  background: cornflowerblue;
  color: white;
  border-radius: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 10px;
  cursor: pointer;
`

    // interface Port {
    //   id: string,
    //   type: string,
    //   position?: any
    // }


    return (
      <div className="mdv">sdf
        {/*<DemoCanvasWidget>*/}
        {/*  <CanvasWidget engine={engine} />*/}
        {/*</DemoCanvasWidget>*/}

        {/*<Page>*/}
        {/*  <Sidebar>*/}
        {/*    <SidebarItem type="simple-task" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="system-task" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="process-queue" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="start" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="end" ports={simpleTaskPorts} />*/}
        {/*  </Sidebar>*/}
        {/*  <Content>*/}
        {/*    <FlowChartWithState*/}
        {/*      tasks = {tasks}*/}
        {/*      isAllowAddLinkLabel = {true}*/}
        {/*      initialValue={base}*/}
        {/*      getWorkFlowChartValue={getWorkFlowChartValue}*/}
        {/*      config={{ validateLink: validateLink, readonly: false }}*/}
        {/*      // simpleTaskFields={["123", "46"]}*/}
        {/*     />*/}
        {/*  </Content>*/}
        {/*</Page>*/}

        {/*<Page>*/}
        {/*  <Sidebar>*/}
        {/*    <Message>*/}
        {/*      Drag and drop these items onto the canvas.*/}
        {/*    </Message>*/}
        {/*    <SidebarItem type="start" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="process-queue" ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="simple-task"  ports={simpleTaskPorts} />*/}
        {/*    <SidebarItem type="end" ports={ simpleTaskPorts } />*/}
        {/*  </Sidebar>*/}
        {/*  <Content>*/}
        {/*    <FlowChartWithState*/}
        {/*      isAllowAddLinkLabel = {true}*/}
        {/*      initialValue={chartSimple}*/}
        {/*      nodeRoleOptions={nodeRoleOptions}*/}
        {/*      getWorkFlowChartValue={getWorkFlowChartValue}*/}
        {/*      Components={{*/}
        {/*        Port: PortCustom,*/}
        {/*        Node: NodeCustom,*/}
        {/*        // Link: LinkCustom*/}
        {/*      }}*/}
        {/*      config={{ readonly: false }}*/}
        {/*    />*/}
        {/*  </Content>*/}

        {/*</Page>*/}

        {/*<DragAndDropSidebar />*/}

        {/*<iframe src={"http://localhost:3002/"}>*/}

        {/*</iframe>*/}

      </div>
    );
  }
}

export default CanvMain;