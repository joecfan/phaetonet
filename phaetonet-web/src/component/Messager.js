/**
 * Created by Administrator on 2017/6/17.
 */
import React, { Component } from 'react';
var ReactToastr = require("react-toastr");
var {ToastContainer} = ReactToastr; // This is a React Element.
// For Non ES6...
// var ToastContainer = ReactToastr.ToastContainer;
var ToastMessageFactory = React.createFactory(ReactToastr.ToastMessage.animation);

class Messager extends Component {

    constructor(props) {
        super(props);
    }

    error (msg,title) {

        this.refs.toast.error(
            msg,title,{closeButton: true,timeOut: 8000,extendedTimeOut: 2000});
    }

    info (msg,title) {

        this.refs.toast.info(
            msg,title,{closeButton: true,timeOut: 8000,extendedTimeOut: 2000});
    }

    success (msg,title) {

        this.refs.toast.success(
            msg,title,{closeButton: true,timeOut: 8000,extendedTimeOut: 2000});
    }

    warning (msg,title) {

        this.refs.toast.warning(
            msg,title,{closeButton: true,timeOut: 8000,extendedTimeOut: 2000});
    }

    clear () {
        this.refs.toast.clear();
    }

    render(){
        return (
            <div>
                <ToastContainer ref="toast"
                    toastMessageFactory={ToastMessageFactory}
                    className="toast-top-right" />
            </div>
            );
    }

}

export default Messager;