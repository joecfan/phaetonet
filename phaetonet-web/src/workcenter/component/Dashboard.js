/**
 * Created by Administrator on 2017/6/4.
 */
import React, {Component} from 'react';
import {
    MenuItem,
    DropdownButton,
    Panel, PageHeader, ListGroup, ListGroupItem, Button,
} from 'react-bootstrap';
import StatWidget from '../component/StatWidget';
import ResponsiveContainer from 'recharts/lib/component/ResponsiveContainer';
import AreaChart from 'recharts/lib/chart/AreaChart';
import BarChart from 'recharts/lib/chart/BarChart';
import Tooltip from 'recharts/lib/component/Tooltip';
import Area from 'recharts/lib/cartesian/Area';
import Bar from 'recharts/lib/cartesian/Bar';
import XAxis from 'recharts/lib/cartesian/XAxis';
import YAxis from 'recharts/lib/cartesian/YAxis';
import Donut from '../component/Donut';


class Dashboard extends Component {

    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-lg-12">
                        <PageHeader>Dashboard</PageHeader>
                    </div>
                </div>

                <div className="row">
                    <div className="col-lg-3 col-md-6">
                        <StatWidget
                            style="panel-primary"
                            icon="fa fa-comments fa-5x"
                            count="26"
                            headerText="New Comments!"
                            footerText="View Details"
                            linkTo="/"
                        />
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <StatWidget
                            style="panel-green"
                            icon="fa fa-tasks fa-5x"
                            count="12"
                            headerText="New Tasks!"
                            footerText="View Details"
                            linkTo="/"
                        />
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <StatWidget
                            style="panel-yellow"
                            icon="fa fa-shopping-cart fa-5x"
                            count="124"
                            headerText="New Orders!"
                            footerText="View Details"
                            linkTo="/"
                        />
                    </div>
                    <div className="col-lg-3 col-md-6">
                        <StatWidget
                            style="panel-red"
                            icon="fa fa-support fa-5x"
                            count="13"
                            headerText="Support Tickets!"
                            footerText="View Details"
                            linkTo="/"
                        />
                    </div>
                </div>

                <div className="row">
                    <div className="col-lg-8">

                        <Panel
                            header={<span>
              <i className="fa fa-bar-chart-o fa-fw" /> Area Chart Example
              <div className="pull-right">
                <DropdownButton title="Dropdown" bsSize="xs" pullRight id="dropdownButton1" >
                  <MenuItem eventKey="1">Action</MenuItem>
                  <MenuItem eventKey="2">Another action</MenuItem>
                  <MenuItem eventKey="3">Something else here</MenuItem>
                  <MenuItem divider />
                  <MenuItem eventKey="4">Separated link</MenuItem>
                </DropdownButton>
              </div>
            </span>}
                        >
                            <div>
                                <ResponsiveContainer width="100%" aspect={2}>
                                    <AreaChart data={data} margin={{ top: 10, right: 30, left: 0, bottom: 0 }} >
                                        <XAxis dataKey="name" />
                                        <YAxis />
                                        <CartesianGrid stroke="#ccc" />
                                        <Tooltip />
                                        <Area type="monotone" dataKey="uv" stackId="1" stroke="#8884d8" fill="#8884d8" />
                                        <Area type="monotone" dataKey="pv" stackId="1" stroke="#82ca9d" fill="#82ca9d" />
                                        <Area type="monotone" dataKey="amt" stackId="1" stroke="#ffc658" fill="#ffc658" />
                                    </AreaChart>
                                </ResponsiveContainer>
                            </div>

                        </Panel>

                        <Panel
                            header={<span>
              <i className="fa fa-bar-chart-o fa-fw" /> Bar Chart Example
              <div className="pull-right">
                <DropdownButton title="Dropdown" bsSize="xs" pullRight id="dropdownButton2">
                  <MenuItem eventKey="1">Action</MenuItem>
                  <MenuItem eventKey="2">Another action</MenuItem>
                  <MenuItem eventKey="3">Something else here</MenuItem>
                  <MenuItem divider />
                  <MenuItem eventKey="4">Separated link</MenuItem>
                </DropdownButton>
              </div>
            </span>}
                        >
                            <div>
                                <ResponsiveContainer width="100%" aspect={2}>
                                    <BarChart data={data} margin={{ top: 10, right: 30, left: 0, bottom: 0 }} >
                                        <CartesianGrid stroke="#ccc" />
                                        <XAxis dataKey="name" />
                                        <YAxis />
                                        <Tooltip />
                                        <Bar dataKey="pv" stackId="1" fill="#8884d8" />
                                        <Bar dataKey="uv" stackId="1" fill="#82ca9d" />
                                        <Bar type="monotone" dataKey="amt" fill="#ffc658" />
                                    </BarChart>
                                </ResponsiveContainer>
                            </div>
                        </Panel>

                        <Panel
                            header={<span>
              <i className="fa fa-clock-o fa-fw" /> Responsive Timeline
            </span>}
                        >
                            <div>
                                <ul className="timeline">
                                    <li>
                                        <div className="timeline-badge"><i className="fa fa-check" />
                                        </div>
                                        <div className="timeline-panel">
                                            <div className="timeline-heading">
                                                <h4 className="timeline-title">Lorem ipsum dolor</h4>
                                                <p>
                                                    <small className="text-muted">
                                                        <i className="fa fa-clock-o" /> 11 hours ago via Twitter
                                                    </small>
                                                </p>
                                            </div>
                                            <div className="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero
                                                    laboriosam dolor perspiciatis omnis exercitationem. Beatae, officia
                                                    pariatur? Est cum veniam excepturi. Maiores praesentium, porro voluptas
                                                    suscipit facere rem dicta, debitis.
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li className="timeline-inverted">
                                        <div className="timeline-badge warning"><i className="fa fa-credit-card" />
                                        </div>
                                        <div className="timeline-panel">
                                            <div className="timeline-heading">
                                                <h4 className="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div className="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem dolorem
                                                    quibusdam, tenetur commodi provident cumque magni voluptatem libero, quis
                                                    rerum. Fugiat esse debitis optio, tempore. Animi officiis alias, officia
                                                    repellendus.
                                                </p>
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium
                                                    maiores odit qui est tempora eos, nostrum provident explicabo dignissimos
                                                    debitis vel! Adipisci eius voluptates, ad aut recusandae minus eaque facere.
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div className="timeline-badge danger"><i className="fa fa-bomb" />
                                        </div>
                                        <div className="timeline-panel">
                                            <div className="timeline-heading">
                                                <h4 className="timeline-title">Lorem ipsum dolor</h4>
                                            </div>
                                            <div className="timeline-body">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus
                                                    numquam facilis enim eaque, tenetur nam id qui vel velit similique nihil
                                                    iure molestias aliquam, voluptatem totam quaerat, magni commodi quisquam.
                                                </p>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </Panel>

                    </div>

                    <div className="col-lg-4">

                        <Panel
                            header={<span>
              <i className="fa fa-bell fa-fw" /> Notifications Panel
            </span>}
                        >
                            <ListGroup>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-comment fa-fw" /> New Comment
                                    <span className="pull-right text-muted small"><em>4 minutes ago</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-twitter fa-fw" /> 3 New Followers
                                    <span className="pull-right text-muted small"><em>12 minutes ago</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-envelope fa-fw" /> Message Sent
                                    <span className="pull-right text-muted small"><em>27 minutes ago</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-tasks fa-fw" /> New Task
                                    <span className="pull-right text-muted small"><em>43 minutes ago</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-upload fa-fw" /> Server Rebooted
                                    <span className="pull-right text-muted small"><em>11:32 AM</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-bolt fa-fw" /> Server Crashed!
                                    <span className="pull-right text-muted small"><em>11:13 AM</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-warning fa-fw" /> Server Not Responding
                                    <span className="pull-right text-muted small"><em>10:57 AM</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-shopping-cart fa-fw" /> New Order Placed
                                    <span className="pull-right text-muted small"><em>9:49 AM</em></span>
                                </ListGroupItem>
                                <ListGroupItem href="" onClick={(e) => { e.preventDefault(); }}>
                                    <i className="fa fa-money fa-fw" /> Payment Received
                                    <span className="pull-right text-muted small"><em>Yesterday</em></span>
                                </ListGroupItem>
                            </ListGroup>
                            <Button block>View All Alerts</Button>
                        </Panel>

                        <Panel
                            header={<span>
              <i className="fa fa-bar-chart-o fa-fw" /> Donut Chart Example
            </span>}
                        >
                            <div>
                                <Donut data={data} color="#8884d8" innerRadius="70%" outerRadius="90%" />
                            </div>
                        </Panel>

                    </div>

                </div>
            </div>
        );
    }
}

export default Dashboard;