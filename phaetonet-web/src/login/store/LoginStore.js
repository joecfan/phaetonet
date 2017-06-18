/**
 * Created by Administrator on 2017/6/17.
 */
/*

var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
var LoginService = require('../service/LoginService');

var LoginStore = assign({}, EventEmitter.prototype, {
    resultData:{},
    callback:function(){},

    getAll: function () {
        //return this.resultData;
        callback.then(res =>{

            this.resultData = JSON.stringify(res);
        });
    },

    addLoginHandler: function (content) {
        /!*LoginService.doLogin(content).then(res =>{

            this.resultData = JSON.stringify(res);
        });*!/
        this.callback = LoginService.doLogin(content);
    },

    emitChange: function () {
        this.emit('change');
    },

    addChangeListener: function(callback) {
        this.on('change', callback);
    },

    removeChangeListener: function(callback) {
        this.removeListener('change', callback);
    }
});
*/

import Reflux from 'reflux';
import LoginAction from '../action/LoginAction';
// var LoginService = require('../service/LoginService');
import LoginService from '../service/LoginService';

var LoginStore = Reflux.createStore({

    listenables: [LoginAction],


    onLogin (content) {

        LoginService.doLogin(content).then(res =>{
            this.updateList (res)
        });

    },

    updateList (res) {

        if(res.code === 100) {
            localStorage.setItem("Authorization", res.content.token);
        }
        let resultData = {resultData : res};

        this.trigger(resultData);
    },


});

export default LoginStore;