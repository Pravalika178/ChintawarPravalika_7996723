import React, { Component } from "react";

class ComplaintRegister extends Component {

  constructor(props) {
    super(props);

    this.state = {
      employeeName: "",
      complaint: ""
    };
  }

  handleNameChange = (event) => {
    this.setState({
      employeeName: event.target.value
    });
  };

  handleComplaintChange = (event) => {
    this.setState({
      complaint: event.target.value
    });
  };

  handleSubmit = (event) => {

    event.preventDefault();

    const referenceNumber =
      Math.floor(Math.random() * 10000);

    alert(
      `Thanks ${this.state.employeeName}\nYour Complaint was Submitted.\nReference Number: ${referenceNumber}`
    );
  };

  render() {
    return (
      <div>

        <h1 style={{ color: "red" }}>
          Register your complaints here!!!
        </h1>

        <form onSubmit={this.handleSubmit}>

          <div>
            <label>Name:</label>
            <input
              type="text"
              value={this.state.employeeName}
              onChange={this.handleNameChange}
            />
          </div>

          <br />

          <div>
            <label>Complaint:</label>
            <textarea
              value={this.state.complaint}
              onChange={this.handleComplaintChange}
            />
          </div>

          <br />

          <button type="submit">
            Submit
          </button>

        </form>

      </div>
    );
  }
}

export default ComplaintRegister;