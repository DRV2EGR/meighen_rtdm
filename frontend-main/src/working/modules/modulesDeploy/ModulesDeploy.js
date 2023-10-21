import React, { Component } from "react";
import ModuleCreator from "../modulesSearch/ModuleCreator/ModuleCreator";
import Pagination from "@mui/material/Pagination";
import './ModulesDeploy.css';
import './Steper.css';
// import { alert } from '../../../alert';
import toast, { Toaster } from 'react-hot-toast';
import * as ToastHandler from "react-dom/test-utils";
import axios from "axios";

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
    this.handleDeploy = this.handleDeploy.bind(this);
    this.handleUnDeploy = this.handleUnDeploy.bind(this);
    this.handleValidate = this.handleValidate.bind(this);
    this.handleBuild = this.handleBuild.bind(this);
  }

  async handleSelectObject(e) {
    e.preventDefault();
    console.log(e);
    await this.props.enableRedactMode(e.target.id);
  }

  async doDeploy(e) {
    let r = await fetch('presenter/api/management/deploy?moduleUUID=' + e.target.attributes.value.value, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(r => r.json());
    if (r?.response == "Развертывание запущено!") {
      return;
    }
    throw "";
  }
  async handleDeploy(e) {
    e.preventDefault();
    let status = -1;
    await toast.promise(
      this.doDeploy(e),
      {
        loading: 'Начинаем развертывать...',
        success: <b>Запущено!</b>,
        error: <b>Не удалось запустить развертывание.</b>,
      }
    );
  }

  async doBuild(e) {
    let r = await fetch('presenter/api/management/build?moduleUUID=' + e.target.attributes.value.value, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(r => r.json());
    if (r?.response == "Сборка запущена!") {
      return;
    }
    throw "";
  }

  async handleBuild(e) {
    e.preventDefault();
    let status = -1;
    await toast.promise(
      this.doBuild(e),
      {
        loading: 'Начинаем сборку модуля...',
        success: <b>Запущено!</b>,
        error: <b>Не удалось запустить сборку.</b>,
      }
    );
  }

  async handleUnDeploy(e) {
    e.preventDefault();
    await fetch('presenter/api/management/undeploy?moduleUUID='+e.target.attributes.value.value, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(
      toast('Here is your toast.')
    );
  }

  async handleValidate(e) {
    e.preventDefault();
    await fetch('presenter/api/management/validate?moduleUUID='+e.target.attributes.value.value, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(
      // pass
    );
  }

   getModuleStatus(muuid) {
    return fetch('presenter/api/management/status?moduleUUID='+muuid, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(res => res.json());
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

        let name = yer[i].name;
        let dateModif = yer[i].dateModification;
        let modifier = yer[i].lastModifier.lastName + " " + yer[i].lastModifier.firstName[0] + "." + yer[i].lastModifier.secondName[0] + ".";
        let intOrExt = yer[i].iinternal ? "Внутренний" : "Внешний";
        console.log("elem: ", yer[i])

        let progress = [
          "skip","skip","skip" // Skip
        ];

        let enDeploy = 0;
        let enUnDepl = 0;

        if ((yer[i].moduleInfo.status == "validated" || ((yer[i].moduleInfo.status == "deployed" || yer[i].moduleInfo.status == "built") && yer[i].moduleInfo.state == 1))) {
          progress[0] = "done"; // Ok
          enDeploy = 1;
        }

        if (yer[i].moduleInfo.status == "unvalidated") {
          progress[0] = "fail"; // Err
        }

        if (yer[i].moduleInfo.status == "undeployed") {
          progress[2] = "fail"; // Err
        }

        if (yer[i].moduleInfo.status == "unbuilded") {
          progress[1] = "fail"; // Err
        }

        if (yer[i].moduleInfo.status == "deployed") {
          progress[2] = "done"; // Err
          progress[1] = "done";

          enUnDepl =1;

          if (yer[i].moduleInfo.state == 1) {
            progress[0] = "done"
            enDeploy = 1;
          } else {
            progress[0] = "fail"
          }
        }

        if (yer[i].moduleInfo.status == "built") {
          progress[1] = "done";

          if (yer[i].moduleInfo.state == 1) {
            progress[0] = "done"
          } else {
            progress[0] = "fail"
          }
        }

        arr.push(<tr className='$class' id={yer[i].uuid} value={yer[i].uuid}>
          <td className="d-flex flex-row name-lst">
            <div className="s r"></div>
            <a className="link-module" /*href={this.props.fsttIn+((yer[i].iinternal==false)?"_ext":"")+""}*/
               id={yer[i].uuid}>{name}</a></td>
          <td>
            <div className="container-step">
              <ul className="progressbar">
                <li className={progress[0]}></li>
                <li className={progress[1]}></li>
                <li className={progress[2]}></li>
              </ul>
            </div>
          </td>
          <td>
            <buttton className="button-deploy y" onClick={this.handleValidate} value={yer[i].uuid}>Валидация</buttton>
            <span>        </span>
            <buttton className={"button-deploy "+(enDeploy?"p":"d")} onClick={this.handleBuild} value={yer[i].uuid}>Собрать</buttton>
            <buttton className={"button-deploy "+(enDeploy?"g":"d")} onClick={this.handleDeploy} value={yer[i].uuid}>Развернуть</buttton>
            <buttton className={"button-deploy "+(enUnDepl?"r":"d")} onClick={this.handleUnDeploy} value={yer[i].uuid}>Изъять</buttton>
          </td>
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
        {/*<div id="popup1" className="overlay">*/}
        {/*  <ModuleCreator type={this.props.fsttIn} enab={this.props.enableRedactMode} />*/}
        {/*</div>*/}



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
          </div>

          <table className="sortable">
            <thead>
            <tr>
              <th className={this.props.fsttIn}>Название</th>
              <th className={this.props.fsttIn}><ul>
                <li className="nav-li-text-steps">Валидация</li>
                <li className="nav-li-text-steps">Создание сервиса</li>
                <li className="nav-li-text-steps">Развертывание</li>
              </ul>
              </th>
              <th className={this.props.fsttIn}>Действия</th>
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