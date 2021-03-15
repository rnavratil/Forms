import React from 'react';
import PropTypes from 'prop-types';

export default class TextArea extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: "", count: 0};
        this.handleChanged = this.handleChanged.bind(this);
    }

    handleChanged(event) {
        this.setState({value: event.target.value});
        this.props.onChangedValue(event.target.value);

        let count = event.target.value.length;
        this.setState({count: count})     
    }

    render() {
        return (
            <form className="form-textArea">
                <label>
                    {this.props.labelName}
                </label>
                <textArea type="text" value={this.state.value} onChange={this.handleChanged.bind(this)}/>
                <p id="counter">{this.state.count}/5000</p>
          </form>
        );
    }
}

TextArea.propTypes = {
    labelName: PropTypes.string,
    onChangedValue: PropTypes.func
}