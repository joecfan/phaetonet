/**
 * Created by Administrator on 2017/6/4.
 */
import React,{Component} from 'react';
import Header from '../component/Header';
import Sidebar from '../component/Sidebar';
import Blank from './Blank';
import Blank2 from './Blank2';

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
                            <Route path="/workcenter/aa" component={Blank}></Route>
                            <Route path="/workcenter/bb" component={Blank2}></Route>
                        </div>
            </div>

        );
    }
}

export default WorkCenter;