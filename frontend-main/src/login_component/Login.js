
import '../App.css';
import React, {Component} from 'react';
import { useState } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Link from '@material-ui/core/Link';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {withStyles} from "@material-ui/core";
import Header from "../header/Header";
// import printValue from "yup/es/util/printValue";
import {useCookies} from "react-cookie";
import Cookies from 'universal-cookie';
import {useHistory} from "react-router";
import history from './history';
import PropTypes from "prop-types";
import {useNavigate} from 'react-router-dom';
// import {withRouter} from 'react-router';
import './login.css';
import toast from "react-hot-toast";

export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080/api';

const useStyles = (theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
    form: {
        width: '100%', // Fix IE 11 issue.
        marginTop: theme.spacing(3),
    },
    submit: {
        margin: theme.spacing(3, 0, 2),
    },
});

// const [username, setUserName] = useState();
// const [password, setPassword] = useState();

async function loginUser(credentials) { //credentials as param
    //console.log(JSON.stringify(credentials));

    try {
        let data = '';
        return fetch('guarder/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credentials)
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return response;
            }
            return response.json();
        })

    } catch (e) {
        console.log("ERROR! ERROR! ERROR!")
    }

}


// async function CookiesWork(access, refresh) {
//     const [cookies, setCookie, removeCookie] = useCookies(['cookie-name']);
//
//     const MyCookies = (a, r) => {
//
//
//         setCookie('accessToken', a);
//         setCookie('refreshToken', r);
//     };
//     MyCookies(access, refresh);
// }

// function setCookies(access, refresh) {
//     const [cookies, setCookie, removeCookie] = useCookies(['cookie-name']);
//
//     setCookie('accessToken', access);
//     setCookie('refreshToken', refresh);
// }


class Login extends Component {
    static contextTypes = {
        router: PropTypes.object
    }
    constructor(props, context) {
        super(props, context);
        this.state = {
            _email: '',
            _password: '',
            remme: true,
            logerr:"nnn"
        };



        //const [token, setToken] = useState();
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async getUserInfo() {
        const cookies = new Cookies();
        let a = cookies.get('accessToken');
        let r = cookies.get('refreshToken');
        let b = cookies.get('username');

        return await fetch('api/user/private/info', { //TODO: GATEWAY URL
            method: 'get',
            headers: new Headers({
                'Authorization': 'Bearer ' + a,
                'Content-Type': 'application/json'
            }),
        }).then(response => {
            if (!response.ok) {
                //throw new Error('Network response was not OK');
                return '-';
            }

            return response.json();
        });
    }


    Copyright() {
        return (
            <Typography variant="body2" color="textSecondary" align="center">
                {'Copyright © '}
                <Link color="inherit" href="https://material-ui.com/">
                    Meighgen
                </Link>{' '}
                {new Date().getFullYear()}
                {'.'}
            </Typography>
        );
    }

    // componentDidMount() {
    //     //TODO: вставить получение картинки.
    //     fetch(process.env.REACT_APP_BASE_BACKEND_URL + '/api/user/get_user_img_url?userId=22' )
    //         .then(response => response.json())
    //         .then(res => /*console.log(result.imgUrl) );*/ this.setState({data_p : res.img}));
    //
    //     console.log(this.state.data_p);
    //     // .catch(e => {
    //     //         console.log(e);
    //     //         this.setState({data: result, isFetching: false, error: e }));
    //     // });
    // }

    // async loginUser(credentials) { //credentials as param
    //     console.log(credentials);
    //
    //     return fetch(process.env.REACT_APP_BASE_BACKEND_URL + 'http://localhost:8080/api/auth/login', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json'
    //         },
    //         body: JSON.stringify(credentials)
    //     })
    //         .then(data => data.json())
    // }

    // export default function Login({ setToken }) {
    // const [username, setUserName] = useState();
    // const [password, setPassword] = useState();

    // handleChange(event) {
    //     this.setState({value: event.target.value});
    // }




    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        //console.log(name, " ", value)
        this.setState({
            [name]: value
        });
    }

    handleSubmit = async e => {
        e.preventDefault();

        // alert('Ваш любимый вкус: ' + this.state.value);
        // console.log(this.refs)

        let email = this.state._email;
        let password = this.state._password;

        let token = await loginUser({
            email,
            password
            // username,
            // password
        });
        // console.log("token: ", token);
        if (!(token.status == 403)) {
            token = token;
        } else {
            if (token.status == 403) {
                toast.error('Ошибка входа, неверный логин/пароль!')
            } else {
                toast.error('Ошибка входа, попробуйте еще раз!')
            }
            this.setState({logerr: ""})
        }

        //console.log(token);
        if (token.accessToken) {
            const cookies = new Cookies();
            cookies.set('accessToken', token.accessToken, {path: '/'});
            if (this.state.remme) {
                cookies.set('refreshToken', token.refreshToken, {path: '/'});
            } else {
                cookies.set('refreshToken', "", {path: '/'});
            }
            cookies.set('username', token.username, {path: '/'});

            let usr = await this.getUserInfo();
            cookies.set('fname', usr.firstName, {path: '/'});
            cookies.set('lname', usr.secondName, {path: '/'});

            cookies.set('timerTime', Date.now(), {path: '/'});
            console.log(usr);
            //history.push('/');
            // this.context.router.history.push('/');
            // this.props.history.push("/");
            // window.open("/insert/your/path/here");

            window.location = '/';
            toast.success('Успешная авторизация!')
        }
        // console.log(cookies.get('accessToken'));
        // console.log(cookies.get('refreshToken'));
        // const cookies = new Cookies();
        // cookies.set('myCat', 'Pacman', { path: '/' });
        // console.log(cookies.get('myCat')); // Pacman

        //CookiesWork(token.accessToken, token.refreshToken);

        //setToken(token);
    }


    render() {
        const { classes } = this.props;
        const {logerr} = this.state;

        return (
            <div>


                <div className="container my-contain">
                    {/*<div className="body d-md-flex align-items-center justify-content-between">*/}
                        {/*<div className="box-1 mt-md-0 mt-5">*/}
                        {/*    <a href="/">*/}
                        {/*        <div className="mlogo">*/}
                        {/*            <svg xmlns="http://www.w3.org/2000/svg" className="nnn">*/}
                        {/*                <symbol id="meighen" viewBox="0 0 118 94">*/}
                        {/*                    <title>Meighen</title>*/}
                        {/*                    <path fill-rule="evenodd" fill="#4d6de3" clip-rule="evenodd" d="M 19.4 61.4 l 36.379 0 l -18.1894 -41.0132 l -18.1896 41.0132 z m 42.5954 -42.4 l 18.8046 42.4 l -37.6092 0 l 18.8046 -42.4 z"></path>*/}
                        {/*                </symbol>*/}
                        {/*            </svg>*/}
                        {/*            <svg className="bi me-2" width="100" height="100" role="img" aria-label="Bootstrap">*/}
                        {/*                <use xlinkHref="#meighen"></use>*/}
                        {/*            </svg>*/}
                        {/*        </div>*/}
                        {/*    </a>*/}
                        {/*    /!*<img src="https://i.pinimg.com/originals/a5/bc/e4/a5bce4af1bed6ee9fa0c30577adcc83a.jpg"*!/*/}
                        {/*    /!*className="" alt="" />*!/*/}
                        {/*</div>*/}

                        <div className="drop">
                            <div className="content">
                                <h2>Войти</h2>
                                <form>
                                    <div className="inputBox">
                                        <input type="email"
                                               placeholder="Email"
                                               required
                                               fullWidth
                                               id="email"
                                               label="Email адрес"
                                               name="_email"
                                               autoComplete="email"
                                               onChange={this.handleInputChange}
                                               autoFocus
                                        />
                                    </div>

                                    <div className="inputBox">
                                        <input type="password"
                                               placeholder="Пароль"
                                               required
                                               name="_password"
                                               label="Пароль"
                                               id="password"
                                               onChange={this.handleInputChange}
                                        />
                                    </div>

                                    <div className="inputBox">
                                        <input type="submit" placeholder="Войти" onClick={this.handleSubmit} />
                                    </div>
                                </form>
                            </div>
                        </div>
                        <a href="/reset" className="btns">Восствновить пароль</a>
                        {/*<a href="#" className="btns sgnp">Зарегистрироваться!</a>*/}
                    {/*    <div className=" box-2 d-flex flex-column h-100">*/}
                    {/*        <div className="mt-5">*/}
                    {/*            <p className="mb-1 h-1">Войти в аккаунт.</p>*/}
                    {/*            <p className="text-muted mb-2">Войдите, чтобы получить все приемущества платформы!</p>*/}
                    {/*            <div className="d-flex flex-column ">*/}
                    {/*                <p className="text-muted mb-2">Продолжить как...</p>*/}
                    {/*                /!*<div className="d-flex align-items-center"><a href="#"*!/*/}
                    {/*                /!*                                              className="box me-2 selectio"> <span*!/*/}
                    {/*                /!*    className="fab fa-facebook-f mb-2"></span>*!/*/}
                    {/*                /!*    <p className="mb-0">Facebook</p>*!/*/}
                    {/*                /!*</a> <a href="#" className="box me-2"> <span className="fab fa-google mb-2"></span>*!/*/}
                    {/*                /!*    <p className="mb-0">Google</p>*!/*/}
                    {/*                /!*</a> <a href="#" className="box"> <span className="far fa-envelope mb-2"></span>*!/*/}
                    {/*                /!*    <p className="mb-0">Email</p>*!/*/}
                    {/*                /!*</a></div>*!/*/}

                    {/*                <form className={classes.form} noValidate>*/}
                    {/*                    <TextField*/}
                    {/*                        variant="outlined"*/}
                    {/*                        margin="normal"*/}
                    {/*                        required*/}
                    {/*                        fullWidth*/}
                    {/*                        id="email"*/}
                    {/*                        label="Email адрес"*/}
                    {/*                        name="_email"*/}
                    {/*                        autoComplete="email"*/}
                    {/*                        onChange={this.handleInputChange}*/}
                    {/*                        autoFocus*/}
                    {/*                    />*/}
                    {/*                    <TextField*/}
                    {/*                        variant="outlined"*/}
                    {/*                        margin="normal"*/}
                    {/*                        required*/}
                    {/*                        fullWidth*/}
                    {/*                        name="_password"*/}
                    {/*                        label="Пароль"*/}
                    {/*                        type="password"*/}
                    {/*                        id="password"*/}
                    {/*                        onChange={this.handleInputChange}*/}
                    {/*                        autoComplete="current-password"*/}
                    {/*                    />*/}
                    {/*                    <FormControlLabel*/}
                    {/*                        control={<Checkbox value="remember" name="remme" onClick={() => {*/}
                    {/*                            this.setState({remme: !this.state.remme});*/}
                    {/*                        }} color="primary" />}*/}
                    {/*                        label="Запомнить меня"*/}
                    {/*                    />*/}

                    {/*                    <div className={"align-items-center justify-content-center errcnt " + logerr}>*/}
                    {/*                        <p className="errtxt">Неверный логин или пароль!</p>*/}
                    {/*                    </div>*/}
                    {/*                    <Button*/}
                    {/*                        type="submit"*/}
                    {/*                        onClick={this.handleSubmit}*/}
                    {/*                        fullWidth*/}
                    {/*                        variant="contained"*/}
                    {/*                        color="#4d6de3"*/}
                    {/*                        className={classes.submit}*/}
                    {/*                    >*/}
                    {/*                        Войти!*/}
                    {/*                    </Button>*/}
                    {/*                    /!*<Grid container>*!/*/}
                    {/*                    /!*    <Grid item xs>*!/*/}
                    {/*                    /!*        /!*TODO: *!/*!/*/}
                    {/*                    /!*        <Link href="#" variant="body2">*!/*/}
                    {/*                    /!*            Забыли пароль?*!/*/}
                    {/*                    /!*        </Link>*!/*/}
                    {/*                    /!*    </Grid>*!/*/}
                    {/*                    /!*    <Grid item sm>*!/*/}
                    {/*                    /!*        <Link href="/signup" variant="body2">*!/*/}
                    {/*                    /!*            {"Еще нет у нас аккаунта? Зарегистрироваться!"}*!/*/}
                    {/*                    /!*        </Link>*!/*/}
                    {/*                    /!*    </Grid>*!/*/}
                    {/*                    /!*</Grid>*!/*/}
                    {/*                </form>*/}


                    {/*                <div className="mt-3">*/}
                    {/*                    <p className="mb-0 text-muted">Еще нет у нас аккаунта? </p>*/}
                    {/*                    <div className="btn-login btn-login-primary" onClick={this.props.signuphnd}>Зарегистрироваться!<span*/}
                    {/*                        className="fas fa-chevron-right ms-1"></span></div>*/}
                    {/*                </div>*/}
                    {/*            </div>*/}
                    {/*        </div>*/}
                    {/*        <br />*/}
                    {/*        <div className="mt-auto">*/}
                    {/*            <p className="footer text-muted mb-0 mt-md-0 mt-4">Входя на нашу платформу, вы соглашаетесь с <span*/}
                    {/*                className="p-color me-1">нашими условиями обслуживания </span>и <span*/}
                    {/*                className="p-color ms-1">политикой обработки данных.</span></p>*/}
                    {/*        </div>*/}
                    {/*    </div>*/}
                        <span className="fas fa-times" onClick={this.props.close}></span>
                    {/*</div>*/}
                </div>
            </div>
        );
    }
}

export default withStyles(useStyles)(Login);