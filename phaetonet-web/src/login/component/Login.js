/**
 * Created by Administrator on 2017/6/4.
 */
import React, {Component} from 'react';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import { FormControl, Checkbox } from 'react-bootstrap';
import {BrowserRouter as Router,Route,Link, Redirect} from 'react-router-dom';
import LoginAction from '../action/LoginAction';
import LoginStore from '../store/LoginStore';
import Messager from '../../component/Messager';

import { FormattedMessage } from 'react-intl';
import locale from '../../common/i18n/locale';

/*var ReactToastr = require("react-toastr");
var {ToastContainer} = ReactToastr; // This is a React Element.*/
import {ToastContainer} from 'react-toastr';

class Login extends Component {

    constructor(props) {
        super(props);

        this.state = {
            user: {userCode:'',password:'',remberMe:false},
        };
        this.unsubscribe = LoginStore.listen(this.onStatusChange.bind(this));
    }

    componentWillUnmount () {
        this.unsubscribe();
        this.state = {};
    }

    onStatusChange (res) {

        if (res.resultData != null && res.resultData.code == 100) {
            window.location.href="./workcenter";
        } else {
            this.refs.container.error(locale.Login.failed);
        }
        /*this.setState({
            user: res.resultData
        })*/
    }

    handleChange(e) {
        let user = this.state.user;

        if ( e.target.name == 'userCode') {
              user.userCode = e.target.value;
        } else if (e.target.name == 'password') {
              user.password = e.target.value;
        } else if (e.target.name == 'remberMe') {
            user.remberMe = e.target.checked;
        }

        this.setState({user : user});
        console.log(this.state.user);
    }

    doLogin() {
        console.log("user",this.state.user);
        LoginAction.login(this.state.user);

    }

    render() {
        let user = this.state.user;
        return (
            <div className="col-md-4 col-md-offset-4">
                <Messager ref="container" />
                <div className="text-center">
                    <h1 className="login-brand-text">Phaetonet</h1>
                    <h3 className="text-muted">Created by <a href="http://wz187.net">wz187.net</a> team</h3>
                </div>

                <Panel header={<h3>请登录</h3>} className="login-panel">

                    <form role="form">
                        <fieldset>
                            <div className="form-group">
                                <FormControl
                                    type="text"
                                    className="form-control"
                                    placeholder="用户名"
                                    name="userCode"
                                    defaultValue = {user.userCode}
                                    onChange={this.handleChange.bind(this)}
                                />
                            </div>

                            <div className="form-group">
                                <FormControl
                                    className="form-control"
                                    placeholder="密码"
                                    type="password"
                                    name="password"
                                    defaultValue = {user.password}
                                    onChange={this.handleChange.bind(this)}
                                />
                            </div>
                            <Checkbox label="Remember Me" checked={user.remberMe} name="remberMe" onChange={this.handleChange.bind(this)}> 记住我</Checkbox>
                            <Button bsSize="large" bsStyle="success" block onClick={this.doLogin.bind(this)}>登录</Button>
                        </fieldset>
                    </form>

                </Panel>

            </div>
        );
    }
}

export default Login;