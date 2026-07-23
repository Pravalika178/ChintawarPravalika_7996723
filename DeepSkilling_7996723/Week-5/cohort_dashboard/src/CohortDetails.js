import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    return (
        <div className={styles.box}>

            <h3
                style={{
                    color:
                        props.status === "ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {props.status}
            </h3>

            <dl>
                <dt>Cohort Name</dt>
                <dd>{props.name}</dd>

                <dt>Technology</dt>
                <dd>{props.technology}</dd>

                <dt>Coach</dt>
                <dd>{props.coach}</dd>

                <dt>Start Date</dt>
                <dd>{props.startDate}</dd>
            </dl>

        </div>
    );
}

export default CohortDetails;