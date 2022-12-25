import React, {Component} from 'react';
import ChoserBar from "../choserBar/ChoserBar";
import Header from "../../header/Header";
import ModuleSearch from "./modulesSearch/ModulesSearch";
import {Grow} from "@material-ui/core";
import {Zoom} from "swiper";

class CompMain extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentPos: "",
            modulesIn:false,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.setPos = this.setPos.bind(this);
    }

    renderPage() {
        switch (this.state.currentPos) {
            case "modules":
                return <ModuleSearch statIn='модули' fsttIn='modules' />;
            case "processes":
                return <ModuleSearch statIn='скрипты' fsttIn='processes'/>;
            case "vars":
                return <ModuleSearch statIn='переменные' fsttIn='vars'/>;
            default:
                return "";
        }

    }

    setPos(position) {
        this.setState({
            currentPos:position
        })
    }

    render() {
        const {code, description} = this.state;
        return (
            <div>
                <Header />

                <ChoserBar stateIn={this.setPos}/>

                {this.renderPage()}
            </div>
        );
    }
}

export default CompMain;