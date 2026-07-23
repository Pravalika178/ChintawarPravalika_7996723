import React from "react";

function App() {

  const officeSpaces = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image:
        "https://images.unsplash.com/photo-1497366754035-f200968a6e72"
    },
    {
      name: "Regus",
      rent: 75000,
      address: "Bangalore",
      image:
        "https://images.unsplash.com/photo-1497366811353-6870744d04b2"
    },
    {
      name: "WeWork",
      rent: 90000,
      address: "Hyderabad",
      image:
        "https://images.unsplash.com/photo-1497366412874-3415097a27e7"
    }
  ];

  return (
    <div style={{ padding: "20px" }}>

      <h1>Office Space Rental App</h1>

      {
        officeSpaces.map((office, index) => (

          <div
            key={index}
            style={{
              border: "1px solid gray",
              padding: "15px",
              marginBottom: "20px",
              width: "400px"
            }}
          >

            <img
              src={office.image}
              alt={office.name}
              width="300"
              height="200"
            />

            <h2>{office.name}</h2>

            <h3
              style={{
                color:
                  office.rent < 60000
                    ? "red"
                    : "green"
              }}
            >
              Rent: Rs. {office.rent}
            </h3>

            <h3>
              Address: {office.address}
            </h3>

          </div>

        ))
      }

    </div>
  );
}

export default App;