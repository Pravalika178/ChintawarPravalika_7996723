import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat", score: 90 },
        { name: "Rohit", score: 85 },
        { name: "Gill", score: 45 },
        { name: "Rahul", score: 67 },
        { name: "Iyer", score: 78 },
        { name: "Pant", score: 92 },
        { name: "Jadeja", score: 55 },
        { name: "Ashwin", score: 88 },
        { name: "Shami", score: 40 },
        { name: "Bumrah", score: 72 },
        { name: "Siraj", score: 65 }
    ];

    const lowScorers =
        players.filter(
            player => player.score < 70
        );

    return (

        <div>

            <h2>List of Players</h2>

            {
                players.map((player, index) => (

                    <p key={index}>
                        {player.name} - {player.score}
                    </p>

                ))
            }

            <h2>Players with Score Below 70</h2>

            {
                lowScorers.map((player, index) => (

                    <p key={index}>
                        {player.name} - {player.score}
                    </p>

                ))
            }

        </div>

    );
}

export default ListofPlayers;