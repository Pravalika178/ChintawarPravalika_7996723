import React, { useState } from "react";
import EmployeeList from "./EmployeesList";
import ThemeContext from "./ThemeContext";

function App() {

  const [theme, setTheme] = useState("light");

  const employees = [
    {
      id: 1,
      name: "Pravalika",
      designation: "Software Engineer"
    },
    {
      id: 2,
      name: "Aishwarya",
      designation: "Senior Developer"
    },
    {
      id: 3,
      name: "Ravali",
      designation: "Team Lead"
    }
  ];

  const changeTheme = () => {
    setTheme(theme === "light" ? "dark" : "light");
  };

  return (
    <ThemeContext.Provider value={theme}>

      <div>
        <h1>Employee Management Application</h1>

        <button onClick={changeTheme}>
          Change Theme
        </button>

        <EmployeeList employees={employees} />
      </div>

    </ThemeContext.Provider>
  );
}

export default App;