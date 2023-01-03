
import React, {Component} from 'react';
import {Cookies} from "react-cookie";

class AuthElement extends Component {
    constructor() {
        super();
        this.state = {
            sfsf: ""
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
                window.location.reload();
            } else {
                const cookies = new Cookies();
                cookies.remove('accessToken');
                cookies.remove('refreshToken');
                cookies.remove('username');
                window.location = '/';
            }
        }

        this.timer = setInterval(
          () => {
              this.checker();
          },
          700000,
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
            window.location.reload();
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
            <div></div>
        );
    }
}

export default AuthElement;