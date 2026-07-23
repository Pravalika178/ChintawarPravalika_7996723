import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {

  const average = props.total / props.goal;

  return (
    <div className="box">
      <h1>Student Score Card</h1>

      <h2>Name : {props.name}</h2>

      <h2>School : {props.school}</h2>

      <h2>Total Score : {props.total}</h2>

      <h2>Goal Subjects : {props.goal}</h2>

      <h2>Average Score : {average}</h2>
    </div>
  );
}

export default CalculateScore;