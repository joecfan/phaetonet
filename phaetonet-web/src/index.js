import React from 'react';
import ReactDOM from 'react-dom';
import WorkCenter from './workcenter/WorkCenter';
import Login from './login/component/Login';
import Blank from './workcenter/Blank';
import Blank2 from './workcenter/Blank2';
import {BrowserRouter as Router,Route,Link, Redirect} from 'react-router-dom';
import registerServiceWorker from './registerServiceWorker';


ReactDOM.render(
    (
        <Router>
            <div>
                    <Route exact path="/" component={Login}></Route>
                    <Route path="/workcenter" component={WorkCenter}></Route>
            </div>
        </Router>

    ), document.getElementById('root'));
registerServiceWorker();
