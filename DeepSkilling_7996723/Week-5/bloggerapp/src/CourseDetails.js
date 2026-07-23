import React from "react";

function CourseDetails() {

  const courses = [
    {
      id: 1,
      name: "React",
      date: "05-07-2026"
    },
    {
      id: 2,
      name: "Angular",
      date: "10-07-2026"
    }
  ];

  return (
    <div>
      <h1>Course Details</h1>

      {courses.map(course => (
        <div key={course.id}>
          <h3>{course.name}</h3>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
}

export default CourseDetails;