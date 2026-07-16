import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  let book = <BookDetails />;
  let blog = <BlogDetails />;
  let course = <CourseDetails />;

  return (
    <div>
      {book}
      {blog}
      {course}
    </div>
  );
}

export default App;