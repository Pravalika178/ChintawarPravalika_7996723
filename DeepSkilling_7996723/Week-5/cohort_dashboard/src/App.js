import React from "react";
import CohortDetails from "./CohortDetails";

function App() {
  return (
    <div>
      <CohortDetails
        name="INTADMDF10 .NET FSD"
        technology=".NET"
        coach="Pravalika"
        startDate="19-Jan-2022"
        status="ongoing"
      />

      <CohortDetails
        name="ADM21JF014 Java FSD"
        technology="Java"
        coach="Jay"
        startDate="20-Aug-2023"
        status="completed"
      />
    </div>
  );
}

export default App;