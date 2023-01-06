import React, {Component} from 'react';
import './ModulesRedacter.css';
import { Cookies } from "react-cookie";

class ModulesRedacter extends Component {

  // redacterElems = {
  //   modules: {
  //     pages: 4,
  //     tpages: [
  //       [
  //         {
  //           name: "Название",
  //           type: "text",
  //           value: this.props.currentRedacterMeta.obj?.name,
  //           presented: true
  //         },
  //         {
  //           name: "Внешний модуль",
  //           type: "switch",
  //           value: !this.props.currentRedacterMeta.obj.iinternal,
  //           presented: true
  //         },
  //         {
  //           name: "Начинающий скрипт",
  //           type: "text",
  //           value: this.props.currentRedacterMeta.obj?.firstScript,
  //           presented: this.props.currentRedacterMeta.obj.iinternal
  //         },
  //         {
  //           name: "Внешний адрес",
  //           type: "text",
  //           value: this.props.currentRedacterMeta.obj?.extModule?.callUrl,
  //           presented: !(this.props.currentRedacterMeta.obj.iinternal)
  //         },
  //         {
  //           name: "Тип вызова",
  //           type: "chose",
  //           decisons: [
  //             "REST",
  //             "SOAP",
  //             "RPC"
  //           ],
  //           value: this.props.currentRedacterMeta.obj?.extModule?.callType,
  //           presented: !(this.props.currentRedacterMeta.obj.iinternal)
  //         }
  //       ],
  //
  //       [
  //         {
  //           type: "modulesRenderer",
  //           presented: !(this.props.currentRedacterMeta.obj.iinternal)
  //         }
  //       ],
  //
  //       [
  //         {
  //           name: "Входящие значения",
  //           type: "inVars"
  //         }
  //       ],
  //
  //       [
  //         {
  //           name: "Исходящие значения",
  //           type: "outVars"
  //         }
  //       ]
  //     ]
  //   }
  // };

  myAttrs = {
    "modules": "Модуль ",
    "scripts": "Скрипт ",
    "vars": "Переменная "
  };

  constructor(props) {
    super(props);
    this.state = {
      pcur: 0,
      vals: [],
      code: props.code ? props.code : '999',
      description: props.description ? props.description : 'Unknown error'
    }

    this.renderPages = this.renderPages.bind(this);
    this.renderPoints = this.renderPoints.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleInputChangeCheker = this.handleInputChangeCheker.bind(this);
    this.renderPagesState = this.renderPagesState.bind(this);
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    this.redacterElems = {
      modules: {
        pages: 4,
        tpages: [
          [
            {
              name: "Название",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.name,
              presented: true
            },
            {
              name: "Внешний модуль",
              type: "switch",
              value: !this.props.currentRedacterMeta.obj.iinternal,
              presented: true
            },
            {
              name: "Начинающий скрипт",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.firstScript,
              presented: this.props.currentRedacterMeta.obj.iinternal,
              notdepends: 1
            },
            {
              name: "Внешний адрес",
              type: "text",
              value: this.props.currentRedacterMeta.obj?.extModule?.callUrl,
              presented: !(this.props.currentRedacterMeta.obj.iinternal),
              depends: 1
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
              depends: 1
            }
          ],

          [
            {
              type: "modulesRenderer",
              presented: !(this.props.currentRedacterMeta.obj.iinternal)
            }
          ],

          [
            {
              name: "Входящие значения",
              type: "inVars"
            }
          ],

          [
            {
              name: "Исходящие значения",
              type: "outVars"
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
      this.setState({ vals: rrrd });
    }

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

    //console.log(name, " ", value)
    let vvv = this.state.vals;
    vvv[name] = value;
    this.setState({
      vals:vvv
    });
  }

  handleInputChangeCheker(event) {
    const target = event.target;
    const value = target.checked;
    const name = target.name;

    console.log(name, " ", value)
    let vvv = this.state.vals;
    vvv[name] = value;
    this.setState({
      vals:vvv
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
              <input type="text" id="fname" name="firstname"
                     placeholder="Название скрипта.." value={this.state.vals[i]}
                     name={i} onChange={this.handleInputChange}
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
              <select id="country" name="country" value={cnter[i].value}
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
            <input type="submit" value="Submit" />
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