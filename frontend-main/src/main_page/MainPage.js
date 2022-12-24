import React, {Component} from 'react';
import './main_page.css';
import Header from "../header/Header";

class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    render() {
        const {code, description} = this.state;
        return (
            <div>
                <Header />
                Hello, react!
            </div>
        );
    }
}


export default MainPage;