/**
 * Created by Administrator on 2017/6/4.
 */

import React, { Component } from 'react';
import logo from '../logo.svg';
import {
    Nav,
    NavItem,
    NavDropdown,
    MenuItem,
    ProgressBar,
} from 'react-bootstrap';
import Navbar, {Brand} from 'react-bootstrap/lib/Navbar';


class Header extends Component {

    render() {
        return (
            <div id="wrapper" className="content">
                <Navbar fluid={true} style={ {margin: 0} }>
                    <Brand>
                        <span>
                          <img src={logo} alt="Start React" title="Start React"/>
                          <span>&nbsp;Phaetonet - </span>
                                <a href="http://wz187.net/" title="Phaetonet" rel="home">wz187.net</a>
                                <button type="button" className="navbar-toggle" style={{position: 'absolute', right: 0, top: 0}}>
                                  <span className="sr-only">Toggle navigation</span>
                                  <span className="icon-bar"></span>
                                  <span className="icon-bar"></span>
                                  <span className="icon-bar"></span>
                                </button>
                           </span>
                    </Brand>
                    <ul className="nav navbar-top-links navbar-right">
                        <NavDropdown bsClass="dropdown" title={<span><i className="fa fa-envelope fa-fw"></i></span>}
                                     id="navDropdown1">
                            <MenuItem style={ {width: 300} } eventKey="1">
                                <div><strong>John Smith</strong> <span
                                    className="pull-right text-muted"> <em>Yesterday</em> </span></div>
                                <div> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque
                                    eleifend...
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="2">
                                <div><strong>John Smith</strong> <span
                                    className="pull-right text-muted"> <em>Yesterday</em> </span></div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="3">
                                <div><strong>John Smith</strong> <span
                                    className="pull-right text-muted"> <em>Yesterday</em> </span></div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="4" className="text-center">
                                <strong>Read All Messages</strong> <i className="fa fa-angle-right"></i>
                            </MenuItem>
                        </NavDropdown>

                        <NavDropdown title={<span><i className="fa fa-tasks fa-fw"></i> </span>} id='navDropdown2222'>
                            <MenuItem eventKey="1" style={ {width: 300} }>
                                <div>
                                    <p><strong>Task 1</strong> <span
                                        className="pull-right text-muted">40% Complete</span></p>
                                    <div>
                                        <ProgressBar bsStyle="success" now={40}/>
                                    </div>
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="2">
                                <div>
                                    <p><strong>Task 2</strong> <span
                                        className="pull-right text-muted">20% Complete</span></p>
                                    <div>
                                        <ProgressBar bsStyle="info" now={20}/>
                                    </div>
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="3">
                                <div>
                                    <p><strong>Task 3</strong> <span
                                        className="pull-right text-muted">60% Complete</span></p>
                                    <div>
                                        <ProgressBar bsStyle="warning" now={60}/>
                                    </div>
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="4">
                                <div>
                                    <p><strong>Task 4</strong> <span
                                        className="pull-right text-muted">80% Complete</span></p>
                                    <div>
                                        <ProgressBar bsStyle="danger" now={80}/>
                                    </div>
                                </div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="5">
                                <strong>See All Tasks</strong> <i className="fa fa-angle-right"></i>
                            </MenuItem>
                        </NavDropdown>

                        <NavDropdown title={<i className="fa fa-bell fa-fw"></i>} id='navDropdown3'>
                            <MenuItem eventKey="1" style={ {width: 300} }>
                                <div><i className="fa fa-comment fa-fw"></i> New Comment <span
                                    className="pull-right text-muted small">4 minutes ago</span></div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="2">
                                <div><i className="fa fa-twitter fa-fw"></i> 3 New Followers <span
                                    className="pull-right text-muted small">12 minutes ago</span></div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="3">
                                <div><i className="fa fa-envelope fa-fw"></i> Message Sent <span
                                    className="pull-right text-muted small">4 minutes ago</span></div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="4">
                                <div><i className="fa fa-tasks fa-fw"></i> New Task <span
                                    className="pull-right text-muted small">4 minutes ago</span></div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="5">
                                <div><i className="fa fa-upload fa-fw"></i> Server Rebooted <span
                                    className="pull-right text-muted small">4 minutes ago</span></div>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="6">
                                <strong>See All Alerts</strong> <i className="fa fa-angle-right"></i>
                            </MenuItem>
                        </NavDropdown>

                        <NavDropdown title={<i className="fa fa-user fa-fw"></i> } id='navDropdown4'>
                            <MenuItem eventKey="1">
                                <span> <i className="fa fa-user fa-fw"></i> User Profile </span>
                            </MenuItem>
                            <MenuItem eventKey="2">
                                <span><i className="fa fa-gear fa-fw"></i> Settings </span>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="3" href='http://www.strapui.com'>
                                <span> <i className="fa fa-eye fa-fw"/> Premium React Themes </span>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey="4" >
                                <span> <i className="fa fa-sign-out fa-fw"/> Logout </span>
                            </MenuItem>
                        </NavDropdown>

                    </ul>
                </Navbar>
            </div>
        );
    }
}

export default Header;