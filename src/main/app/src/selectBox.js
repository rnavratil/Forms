import React from 'react';
import Select from 'react-select';
import PropTypes from 'prop-types';

export default class SelectBox extends React.Component {
    constructor(props) {
        super(props);
        this.handleChanged = this.handleChanged.bind(this);
    }

    handleChanged(event) {
        this.props.onChangedValue(event.value);
    }

    render() {
        return (
            <form className="form-select">
                <label>
                    {this.props.labelName}
                </label>
                <div className="form-selectBox">
                    <Select options={this.props.options} onChange={this.handleChanged.bind(this)}/>
                </div>    
          </form>
        );
    }
}

SelectBox.propTypes = {
    onChangedValue: PropTypes.func,
    labelName: PropTypes.string,
    options: PropTypes.array
}

