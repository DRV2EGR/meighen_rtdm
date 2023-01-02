import React, {Component} from 'react';
import './ModulesRedacter.css';
import { Cookies } from "react-cookie";

class ModulesRedacter extends Component {
  myAttrs = {
    "modules": "Модуль ",
    "scripts": "Скрипт ",
    "vars": "Переменная "
  };

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
      <div className={"redacterMain " + this.props.redacterTabClass}>
        <div id="container">

          <h1> {this.myAttrs[this.props.currentRedacterMeta.type]}  <i> { this.props.currentRedacterMeta.obj.name}</i> </h1>

          <div>
            <span className="fas fa-times exitSgn" onClick={this.props.close}></span>
          </div>
        </div>

        <div>
          <div className="settings">
            <span>Название </span>
            <textarea></textarea>
          </div>
          <div className="switchers">
            <span>Внешний модуль </span>
            <input type="checkbox" id="switch3" switch="bool" />
            <label htmlFor="switch3" data-on-label="Да" data-off-label="Нет"></label>
          </div>


          <div className="settings">
            <span>Начинающий скрипт </span>
            <textarea></textarea>
          </div>

          <div className="settings">
            <span>Внешний адрес </span>
            <textarea></textarea>
          </div>
          <div className="settings">
            <span>Тип вызова </span>
            <textarea></textarea>
          </div>
        </div>
      </div>
    );
  }
}



export default ModulesRedacter;