import React, {Component} from 'react';
import ChoserBar from "../choserBar/ChoserBar";
import Header from "../../header/Header";
import ModuleSearch from "./modulesSearch/ModulesSearch";
import {Grow} from "@material-ui/core";

import Countries from "countries-api/lib/data/Countries.json";
import 'bootstrap/dist/css/bootstrap.min.css';
import Pagination from "react-js-pagination";
import AuthElement from "../../auth_element/AuthElement";
import EurekaElement from "../../eureka/EurekaElement";


class CompMain extends Component {
    constructor(props) {
        super(props);
        this.state = {
            activePage: 15,
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

    handlePageChange(pageNumber) {
        console.log(`active page is ${pageNumber}`);
        this.setState({activePage: pageNumber});
    }


    render() {
        const {code, description} = this.state;
        const page = 3;

        return (
            <div>
                <AuthElement />

                <Header />

                <ChoserBar stateIn={this.setPos}/>

                {this.renderPage()}

                <Pagination
                  activePage={this.state.activePage}
                  itemsCountPerPage={10}
                  totalItemsCount={450}
                  pageRangeDisplayed={5}
                  onChange={this.handlePageChange.bind(this)}
                />
            </div>
        );
    }
}

export default CompMain;