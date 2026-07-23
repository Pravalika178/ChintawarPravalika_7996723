import React from "react";

function User(props) {
  return (
    <div>
      <h1>Welcome back</h1>
      <button onClick={props.onLogout}>
        Logout
      </button>
    </div>
  );
}

export default User;