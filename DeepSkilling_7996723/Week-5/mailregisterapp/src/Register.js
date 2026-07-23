import React, { Component } from "react";

class Register extends Component {

  constructor(props) {
    super(props);

    this.state = {
      name: "",
      email: "",
      password: "",
      errors: {}
    };
  }

  handleChange = (event) => {

    const { name, value } = event.target;

    this.setState({
      [name]: value
    });
  };

  validateForm = () => {

    let errors = {};

    if (this.state.name.length < 5) {
      errors.name =
        "Name should contain at least 5 characters";
    }

    if (
      !this.state.email.includes("@") ||
      !this.state.email.includes(".")
    ) {
      errors.email =
        "Email should contain @ and .";
    }

    if (this.state.password.length < 8) {
      errors.password =
        "Password should contain at least 8 characters";
    }

    this.setState({ errors });

    return Object.keys(errors).length === 0;
  };

  handleSubmit = (event) => {

    event.preventDefault();

    if (this.validateForm()) {

      alert(
        "Registration Successful"
      );

      this.setState({
        name: "",
        email: "",
        password: "",
        errors: {}
      });
    }
  };

  render() {

    return (
      <div>

        <h2>User Registration Form</h2>

        <form onSubmit={this.handleSubmit}>

          <div>
            <label>Name :</label>

            <input
              type="text"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
            />

            <div style={{ color: "red" }}>
              {this.state.errors.name}
            </div>
          </div>

          <br />

          <div>
            <label>Email :</label>

            <input
              type="text"
              name="email"
              value={this.state.email}
              onChange={this.handleChange}
            />

            <div style={{ color: "red" }}>
              {this.state.errors.email}
            </div>
          </div>

          <br />

          <div>
            <label>Password :</label>

            <input
              type="password"
              name="password"
              value={this.state.password}
              onChange={this.handleChange}
            />

            <div style={{ color: "red" }}>
              {this.state.errors.password}
            </div>
          </div>

          <br />

          <button type="submit">
            Register
          </button>

        </form>

      </div>
    );
  }
}

export default Register;