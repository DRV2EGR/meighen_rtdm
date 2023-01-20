import React, {Component} from 'react';
import TextField from "@material-ui/core/TextField";
import { Cookies } from "react-cookie";

class ModuleCreator extends Component {
  myAttrs = {
    "modules": "модуля",
    "scripts": "скрипта",
    "variables": "переменной"
  };
  constructor(props) {
    super(props);
    this.state = {
      compName: "",
      compName2: "INTEGER",
      code: props.code ? props.code : '999',
      description: props.description ? props.description : 'Unknown error'
    }

    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleClickCreate = this.handleClickCreate.bind(this);
    this.renderInputs = this.renderInputs.bind(this);
  }

  async handleClickCreate(e) {
    // e.preventDefault();
    const cookies = new Cookies();
    let a = cookies.get('accessToken');

    let aty;
    if (this.props.type == "variables") {
      aty = await fetch('presenter/api/' + this.props.type + "/" + this.props.type.slice(0, this.props.type.length - 1) + "?name=" + this.state.compName + "&type=" + this.state.compName2, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + a,
        }
      }).then(response => {
        if (!response.ok) {
          //throw new Error('Network response was not OK');
          return response;
        }
        return response.json();
      });
    } else {
      aty = await fetch('presenter/api/' + this.props.type + "/" + this.props.type.slice(0, this.props.type.length - 1) + "?name=" + this.state.compName, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + a,
        }
      }).then(response => {
        if (!response.ok) {
          //throw new Error('Network response was not OK');
          return response;
        }
        return response.json();
      });
    }

    await this.setState({
      compName:"",
      compName2:"INTEGER"
    });

    this.props.enab(aty.uuid);
  }

  async handleInputChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    //console.log(name, " ", value)
    await this.setState({
      [name]: value
    });
  }

  renderInputs() {
    if (this.props.type == "variables") {
      return <div className="content">
              <div className="diver">
                <h4>Название: </h4>
                <TextField
                  id="standard-basic"
                  variant="standard"
                  name="compName"
                  onChange={this.handleInputChange}
                  autoFocus
                />
              </div>
              <div className="diver">
                <h4>Тип: </h4>
                <select id="country" value={this.state.compName2}
                        name="compName2" onChange={this.handleInputChange} >
                  <option value="INTEGER">INTEGER</option>
                  <option value="STRING">STRING</option>
                  <option value="BOOLEAN">BOOLEAN</option>
                </select>
              </div>
            </div>
    } else {
      return <div className="content">
              <div className="diver">
                <h4>Название: </h4>
                <TextField
                  id="standard-basic"
                  variant="standard"
                  name="compName"
                  onChange={this.handleInputChange}
                  autoFocus
                />
              </div>
            </div>
    }
  }

  render() {
    const {code, description} = this.state;
    return (
      // <div className='page-wrap d-flex flex-row align-items-center pt-5'>
      //   <div className='container'>
      //     <div className='row justify-content-center'>
      //       <div className='col-md-12 text-center'>
      //         <span className='font-weight-bold display-4' style={{fontWeight: 500}}>Создание {this.myAttrs[this.props.type]}</span>
      //         {/*<span className='display-1 d-block' style={{fontWeight: 500}}>{code}</span>*/}
      //         <div className='mb-4 fnt' >Название </div>
      //         <a href='/' className='btn btn-primary btn-success'>Создать</a>
      //       </div>
      //     </div>
      //   </div>
      // </div>
      <div className="popup">
        <h2>Создание {this.myAttrs[this.props.type]}</h2>
        <a className="close" href="#">&times;</a>
        {this.renderInputs()}
        <a href='#' className='btn-primary btn-success btn' onClick={this.handleClickCreate}>Создать</a>
      </div>
    );
  }
}


export default ModuleCreator;