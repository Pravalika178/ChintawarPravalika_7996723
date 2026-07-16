import React from "react";

function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Scott"
    },
    {
      id: 2,
      title: "Installation",
      author: "Alex"
    }
  ];

  return (
    <div>
      <h1>Blog Details</h1>

      {blogs.map(blog => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <p>{blog.author}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;