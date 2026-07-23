import React, { Component } from "react";

class CountPeople extends Component {

    constructor(props) {
        super(props);

        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    UpdateEntry = () => {
        this.setState({
            entrycount: this.state.entrycount + 1
        });
    }

    UpdateExit = () => {
        this.setState({
            exitcount: this.state.exitcount + 1
        });
    }

    render() {

        const containerStyle = {
            marginTop: "250px",
            display: "flex",
            justifyContent: "space-around",
            alignItems: "center"
        };

        return (
            <div style={containerStyle}>

                <div>
                    <button onClick={this.UpdateEntry}>
                        Login
                    </button>

                    {" "}
                    {this.state.entrycount} People Entered!!!
                </div>

                <div>
                    <button onClick={this.UpdateExit}>
                        Exit
                    </button>

                    {" "}
                    {this.state.exitcount} People Left!!!
                </div>

            </div>
        );
    }
}

export default CountPeople;