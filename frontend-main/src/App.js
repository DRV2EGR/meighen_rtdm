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
import CompMain from "./working/modules/CompMain";
import EurekaElement from "./eureka/EurekaElement";
import CanvMain from "./working/modules/modulesRedacter/canvMain/CanvMain";
import DiagramFromJson from "./working/modules/modulesRedacter/canvMain/DiagramFromJson";
import { Toaster } from "react-hot-toast";
import AboutElement from "./about/AboutElement";
// import DragAndDropSidebar from "./working/modules/modulesRedacter/canvMain/flowDiagram/DragAndDropSidebar";
class App extends Component {

    async componentDidMount() {
        // client.logger.level('debug');
        // await EurekaElement.initEureka();
        // EurekaElement.getInstanceGuarder();
    }

    render()
    {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path={'/'} component={MainPage}/>

                    <Route exact path={'/signup'} component={SignUP}/>
                    <Route exact path={'/login'} component={Login}/>

                    <Route exact path={'/main'} component={CompMain} />

                    <Route exact path={'/draw'} component={CanvMain} />
                    <Route exact path={'/draw2'} component={DiagramFromJson} />
                    {/*<Route exact path={'/draw3'} component={DragAndDropSidebar} />*/}

                    {/*<Route exact path={'/draw3'} component={BodyWidget} />*/}

                    <Route exact path={'/about'} component={AboutElement} />

                    <Route>
                        <ErrorPage code={404} description={'Страница не найдена.'}/>
                    </Route>
                </Switch>
            </BrowserRouter>
        );
    }
}

export default App;
