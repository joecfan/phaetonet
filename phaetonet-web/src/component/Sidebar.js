/**
 * Created by Administrator on 2017/6/4.
 */
import React, { Component } from 'react';
import {BrowserRouter as Router,Route,Link} from 'react-router-dom';
//import Dashboard from '../workcenter/Dashboard';
import Blank from '../workcenter/Blank';

class Sidebar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            uiElementsCollapsed: true,
            chartsElementsCollapsed: true,
            multiLevelDropdownCollapsed: true,
            thirdLevelDropdownCollapsed: true,
            samplePagesCollapsed: true,
        };
    }

    render() {
        return (

            <div className="navbar-default sidebar" style={{ marginLeft: '0px' ,marginTop: '2px'}} role="navigation">

                <div className="sidebar-nav navbar-collapse collapse">

                    <ul className="nav in" id="side-menu">
                        <li className="sidebar-search">
                            <div className="input-group custom-search-form">
                                <input type="text" className="form-control" placeholder="Search..." />
                                <span className="input-group-btn">
                  <button className="btn btn-default" type="button">
                    <i className="fa fa-search" />
                  </button>
                </span>
                            </div>
                        </li>
                        <li>
                            <a href="/" >
                            <i className="fa fa-dashboard fa-fw" /> &nbsp;Dashboard
                            </a>
                        </li>

                        <li>
                            <Link to="/workcenter/aa">
                                Blank
                            </Link>
                        </li>

                        <li>
                            <Link to="/workcenter/bb">
                                Blank2
                            </Link>
                        </li>

                        <li>
                            <a href="http://www.strapui.com/">Premium React Themes</a>
                        </li>
                    </ul>
                </div>


            </div>
        );
    }
}


export default Sidebar;
