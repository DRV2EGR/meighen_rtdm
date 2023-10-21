import React, {Component} from 'react';
import './ModulsSearch.css';
import './Files.css';
import { Cookies } from "react-cookie";
import Pagination from '@mui/material/Pagination'
import ModuleCreator from "./ModuleCreator/ModuleCreator";

class ModuleSearch extends Component {
    sortState = {
        0: "/",
        1: "/byModifier",
        2: "/byDateCreation",
        3: "/byDateModification"
    };

    constructor(props) {
        super(props);
        this.state = {
            pageCount: 0,
            code: props.code ? props.code : '999',
            description: props.description ? props.description : 'Unknown error'
        }

        this.handleChangePagin = this.handleChangePagin.bind(this);
        this.handleSelectObject = this.handleSelectObject.bind(this);
    }

    async handleSelectObject(e) {
        e.preventDefault();
        console.log(e);
        await this.props.enableRedactMode(e.target.id);
    }

     rendefFiles() {
        let arr = [];
        console.log(arr);

        try {
            let yer = this.props.compsArray;
            for (let i = 0; i < yer.length; ++i) {
                // arr.push(<td><a href='./$namehref'>$name</a></td>);
                // arr.push(<td><a href='./$namehref'>$extn</a></td>);
                // arr.push(<td><a href='./$namehref'>$size</a></td>);
                // arr.push(<td><a href='./$namehref'>$modtime</a></td>);
                let d = new Date(yer[i].dateModification);

                let name = yer[i].name;
                let dateModif = ("0" + d.getDate()).slice(-2) + "-" + ("0"+(d.getMonth()+1)).slice(-2) + "-" +
                  d.getFullYear() + " " + ("0" + d.getHours()).slice(-2) + ":" + ("0" + d.getMinutes()).slice(-2);;
                let modifier = yer[i].lastModifier.lastName + " " + yer[i].lastModifier.firstName[0] + "." + yer[i].lastModifier.secondName[0] + ".";
                let intOrExt = "-";
                if (this.props.statIn == "модули") {
                    intOrExt = !yer[i].iinternal ? "Внешний" : "Внутренний";
                }
                console.log("elem: ", yer[i])

                arr.push(<tr className='$class' onClick={ this.handleSelectObject} id={yer[i].uuid}>
                    <td><a href={this.props.fsttIn+((yer[i].iinternal==false)?"_ext":"")+""} id={yer[i].uuid}>{name}</a></td>
                    <td><a href='#' id={yer[i].uuid}>{intOrExt}</a></td>
                    <td><a href='#' id={yer[i].uuid}>{dateModif}</a></td>
                    <td><a href='#' id={yer[i].uuid}>{modifier}</a></td>
                </tr>);
            }
        } catch (e) {
            console.log(e);
        }
        return arr;
    }


    handleChangePagin(event, value) {
        console.log("val", value);

        this.props.updater(value);
    }

    render() {
        const {code, description} = this.state;
        return (
            <div className={"searcherMain " + this.props.visibleSearch}>
                <div id="popup1" className="overlay">
                    <ModuleCreator type={this.props.fsttIn} enab={this.props.enableRedactMode} />
                </div>



                <div id="container">

                    <div className="mainLay">
                        <h1>Ваши {this.props.statIn}</h1>

                        {/*<a  className="button-85" href="#popup1" role="button">Создать</a>*/}

                        <svg xmlns="http://www.w3.org/2000/svg" className="msvg" version="1.1">
                            <defs>
                                <filter id="gooey">
                                    <feGaussianBlur in="SourceGraphic" stdDeviation="5" result="blur" />
                                    <feColorMatrix in="blur" type="matrix"
                                                   values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 19 -9"
                                                   result="highContrastGraphic" />
                                    <feComposite in="SourceGraphic" in2="highContrastGraphic" operator="atop" />
                                </filter>
                            </defs>
                        </svg>

                        <a id="gooey-button" href="#popup1">
                            Создать
                            <span className="bubbles">
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                                <span className="bubble"></span>
                            </span>
                        </a>
                    </div>

                    <table className="sortable">
                        <thead>
                        <tr>
                            <th className={this.props.fsttIn}>Название</th>
                            <th className={this.props.fsttIn}>Тип</th>
                            {/*<th className={this.props.fsttIn}>Размер <small>(байт)</small></th>*/}
                            <th className={this.props.fsttIn}>Дата изменения</th>
                            <th className={this.props.fsttIn}>Пользователь</th>
                        </tr>
                        </thead>
                        <tbody>
                                {this.rendefFiles()}
                        </tbody>
                    </table>
                </div>

                <div className="paginater">
                    <Pagination variant="outlined" shape="rounded" color="secondary"
                                onChange={this.handleChangePagin} count={this.props.mpgs}
                    />
                </div>
            </div>
        );
    }
}

export default ModuleSearch;