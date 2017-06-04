import React from 'react';
import ReactDOM from 'react-dom';
import {Router, Route } from 'react-router';
import {HashHistory } from 'react-router-dom';
import WorkCenter from './workcenter/WorkCenter';
import registerServiceWorker from './registerServiceWorker';


ReactDOM.render(
    (
        <Router history={hashHistory}>
            <Route path="/" component={WorkCenter} />
        </Router>
    ), document.getElementById('root'));
registerServiceWorker();
