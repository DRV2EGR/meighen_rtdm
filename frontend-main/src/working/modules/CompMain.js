import React, {Component} from 'react';
import ChoserBar from "../choserBar/ChoserBar";

class CompMain extends Component {
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
                <ChoserBar />
            </div>
        );
    }
}

export default CompMain;