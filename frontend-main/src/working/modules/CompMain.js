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
import { Cookies } from "react-cookie";
import ModulesRedacter from "./modulesRedacter/ModulesRedacter";


class CompMain extends Component {
    sortState = {
        0: "/",
        1: "/byModifier",
        2: "/byDateCreation",
        3: "/byDateModification"
    };

    constructor(props) {
        super(props);
        this.state = {
            orderer: 0,
            activePage: 15,
            currentPos: "modules",
            modulesIn:false,
            objects: [],

            // parameters
            name:null,
            page:1,
            size:null,

            maxPages:1,
            redacterMode:false,
            redacterEnabled:"",
            redacterTabClass:"dnn",

            redacters: {obj: {
                name: ""
                }},
            this_typr: true,

            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.setPos = this.setPos.bind(this);
        this.handleCompsChange = this.handleCompsChange.bind(this);
        this.loadCompsPage = this.loadCompsPage.bind(this);
        this.handlePageChange = this.handlePageChange.bind(this);
        this.handleEnableRedacting = this.handleEnableRedacting.bind(this);
    }

    async handleEnableRedacting(id) {
        let redacter = {
            uuid: id,
            type: this.state.currentPos,
            permissions: "rw",
            obj: await this.loadInfoByUUID(id)
        };

        console.log("REDACTER: ", redacter);

        await this.setState({
            redacters: redacter,
            this_typr: redacter.obj.iinternal
        });

        if (!this.state.redacterMode) {
            await this.setState({redacterMode:true, redacterEnabled:"dnn", redacterTabClass:""});
        } else {
            await this.setState({redacterMode:false, redacterEnabled:"", redacterTabClass:"dnn"});
            return;
        }
    }

    async loadInfoByUUID(uuid) {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        console.log("UUID is: " + uuid);

        let aty = await fetch('presenter/api/' + this.state.currentPos  + "/" + this.state.currentPos.slice( 0, this.state.currentPos.length-1 ) +"?uuid="+uuid, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + a,
            }
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return response;
            }
            return response.json();
        });

        return aty;
    }

    renderPage() {
        switch (this.state.currentPos) {
            case "modules":
                return <ModuleSearch statIn='модули' fsttIn='modules' orderBy={this.state.orderer}
                                     compsArray={this.state.objects} updater={this.handlePageChange}
                                     mpgs={this.state.maxPages} visibleSearch={this.state.redacterEnabled}
                                     enableRedactMode={this.handleEnableRedacting}
                />;
            case "scripts":
                return <ModuleSearch statIn='скрипты' fsttIn='scripts' orderBy={this.state.orderer}
                                     compsArray={this.state.objects} updater={this.handlePageChange}
                                     mpgs={this.state.maxPages} visibleSearch={this.state.redacterEnabled}
                                     enableRedactMode={this.handleEnableRedacting}
                />;
            case "variables":
                return <ModuleSearch statIn='переменные' fsttIn='vars' orderBy={this.state.orderer}
                                     compsArray={this.state.objects} updater={this.handlePageChange}
                                     mpgs={this.state.maxPages} visibleSearch={this.state.redacterEnabled}
                                     enableRedactMode={this.handleEnableRedacting}
                />;
            default:
                return "";
        }

    }

    setPos(position) {
        this.setState({
            currentPos:position
        })
    }

    async handlePageChange(pageNumber) {
        console.log(`active page is ${pageNumber}`);
        await this.setState({ activePage: pageNumber, page: pageNumber });

        await this.handleCompsChange(await this.loadCompsPage(this.state.currentPos));
    }

    async handleCompsChange(mstate) {
        console.log("cmnr", mstate);
        try {
            await this.setState({ objects: mstate.objects, maxPages:mstate.totalPages });
        } catch (e) {

        }
    }

    async componentDidMount() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        let aty = await fetch('presenter/api/' + this.state.currentPos + "/", {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + a,
            }
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return response;
            }
            return response.json();
        });

        try {
            this.setState({ objects: aty.objects });
        } catch (e) {
            
        }
    }

    async getParamStr(params) {
        console.log("parameters: ", params);

        let res="";
        let flg = true;
        for (let i = 0; i <params.length; i++) {
            console.log(params[i]);
            if (params[i].value != null) {
                res += (flg?"?":"&") + params[i].name + "=" + params[i].value;
                flg=false;
            }
        }

        return res;
    }

    async loadCompsPage(typer) {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        return await fetch('presenter/api/' + typer + this.sortState[this.state.orderer]+ await this.getParamStr([
            {name:"name", value:this.state.name},
            {name:"page", value:this.state.page-1},
            {name:"size", value:this.state.size}
        ]), {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + a,
            }
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return response;
            }
            return response.json();
        });
    }

    render() {
        const {code, description} = this.state;
        const page = 3;

        return (
            <div>
                <AuthElement />

                <Header />

                <ChoserBar stateIn={this.setPos} objSetter={this.handleCompsChange}
                           orderBy={this.state.orderer} requester={this.loadCompsPage} />

                {this.renderPage()}

                <ModulesRedacter redacterTabClass={this.state.redacterTabClass} close={this.handleEnableRedacting}
                                 currentRedacterMeta={this.state.redacters} readOnly={false} ourTypeI={this.state.this_typr}
                />
            </div>
        );
    }
}

export default CompMain;