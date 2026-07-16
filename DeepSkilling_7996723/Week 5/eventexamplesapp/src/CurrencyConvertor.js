import React, { Component } from "react";

class CurrencyConvertor extends Component {

  constructor() {
    super();

    this.state = {
      amount: "",
      currency: ""
    };
  }

  handleAmount = (e) => {
    this.setState({
      amount: e.target.value
    });
  };

  handleCurrency = (e) => {
    this.setState({
      currency: e.target.value
    });
  };

  handleSubmit = () => {

    const euroAmount =
      parseFloat(this.state.amount) * 80;

    alert(
      "Converting to Euro Amount is " +
      euroAmount
    );
  };

  render() {
    return (
      <div>

        <h1 style={{ color: "green" }}>
          Currency Convertor!!!
        </h1>

        <label>Amount:</label>

        <input
          type="text"
          value={this.state.amount}
          onChange={this.handleAmount}
        />

        <br /><br />

        <label>Currency:</label>

        <input
          type="text"
          value={this.state.currency}
          onChange={this.handleCurrency}
        />

        <br /><br />

        <button onClick={this.handleSubmit}>
          Submit
        </button>

      </div>
    );
  }
}

export default CurrencyConvertor;