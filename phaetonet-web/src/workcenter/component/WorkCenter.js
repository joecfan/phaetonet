/**
 * Created by Administrator on 2017/6/4.
 */
import React,{Component} from 'react';
import Header from '../component/Header';
import Sidebar from '../component/Sidebar';
import TraineeQuery from './TraineeQuery';
import TraineeManage from './TraineeManage';

import {BrowserRouter as Router,Route,Link, Redirect} from 'react-router-dom';

class WorkCenter extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <div>
                        <Header />
                        <Sidebar />
                        <div id="page-wrapper" className="page-wrapper">
                            <Route path="/workcenter/traineeQuery" component={TraineeQuery}></Route>
                            <Route path="/workcenter/traineeManage" component={TraineeManage}></Route>
                        </div>
            </div>

        );
    }
}

export default WorkCenter;