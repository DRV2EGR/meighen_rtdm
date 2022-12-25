import React, {Component} from 'react';
import './ModulsSearch.css';
import './Files.css';

class ModuleSearch extends Component {
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
            <div className="searcherMain">
                <div id="container">

                    <h1>Ваши {this.props.statIn}</h1>

                    <table className="sortable">
                        <thead>
                        <tr>
                            <th className={this.props.fsttIn}>Название</th>
                            <th className={this.props.fsttIn}>Тип</th>
                            <th className={this.props.fsttIn}>Размер <small>(байт)</small></th>
                            <th className={this.props.fsttIn}>Дата изменения</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr className='$class'>
                                <td><a href='./$namehref'>$name</a></td>
                                <td><a href='./$namehref'>$extn</a></td>
                                <td><a href='./$namehref'>$size</a></td>
                                <td sorttable_customkey='$timekey'><a href='./$namehref'>$modtime</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ModuleSearch;