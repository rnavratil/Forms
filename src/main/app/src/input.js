import React from 'react';
import PropTypes from 'prop-types';

export default class Input extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: "", error: ""};
        this.handleChanged = this.handleChanged.bind(this);
    }

    handleChanged(event) {
        this.setState({value: event.target.value});
        this.props.onChangedValue(event.target.value);
    }

    render() {
        return (
            <form className="form-input">
                <label>
                {this.props.labelName}
                </label>
                <input className="text-field-input" type="text" value={this.state.value} onChange={this.handleChanged.bind(this)} />
                <span style={{color: "red"}}>{this.props.error}</span>
          </form>
        );
    }
}

Input.propTypes = {
    onChangedValue: PropTypes.func,
    labelName: PropTypes.string,
    error: PropTypes.string
}