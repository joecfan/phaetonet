/**
 * Created by Administrator on 2017/6/4.
 */
import React, {Component} from 'react';
import Button from 'react-bootstrap/lib/Button';
import Panel from 'react-bootstrap/lib/Panel';
import { FormControl, Checkbox } from 'react-bootstrap';

class Login extends Component {

    render() {
        return (
            <div className="col-md-4 col-md-offset-4">
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
                                    name="name"
                                />
                            </div>

                            <div className="form-group">
                                <FormControl
                                    className="form-control"
                                    placeholder="密码"
                                    type="password"
                                    name="password"
                                />
                            </div>
                            <Checkbox label="Remember Me" >记住我</Checkbox>
                            <Button type="submit" bsSize="large" bsStyle="success" block>登录</Button>
                        </fieldset>
                    </form>

                </Panel>

            </div>
        );
    }
}

export default Login;