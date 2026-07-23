import React, { Component } from "react";
import User from "./User";
import Guest from "./Guest";

class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  login = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  logout = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {

    if (this.state.isLoggedIn) {
      return (
        <User onLogout={this.logout} />
      );
    }

    return (
      <Guest onLogin={this.login} />
    );
  }
}

export default App;