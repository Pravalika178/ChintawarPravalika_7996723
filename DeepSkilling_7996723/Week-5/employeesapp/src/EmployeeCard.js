import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard(props) {

  const theme = useContext(ThemeContext);

  return (
    <div
      style={{
        border: "1px solid black",
        padding: "10px",
        margin: "10px"
      }}
    >
      <h3>{props.employee.name}</h3>

      <p>{props.employee.designation}</p>

      <button className={theme}>
        View Details
      </button>

    </div>
  );
}

export default EmployeeCard;