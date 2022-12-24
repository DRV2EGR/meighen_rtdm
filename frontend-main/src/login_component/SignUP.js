
import React, {Component} from 'react';
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
import {Copyright} from "@material-ui/icons";
import {Input, Select, withStyles} from "@material-ui/core";
import Header from "../header/Header";
import Cookies from "universal-cookie";
import MenuItem from "react-bootstrap/lib/MenuItem";


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
    button: {
        display: 'block',
        marginTop: theme.spacing(2),
    },
    formControl: {
        margin: theme.spacing(1),
        minWidth: 120,
    },
});

function registerSellerUser(credentials) { //credentials as param
    //console.log(JSON.stringify(credentials));

    let data = '';
    return fetch( '/api/signup/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    })
        .then(data => data.json())

}

class SignUP extends Component {
    constructor(props) {
        super(props);
        this.state = {
            who: '',
            res: '',
            firstName: '',
            lastName: '',
            secondName: '',
            username: '',
            email: '',
            password: '',
            userProfileImageUrl: "https://iconorbit.com/icons/256-watermark/1611201511385554301-Girl%20User.jpg",
        };

        //this.useStyles = this.useStyles.bind(this);

        //this.state.classes = this.useStyles();

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this)
    }



    componentDidMount() {
        // this.state.classes = this.useStyles;

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

    handleSubmit = async e => {
        e.preventDefault();

        let firstName = this.state.firstName;
        let lastName = this.state.lastName;
        let secondName = this.state.secondName;
        let username = this.state.username;
        let email = this.state.email;
        let password = this.state.password;

        let userProfileImageUrl = this.state.userProfileImageUrl;

        if (firstName === null || firstName === '') {
            return;
        } if (lastName === null || lastName === '') {
            return;
        } if (secondName === null || secondName === '') {
            return;
        } if (username === null || username === '') {
            return;
        } if (email === null || email === '') {
            return;
        } if (password === null || password === '') {
            return;
        }



        const token = registerSellerUser({
            firstName,
            lastName,
            secondName,
            username,
            email,
            password,
            userProfileImageUrl
        }).then(result => {this.setState({res : result.username} ) } )

        // this.props.history.push("/login");
        window.location = '/login';
    }


    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        //console.log(name, " ", value)
        this.setState({
            [name]: value
        });
    }

    handleChange = (event) => {
        // this.setState(state => ({
        //     editTodo: {
        //         ...state.editTodo,
        //         who: event.target.value,
        //     },
        // }));

        this.setState({
            who: event.target.value
        });
    }

    render() {
        const { classes } = this.props;

        return (
        <div>
            <div className="container">
                <div className="body d-md-flex align-items-center justify-content-between">
                    <div className="box-1 mt-md-0 mt-5">
                        <a href="/">
                            <div className="mlogo">
                                <svg xmlns="http://www.w3.org/2000/svg" className="nnn">
                                    <symbol id="meighen" viewBox="0 0 118 94">
                                        <title>Meighen</title>
                                        <path fill-rule="evenodd" fill="#4d6de3" clip-rule="evenodd" d="M 19.4 61.4 l 36.379 0 l -18.1894 -41.0132 l -18.1896 41.0132 z m 42.5954 -42.4 l 18.8046 42.4 l -37.6092 0 l 18.8046 -42.4 z"></path>
                                    </symbol>
                                </svg>
                                <svg className="bi me-2" width="100" height="100" role="img" aria-label="Bootstrap">
                                    <use xlinkHref="#meighen"></use>
                                </svg>
                            </div>
                        </a>
                        <img src="https://i.pinimg.com/originals/a5/bc/e4/a5bce4af1bed6ee9fa0c30577adcc83a.jpg"
                             className="" alt="" /></div>
                    <div className=" box-2 d-flex flex-column h-100">
                        <div className="mt-5">
                            <p className="mb-1 h-1">Зарегистрироваться.</p>
                            <p className="text-muted mb-2">Зарегистрируйтесть, чтобы получить доступ к платформе!</p>
                            <div className="d-flex flex-column ">
                                <p className="text-muted mb-2">Продолжить как...</p>
                                {/*<div className="d-flex align-items-center"><a href="#"*/}
                                {/*                                              className="box me-2 selectio"> <span*/}
                                {/*    className="fab fa-facebook-f mb-2"></span>*/}
                                {/*    <p className="mb-0">Facebook</p>*/}
                                {/*</a> <a href="#" className="box me-2"> <span className="fab fa-google mb-2"></span>*/}
                                {/*    <p className="mb-0">Google</p>*/}
                                {/*</a> <a href="#" className="box"> <span className="far fa-envelope mb-2"></span>*/}
                                {/*    <p className="mb-0">Email</p>*/}
                                {/*</a></div>*/}

                                <form className={classes.form} noValidate>
                                    <Grid container spacing={2}>
                                        <Grid item xs={12} sm={6}>
                                            <TextField
                                                autoComplete="fname"
                                                name="firstName"
                                                variant="outlined"
                                                required
                                                fullWidth
                                                id="firstName"
                                                label="Имя"
                                                onChange={this.handleInputChange}
                                                autoFocus
                                            />
                                        </Grid>
                                        <Grid item xs={12} sm={6}>
                                            <TextField
                                                variant="outlined"
                                                required
                                                fullWidth
                                                id="lastName"
                                                label="Фамилия"
                                                name="lastName"
                                                autoComplete="lname"
                                                onChange={this.handleInputChange}
                                            />
                                        </Grid>

                                        <Grid item xs={12}>
                                            <TextField
                                                variant="outlined"
                                                fullWidth
                                                id="secondName"
                                                label="Отчество"
                                                name="secondName"
                                                autoComplete="sname"
                                                onChange={this.handleInputChange}
                                            />
                                        </Grid>

                                        <Grid item xs={12}>
                                            <TextField
                                                variant="outlined"
                                                required
                                                fullWidth
                                                id="email"
                                                label="Email адрес"
                                                name="email"
                                                autoComplete="email"
                                                onChange={this.handleInputChange}
                                            />
                                        </Grid>

                                        <Grid item xs={12}>
                                            <TextField
                                                variant="outlined"
                                                required
                                                fullWidth
                                                id="username"
                                                label="Имя пользователя"
                                                name="username"
                                                autoComplete="username"
                                                onChange={this.handleInputChange}
                                            />
                                        </Grid>
                                        <Grid item xs={12}>
                                            <TextField
                                                variant="outlined"
                                                required
                                                fullWidth
                                                name="password"
                                                label="Пароль"
                                                type="password"
                                                id="password"
                                                autoComplete="current-password"
                                                onChange={this.handleInputChange}
                                            />
                                        </Grid>

                                        {/*<Grid item xs={12}>*/}
                                        {/*    <Select*/}
                                        {/*        required*/}
                                        {/*        labelId="demo-controlled-open-select-label"*/}
                                        {/*        id="demo-controlled-open-select"*/}
                                        {/*        defaultValue = ""*/}
                                        {/*        onChange={this.handleChange}*/}
                                        {/*    >*/}
                                        {/*        <MenuItem value="" hidden>*/}
                                        {/*            <em>None</em>*/}
                                        {/*        </MenuItem>*/}
                                        {/*        <MenuItem className='font-weight-bold lead' value="10">Собственник</MenuItem>*/}
                                        {/*        <MenuItem className='font-weight-bold lead'value="20">Агент (риелтор)</MenuItem>*/}
                                        {/*    </Select>**/}
                                        {/*</Grid>*/}

                                        <Grid item xs={12}>
                                            <FormControlLabel
                                                control={<Checkbox value="allowExtraEmails" color="primary" />}
                                                label="Я хочу получать рассылку с интересными новостями."
                                            />
                                        </Grid>
                                    </Grid>
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                        className={classes.submit}
                                        onClick={this.handleSubmit}
                                        id="awd"
                                    >
                                        Зарегистрироваться
                                    </Button>
                                    {/*<Grid container justify="flex-end">*/}
                                    {/*    <Grid item>*/}
                                    {/*        <Link href="/login" variant="body2">*/}
                                    {/*            Уже есть аккаунт? Войти!*/}
                                    {/*        </Link>*/}
                                    {/*    </Grid>*/}
                                    {/*</Grid>*/}
                                </form>


                                <div className="mt-3">
                                    <p className="mb-0 text-muted">Уже есть аккаунт? </p>
                                    <div className="btn-login btn-login-primary" onClick={this.props.loginhnd}>Войти!<span
                                        className="fas fa-chevron-right ms-1"></span></div>
                                </div>
                            </div>
                        </div>
                        <br />
                        <div className="mt-auto">
                            <p className="footer text-muted mb-0 mt-md-0 mt-4">Регистрируясь, вы соглашаетесь с <span
                                className="p-color me-1">нашими условиями обслуживания </span>и <span
                                className="p-color ms-1">политикой обработки данных.</span></p>
                        </div>
                    </div>
                    <span className="fas fa-times" onClick={this.props.close}></span>
                </div>
            </div>
        </div>
        );
    }

}

export default withStyles(useStyles)(SignUP);