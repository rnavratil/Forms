import React from 'react';

export default class ErrorField extends React.Component {
	constructor(props) {
		super(props);
			this.state = {errorMessage: ""}
    }

	componentDidMount() {
		this.props.onRef(this)
	}
	
	componentWillUnmount() {
		this.props.onRef(null)
	}

	setMessage(value) {
		this.setState({errorMessage: value})
	}

	render() {
		return (
			<div className="error-field">
				<p>{this.state.errorMessage}</p>
			</div>
		);
	}
}