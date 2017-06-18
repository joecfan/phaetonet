/**
 * Created by Administrator on 2017/6/7.
 */
//import LoginService from '../service/LoginService';
// var LoginService = require ('../service/LoginService');
//var LoginDispatcher = require('../dispatcher/LoginDispatcher');
import Reflux from 'reflux';
/*
var LoginAction = {
    /!*doLogin() {
       //LoginService.doLogin().then(res =>{console.log("aa1",JSON.stringify(res))});

        //window.location.href="/workcenter";
    },*!/

    doLogin: function (para) {
        LoginDispatcher.dispatch({
            actionType: 'Login',
            content: para
        });
    },

};*/
var LoginAction = Reflux.createActions([
    'login',
]);

export default LoginAction;