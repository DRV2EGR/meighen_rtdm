import React, {Component} from 'react';
import './main_page.css';
import Header from "../header/Header";
import ChoserBar from "../working/choserBar/ChoserBar";
import Cookies from "universal-cookie/es6";
import Footer from "../footer/Footer";


class MainPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }
    }

    componentDidMount() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');

        if (a) {
            // Authorized!
            // Go to cabinett
            window.location = '/main';
        }
    }

    render() {
        const {code, description} = this.state;
        return (
            <div className="root-div-page">
                <Header />
                <div className="my-flex-1">

                </div>
                {/*<article contentEditable>Content</article>*/}
                <Footer />
            </div>
        );
    }
}


export default MainPage;