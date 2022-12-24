import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Routes, Route, Switch, BrowserRouter} from "react-router-dom";
// import Layout from '../containers/Layout'
import 'bootstrap/dist/css/bootstrap.min.css';
import ErrorPage from "./ErrorPage";
import MainPage from "./main_page/MainPage";
import SignUP from "./login_component/SignUP";
import Login from "./login_component/Login";
class App extends Component {
    render()
    {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path={'/'} component={MainPage}/>

                    <Route exact path={'/signup'} component={SignUP}/>
                    <Route exact path={'/login'} component={Login}/>

                    <Route>
                        <ErrorPage code={404} description={'Страница не найдена.'}/>
                    </Route>
                </Switch>
            </BrowserRouter>
        );
    }
}

export default App;
