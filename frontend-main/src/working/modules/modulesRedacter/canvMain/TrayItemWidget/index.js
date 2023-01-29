import createEngine, { DefaultNodeModel, DiagramModel } from "@projectstorm/react-diagrams";
import * as React from "react";
import styled from "@emotion/styled";
import { Container, Content, Toolbar } from "../DemoWorkspaceWidget";

// export default () => {
//   const Tray = styled.div`
// 		color: white;
// 		font-family: Helvetica, Arial;
// 		padding: 5px;
// 		margin: 0px 10px;
// 		border: solid 1px ${(p) => p.color};
// 		border-radius: 5px;
// 		margin-bottom: 2px;
// 		cursor: pointer;
// 	`;
//
//   return (
//     <Tray
//       color={this.props.color}
//       draggable={true}
//       onDragStart={(event) => {
//         event.dataTransfer.setData('storm-diagram-node', JSON.stringify(this.props.model));
//       }}
//       className="tray-item"
//     >
//       {this.props.name}
//     </Tray>
//   );
// };

export class TrayItemWidget extends React.Component {

  render() {
    const Tray = styled.div`
      color: white;
      font-family: Helvetica, Arial;
      padding: 5px;
      margin: 0px 10px;
      border: solid 1px ${(p) => p.color};
      border-radius: 5px;
      margin-bottom: 2px;
      cursor: pointer;
      margin: 5px;
	`;

    return (
      <Tray
        color={this.props.color}
        draggable={true}
        onDragStart={(event) => {
          event.dataTransfer.setData('storm-diagram-node', JSON.stringify(this.props.model));
        }}
        className="tray-item"
      >
        {this.props.name}
      </Tray>
    );
  }
}

export default TrayItemWidget;