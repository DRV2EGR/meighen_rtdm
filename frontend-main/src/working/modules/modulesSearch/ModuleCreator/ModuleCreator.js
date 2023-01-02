import React, {Component} from 'react';
import TextField from "@material-ui/core/TextField";

class ModuleCreator extends Component {
  myAttrs = {
    "modules": "модуля",
    "scripts": "скрипта",
    "vars": "переменной"
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
        <div className="content">
          <h4>Название: </h4><TextField id="standard-basic" variant="standard" />
        </div>
        <a href='/' className='btn-primary btn-success btn'>Создать</a>
      </div>
    );
  }
}


export default ModuleCreator;