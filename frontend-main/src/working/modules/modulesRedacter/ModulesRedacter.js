import React, {Component} from 'react';
import './ModulesRedacter.css';
import { Cookies } from "react-cookie";

class ModulesRedacter extends Component {
  myAttrs = {
    "modules": "Модуль ",
    "scripts": "Скрипт ",
    "variables": "Переменная "
  };

  constructor(props) {
    super(props);
    this.state = {
      pcur: 0,
      vals: [],
      changesLog: [],
      handledChanges: false,
      code: props.code ? props.code : '999',
      description: props.description ? props.description : 'Unknown error'
    }

    this.renderPages = this.renderPages.bind(this);
    this.renderPoints = this.renderPoints.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleInputChangeCheker = this.handleInputChangeCheker.bind(this);
    this.renderPagesState = this.renderPagesState.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  callSaveComp(contents) {
    const cookies = new Cookies();
    let a = cookies.get('accessToken');

    fetch('presenter/api/' + this.props.currentRedacterMeta.type + "/" + this.props.currentRedacterMeta.type.slice(0, this.props.currentRedacterMeta.type.length - 1) + "?uuid=" + this.props.currentRedacterMeta.obj?.uuid, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + a,
      },
      body: JSON.stringify(contents)
    }).then(response => {
      if (!response.ok) {
        //throw new Error('Network response was not OK');
        return response;
      }
      return response.json();
    });
  }
  handleSubmit(e) {
    e.preventDefault();

    let body = {};
    for (let i = 0; i < this.state.changesLog.length; i++) {
      if (this.state.changesLog[i]) {
        // add to json
        body[this.state.changesLog[i]] = this.state.vals[i];
      }
    }

    this.callSaveComp(body);
    this.setState({handledChanges: false});
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    this.redacterElems = {
      scripts: {
        pages: 4,
        tpages: [
          [
            {
              name: "Название",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.name,
              presented: true,
              arr: 0,
              commitName: "name"
            }
          ],
          [
            {
              name: "Содержание",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.body,
              presented: true,
              arr: 1,
              commitName: "body"
            }
          ],
          [
            {
              name: "Входящие значения",
              type: "inVars",
              arr: 2
            }
          ],
          [
            {
              name: "Исходящие значения",
              type: "outVars",
              arr: 3
            }
          ]
        ]
      },
      variables: {
        pages: 1,
        tpages: [
          [
            {
              name: "Название",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.name,
              presented: true,
              arr: 0,
              commitName: "name"
            },
            {
              name: "Тип",
              type: "chose",
              decisons: [
                "INTEGER",
                "STRING",
                "BOOLEAN"
              ],
              value: this.props.currentRedacterMeta.obj?.type,
              arr: 1,
              commitName: "type"
            },
            {
              name: "Значение",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.value,
              presented: true,
              arr: 2,
              commitName: "value"
            }
          ]
        ]
      },
      modules: {
        pages: 4,
        tpages: [
          [
            {
              name: "Название",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.name,
              presented: true,
              arr: 0,
              commitName: "name"
            },
            {
              name: "Внешний модуль",
              type: "switch",
              value: !this.props.currentRedacterMeta.obj.iinternal,
              presented: true,
              arr: 1,
              commitName: "iinternal"
            },

            {
              name: "Начинающий скрипт",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.firstScript,
              presented: this.props.currentRedacterMeta.obj.iinternal,
              notdepends: 1,
              arr: 2,
              commitName: "firstScript"
            },
            {
              name: "Внешний адрес",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.extModule?.callUrl,
              presented: !(this.props.currentRedacterMeta.obj.iinternal),
              depends: 1,
              arr: 3,
              commitName: "callUrl"
            },
            {
              name: "Тип вызова",
              type: "chose",
              decisons: [
                "REST",
                "SOAP",
                "RPC"
              ],
              value: this.props.currentRedacterMeta.obj?.extModule?.callType,
              presented: !(this.props.currentRedacterMeta.obj.iinternal),
              depends: 1,
              arr: 4,
              commitName: "callType"
            }
          ],

          [
            {
              type: "modulesRenderer",
              presented: !(this.props.currentRedacterMeta.obj.iinternal),
              arr: 5
            }
          ],

          [
            {
              name: "Входящие значения",
              type: "inVars",
              arr: 6
            }
          ],

          [
            {
              name: "Исходящие значения",
              type: "outVars",
              arr: 7
            }
          ]
        ]
      }
    };


    let cnter = [];
    let rrrd = [];
    try {
      cnter = this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur];
    } catch (e) {}
    for (let i = 0; i < cnter.length; i++) {
      console.log("setting +: ", [cnter[i].value]);
      rrrd.push(cnter[i].value);
    }
    console.log("rrd= ", rrrd);
    if (prevProps !== this.props) {
      this.setState({
        vals: rrrd,
        handledChanges: false,
        changesLog: []
      });
    }

    // if (prevProps.currentRedacterMeta.type !== this.props.currentRedacterMeta.type) {
    //   let gert = [];
    //   for (let i = 0; i < this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur].size; i++) {
    //     gert.push(null);
    //   }
    //   this.setState({
    //     changesLog : gert
    //   });
    // }

    // let cnter = [];
    // try {
    //   cnter = this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur];
    // } catch (e) {
    //
    // }
    //
    // for (let i = 0; i < cnter.length; i++) {
    //   this.setState({vals: this.state.vals.concat([cnter[i].value])});
    // }
  }
  //
  // componentDidMount() {
  //   let cnter = [];
  //   try {
  //     cnter = this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur];
  //   } catch (e) {
  //
  //   }
  //
  //   for (let i = 0; i < cnter.length; i++) {
  //     this.setState({vals: this.state.vals.concat([cnter[i].value])});
  //   }
  // }

  handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    console.log(name, " ", value)
    let vvv = this.state.vals;
    let vvvChanges = []; //Array.apply(null, Array(this.state.vals.length)).map(function () {}); //[...this.state.vals];
    for (let i = 0; i < this.state.vals.length; i++) {
      if (this.state.changesLog[i]) { vvvChanges.push(this.state.changesLog[i]);}
      else { vvvChanges.push(undefined); }
    }
    vvv[name] = value;
    vvvChanges[name] = this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur][name].commitName;
    this.setState({
      vals:vvv,
      changesLog: vvvChanges,
      handledChanges: true
    });
  }

  handleInputChangeCheker(event) {
    const target = event.target;
    const value = target.checked;
    const name = target.name;

    console.log(name, " ", value)
    let vvv = this.state.vals;
    let vvvChanges = []; //[...this.state.vals];
    for (let i = 0; i < this.state.vals.length; i++) {
      if (this.state.changesLog[i]) { vvvChanges.push(this.state.changesLog[i]);}
      else { vvvChanges.push(undefined); }
    }
    vvv[name] = value;
    vvvChanges[name] = this.redacterElems[this.props.currentRedacterMeta.type].tpages[this.state.pcur][name].commitName;
    this.setState({
      vals:vvv,
      changesLog: vvvChanges,
      handledChanges: true
    });

    target.checked = !value;
  }

  renderPages(num) {
    let res = [];

    let cnter = [];
    try {
      cnter = this.redacterElems[this.props.currentRedacterMeta.type].tpages[num];

      console.log("ABRA");
      console.log(num);
      console.log(this.redacterElems[this.props.currentRedacterMeta.type].tpages[num]);
    } catch (e) {
      return ;
    }

    for (let i = 0; i < cnter.length; i++) {

      console.log("cntre ", cnter[i]);
      if (this.state.vals[cnter[i].depends] == false || this.state.vals[cnter[i].notdepends] == true) {
        console.log("continue");
        continue;
      }

      if (cnter[i].type == "text") {
        // this.setState({vals: this.state.vals.concat([cnter[i].value])});
        res.push(
          <div className="nrow">
            <div className="ncol-25">
              <label htmlFor="fname">{cnter[i].name}</label>
            </div>
            <div className="ncol-75">
              <input type="text" id="fname"
                     placeholder="Значение.." value={this.state.vals[cnter[i].arr]?this.state.vals[cnter[i].arr]:""}
                     name={cnter[i].arr} onChange={this.handleInputChange}
              />
            </div>
          </div>
        );
      } else if (cnter[i].type == "chose") {
        let y = [];

        for(let j = 0; j < cnter[i].decisons.length; ++j) {
          y.push(
            <option value={cnter[i].decisons[j]}>{cnter[i].decisons[j]}</option>
          );
        }

        res.push(
          <div className="nrow">
            <div className="ncol-25">
              <label htmlFor="country">{cnter[i].name}</label>
            </div>
            <div className="ncol-75">
              <select id="country" value={this.state.vals[i]}
                      name={i} onChange={this.handleInputChange}
              >
                {y}
              </select>
            </div>
          </div>

        );
      } else if (cnter[i].type == "switch") {
        res.push(
          <div className="nrow">
            <div className="ncol-25">
              <label htmlFor="lname">{cnter[i].name}</label>
            </div>
            <div className="ncol-75">
              <div className="switchers">
                <input type="checkbox" id="switch3" switch="bool" checked={this.state.vals[i]}
                       name={i} onChange={this.handleInputChangeCheker}
                />
                <label htmlFor="switch3" data-on-label="Да" data-off-label="Нет"></label>
              </div>
            </div>
          </div>
        );
      }
    }

    return res;
  }

  renderPagesState(e) {
    console.log("VALUE: ", e.target.getAttribute("value"));
    this.setState({pcur: e.target.getAttribute("value")});
  }

  renderPoints() {
    let res = [];

    let cnter = [];
    try {
      cnter = this.redacterElems[this.props.currentRedacterMeta.type].pages;
    } catch (e) {

    }

    for (let i = 0; i < cnter; i++) {
      res.push(
        <div className="point" value={i} onClick={this.renderPagesState}>
          {i}
        </div>
      );
    }

    return res;
  }

  render() {
    const {code, description} = this.state;
    return (
      <div className={"redacterMain " + this.props.redacterTabClass}>
        <div id="container">

          <h1> {this.myAttrs[this.props.currentRedacterMeta.type]}  <i> { this.props.currentRedacterMeta.obj.name}</i>  { this.props.readOnly?"[Read Only]":""}</h1>

          <div>
            <span className="fas fa-times exitSgn" onClick={this.props.close}></span>
          </div>
        </div>

        <div className="mini-navigation">
          {this.renderPoints()}
        </div>

        <form>
          {this.renderPages(this.state.pcur)}

          <div className="nrow">
            <input type="submit" value="Применить" disabled={!this.state.handledChanges} onClick={this.handleSubmit} />
          </div>
        </form>

        {/*<form>*/}
        {/*  <div className="settings">*/}
        {/*    <span>Название </span>*/}
        {/*    <textarea></textarea>*/}
        {/*  </div>*/}
        {/*  <div className="switchers">*/}
        {/*    <span>Внешний модуль </span>*/}
        {/*    <input type="checkbox" id="switch3" switch="bool" />*/}
        {/*    <label htmlFor="switch3" data-on-label="Да" data-off-label="Нет"></label>*/}
        {/*  </div>*/}


        {/*  <div className="settings">*/}
        {/*    <span>Начинающий скрипт </span>*/}
        {/*    <textarea></textarea>*/}
        {/*  </div>*/}

        {/*  <div className="settings">*/}
        {/*    <span>Внешний адрес </span>*/}
        {/*    <textarea></textarea>*/}
        {/*  </div>*/}
        {/*  <div className="settings">*/}
        {/*    <span>Тип вызова </span>*/}
        {/*    <textarea></textarea>*/}
        {/*  </div>*/}

        {/*  <button type="submit" >Сохранить</button>*/}
        {/*</form>*/}
      </div>
    );
  }
}



export default ModulesRedacter;