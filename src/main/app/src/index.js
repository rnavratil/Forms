import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';
import Button from 'react-bootstrap/Button';
import Input from './input.js';
import TextArea from './textArea.js';
import ErrorField from './errorField.js';
import SelectBox from './selectBox';

const request = require('superagent');

const errorMessageAlphaNumeric = "Please enter alphanumeric characters";
const errorMessageAlphaBetic = "Please enter alphabetic characters";
const errorMessageSize30 = "Maximum is 30 character";
const errorMessageInvalidData = "Invalid data";
const errorMessageServer = "Something is wrong!"
const errorMessageNotFound = "Data not found!"

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = ({
      requestTypes: [],
      selectedType: '',
      name: '',
      surname: '',
      policyNumber: '', 
      note: '',
      errorPolicyNumber: '',
      errorName: '',
      errorSurname: '',
    });

    this.isPolicyNumberValid = false;
    this.isNameValid = false;
    this.isSurnameValid = false;
    this.isNoteValid = false;
    this.isRequestTypesValid = false;
  }

  componentDidMount() {
    request.get("http://localhost:8080/api/public/requestType")
    .then(res => {
      this.setState({requestTypes: res.body});
      this.printError("");
      this.isValidRequestTypes = true;
    }).catch(() => {
      this.printError(errorMessageNotFound);
      this.isValidRequestTypes = false;
    });
  }

  handleNewRequest() {
    if(!this.isPolicyNumberValid || !this.isNameValid || !this.isSurnameValid ||
       !this.isNoteValid || !this.isRequestTypesValid) {
      this.printError(errorMessageInvalidData);
      return;
    }
    
    request.post("http://localhost:8080/api/public/newRequest")
    .send({
      requestTypeId: this.state.selectedType, 
      name: this.state.name,
      surname: this.state.surname,
      policyNumber: this.state.policyNumber,
      note: this.state.note
    })
    .then(res => { 
       if(res.body.success === true) {
        this.printError("");
      } else {
       this.printError(errorMessageInvalidData);
      }
    }).catch(() => {
        this.printError(errorMessageServer);
    });
  }

  handleRequestType(selectedOption) {
    this.setState({selectedType: selectedOption});
    this.isRequestTypesValid = true;
  };

  handleName(value) {
    this.setState({name: value});

    if (!value.match(/^[a-z]+$/i)) {
      this.setState({errorName: errorMessageAlphaBetic});
      this.isNameValid = false;
    }  else if (value.length > 30) {
      this.setState({errorName: errorMessageSize30});
      this.isNameValid = false;
    } else {
      this.setState({errorName: ""});
      this.isNameValid = true; 
    }
  }

  handleSurname(value) {
    this.setState({surname: value});

    if (!value.match(/^[a-z]+$/i)) {
      this.setState({errorSurname: errorMessageAlphaBetic});
      this.isSurnameValid = false;
    }  else if (value.length > 30) {
      this.setState({errorSurname: errorMessageSize30});
      this.isSurnameValid = false;
    } else {
      this.setState({errorSurname: ""});
      this.isSurnameValid = true; 
    }
  }

  handlePolicyNumber(value) {
    this.setState({policyNumber: value});
    if (!value.match(/^[a-z0-9]+$/i)) {
      this.setState({errorPolicyNumber: errorMessageAlphaNumeric});
      this.isPolicyNumberValid = false;
    } else if (value.length > 30) {
      this.setState({errorPolicyNumber: errorMessageSize30});
      this.isPolicyNumberValid = false;
    } else {
      this.setState({errorPolicyNumber: ""});
      this.isPolicyNumberValid = true; 
    }
  }

  handleNote(value) {
    this.setState({note: value});
    if (value.count> 5000) {
      document.getElementById("counter").style.color = "red";
      this.isNoteValid = false;
    } else {
      this.isNoteValid = true;
    }
  }

  printError = (message) => {
    this.errorField.setMessage(message);
  };

  render() {
    return (
      <div className="main-form">
      <label>
        <h1>Contact us</h1>
      </label>
        <SelectBox labelName="Kind of Request" options={this.state.requestTypes} onChangedValue={(value) => this.handleRequestType(value)} />
        <Input labelName="Policy Number" error={this.state.errorPolicyNumber} onChangedValue={(value) => this.handlePolicyNumber(value)}/>
        <Input labelName="Name" error={this.state.errorName} onChangedValue={(value) => this.handleName(value)}/>
        <Input labelName="Surname" error={this.state.errorSurname} onChangedValue={(value) => this.handleSurname(value)}/>
        <TextArea labelName="Your request" onChangedValue={(value) => this.handleNote(value)} />
        <Button className="text-field-button" variant="primary" onClick={this.handleNewRequest.bind(this)}>SEND REQUEST</Button>
        <ErrorField onRef={ref => (this.errorField = ref)} /> 
      </div>
    )
  }
}

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
