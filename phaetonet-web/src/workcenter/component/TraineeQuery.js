/**
 * Created by Administrator on 2017/6/5.
 */
import React,{Component} from 'react';
import { PageHeader, Form, FormGroup, ControlLabel,Button , FormControl,Grid, Row,Col} from 'react-bootstrap';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import BasicTable from './basic-table';

class TraineeQuery extends Component {

    constructor(props) {
        super(props);
        this.state = {
            trainee : {idNo : ""},
            products : [{id: 1, name: "Product1", price: 120},{id: 1, name: "Product1", price: 120}]
        };

    }

    handleChange(e) {
        let trainee = this.state.trainee;

        if ( e.target.name === 'idNo') {
            trainee.idNo = e.target.value;
        }

        this.setState({trainee : trainee});
        console.log(this.state.trainee);
    }

    doSearch() {
        console.log("ddddddddddddddddd",this.state.trainee);
    }


    render () {
        return (
            <div>
                <div className="row">
                    <div className="col-lg-12">
                        <br/>
                        <Form inline>
                        <FormGroup controlId="formInlineName">
                            <ControlLabel>身份证号码</ControlLabel>
                            {' '}
                            <FormControl name="idNo" type="text" placeholder="输入后4位即可" onChange={this.handleChange.bind(this)} />
                        </FormGroup>
                        {'  '}
                        <Button bsStyle="info" onClick = {this.doSearch.bind(this)}>查询</Button>
                        </Form>
                        <hr/>
                        <BootstrapTable data={this.state.products}  striped hover>
                            <TableHeaderColumn isKey dataField='id'>Product ID</TableHeaderColumn>
                            <TableHeaderColumn dataField='name'>Product Name</TableHeaderColumn>
                            <TableHeaderColumn dataField='price'>Product Price</TableHeaderColumn>
                        </BootstrapTable>
                    </div>
                </div>
            </div>
        );
    }
};

export default TraineeQuery;
