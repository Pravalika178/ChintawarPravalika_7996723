import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {
  state = {
    repos: []
  };

  componentDidMount() {
    const client = new GitClient();

    client.getRepositories("techiesyed")
      .then(repos => {
        this.setState({ repos });
      });
  }

  render() {
    return (
      <div>
        <h2>Repository Names</h2>

        <ul>
          {this.state.repos.map(repo => (
            <li key={repo}>{repo}</li>
          ))}
        </ul>
      </div>
    );
  }
}

export default App;