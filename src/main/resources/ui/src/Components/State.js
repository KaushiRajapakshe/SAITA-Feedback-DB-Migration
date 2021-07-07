import React, { Component } from 'react';
import '../App.css';
import { SAITA_DETAILS_REQUESTED } from '../Actions';
import { connect } from 'react-redux'

// Test Class
class State extends Component {
    
    // Constructor
    constructor(props) {
        super(props);
    }

    // state
    state = {
        name: ''
    }

    // update state and display implementation
    display = (e) => {
        this.setState({
            name: e.target.value
        })
    }

    // Component Mount
    componentDidMount() {

        this.setState({
            name: "unset"
        })
        this.props.updateSaitaDetails();
    }

    // Component Update
    componentDidUpdate(prevProps) {
        // Typical usage (don't forget to compare props):
        if (this.props.username !== prevProps.username) {
            this.fetchData(this.props.username);
        }
    }

    render() {
        // Assign state values to siataDetail
        let saitaDetail = this.props.saitaDetails;
        return (
            <div className="home-content">
                <h2 className="home-title"><b>Hi {this.props.username}!</b></h2>
                <label className="home-description"> Name   : <span>        </span>
                <input type="text" name="name" onChange={this.display}/>
                </label>
                {this.state.name ? <p className="home-description">My name is {this.state.name}</p> : ""}
                {/* Dispalay Redux state values */}
                {saitaDetail ? <pre className="home-title"> Name : {saitaDetail.Name}     ID : {saitaDetail.ID}     Project : {saitaDetail.Project}     Version : {saitaDetail.Version}</pre> : ''}
            </div>
        );
    }
}
// Get Redux state values and map to props
const mapStateToProps = (state) => {
    const { saitaDetailsReducer } = state;

    return {
        saitaDetails: saitaDetailsReducer.data
    }
}
// Dispatch state values
const mapDispatchToProps = (dispatch) => {
    return {
        updateSaitaDetails: () => dispatch({ type: SAITA_DETAILS_REQUESTED })
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(State)