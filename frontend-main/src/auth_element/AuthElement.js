
import React, {Component} from 'react';
import {Cookies} from "react-cookie";
import './AuthElement.css';

class AuthElement extends Component {
    constructor() {
        super();
        this.state = {
            sfsf: "",
            ticks: 0
        }
    }

    async getReqRefresh(bo) {
        let rstatus = await fetch('/guarder/api/auth/refresh', {
            method: 'post',
            headers: new Headers({
                'Authorization': 'Bearer ' + bo.accessToken,
                'Content-Type': 'application/json'
            }),
            body: JSON.stringify(bo)
        }).then(response => response.json());

        return rstatus;
    }

    async componentDidMount() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        let status = -1;
        await fetch('/guarder/api/private/check_auth', {
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            }),
        }).then(function(response) {  status = response.status; });

        if (status != 200) {
            let body = {
                accessToken: a,
                refreshToken: r
            };

            let rs = await this.getReqRefresh(body);
            console.log("rs:", rs.status);

            if (rs.accessToken) {
                const cookies = new Cookies();
                cookies.set('accessToken', rs.accessToken, {path: '/'});
                cookies.set('refreshToken', rs.refreshToken, {path: '/'});
                cookies.set('username', rs.username, {path: '/'});

                cookies.set('timerTime', Date.now(), {path: '/'});
                window.location.reload();
            } else {
                const cookies = new Cookies();
                cookies.remove('accessToken');
                cookies.remove('refreshToken');
                cookies.remove('username');
                window.location = '/';
            }
        }

        let tk = Number(cookies.get('timerTicker'))?Number(cookies.get('timerTicker')):0;
        this.setState({ticks : tk});
        this.timer = setInterval(
          () => {
              let diff = Date.now() - Number(cookies.get('timerTime'));
              if (diff > 700000) {
                  this.checker();
                  this.setState({ticks : 0});
              } else {
                  this.setState({ticks : Math.floor(diff/1000)});
              }
          },
          1000,
        );
    }

    async checker() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');

        let body = {
            accessToken: a,
            refreshToken: r
        };

        let rs = await this.getReqRefresh(body);
        console.log("rs:", rs.status);

        if (rs.accessToken) {
            const cookies = new Cookies();
            cookies.set('accessToken', rs.accessToken, {path: '/'});
            cookies.set('refreshToken', rs.refreshToken, {path: '/'});
            cookies.set('username', rs.username, {path: '/'});

            cookies.set('timerTime', Date.now(), {path: '/'});
        } else {
            const cookies = new Cookies();
            cookies.remove('accessToken');
            cookies.remove('refreshToken');
            cookies.remove('username');
            window.location = '/';
        }
    }

    componentWillUnmount() {
        clearInterval(this.timer);
    }

    render() {
        return (
            <div className="ticker">{700-this.state.ticks}</div>
        );
    }
}

export default AuthElement;