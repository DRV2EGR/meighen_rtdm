import React, {Component} from 'react';
import './ChoserBar.css';
import './ColoredIcons.css';
import { Cookies } from "react-cookie";

class ChoserBar extends Component {
    sortState = {
        0: "/",
        1: "/byModifier",
        2: "/byDateCreation",
        3: "/byDateModification"
    };

    constructor(props) {
        super(props);
        this.state = {
            navStatus: "",
            selected: ["active", "", "", "", ""],
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleMenuChange = this.handleMenuChange.bind(this);
        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleMenuChange(event) {
        if (this.state.navStatus == "") {
            this.setState({
                navStatus:"active"
            });
        } else {
            this.setState({
                navStatus:""
            });
        }

    }

    async handleInputChange(event) {
        const target = event.target;
        const name = target.getAttribute('matr');

        console.log(name);

        const myAttrs = {
            "modules": 0,
            "scripts": 1,
            "variables": 2,
            "management": 3,
            "statistics": 4
        };

        let arr = ["", "", "", "", ""];
        arr[myAttrs[name]] = "active";

        // console.log(name);
        this.props.objSetter(await this.props.requester(name));

        this.props.stateIn(name);
        this.setState({
            selected: arr
        });
    }

    render() {
        const {code, description} = this.state;
        return (
            <div className={"navigation " + this.state.navStatus} >
                <div className="menuToggle" onClick={this.handleMenuChange}> </div>
                <ul>
                    <li className={"list " + this.state.selected[0]} matr="modules" onClick={this.handleInputChange}>
                        <a href="#" matr="modules">
                            <span matr="modules" className="icon" ><ion-icon matr="modules" name="browsers-outline"></ion-icon></span>
                            <span matr="modules" className="text">Модули</span>
                        </a>
                    </li>
                    <li className={"list " + this.state.selected[1]} matr="scripts" onClick={this.handleInputChange}>
                        <a href="#" >
                            <span matr="scripts" className="icon"><ion-icon matr="scripts" name="code-slash-outline"></ion-icon></span>
                            <span matr="scripts" className="text">Процессы</span>
                        </a>
                    </li>
                    <li className={"list " + this.state.selected[2]} matr="variables" onClick={this.handleInputChange}>
                        <a href="#" >
                            <span matr="variables" className="icon"><ion-icon matr="variables" name="text-outline"></ion-icon></span>
                            <span matr="variables" className="text">Переменные</span>
                        </a>
                    </li>
                    <li className={"list " + this.state.selected[3]} matr="management" onClick={this.handleInputChange}>
                        <a href="#" >
                            <span matr="management" className="icon"><ion-icon matr="management" name="construct-outline"></ion-icon></span>
                            <span matr="management" className="text">Управление</span>
                        </a>
                    </li>
                    <li className={"list " + this.state.selected[4]} matr="statistics" onClick={this.handleInputChange}>
                        <a href="#" >
                            <span matr="statistics" className="icon"><ion-icon matr="statistics" name="pulse-outline"></ion-icon></span>
                            <span matr="statistics" className="text">Статистика</span>
                        </a>
                    </li>
                </ul>
            </div>
        );
    }
}

export default ChoserBar;