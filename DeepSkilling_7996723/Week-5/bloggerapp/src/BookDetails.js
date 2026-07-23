import React from "react";

function BookDetails() {

  const books = [
    { id: 1, name: "Master React", price: 670 },
    { id: 2, name: "Deep Dive into Angular 11", price: 800 },
    { id: 3, name: "Mongo Essentials", price: 450 }
  ];

  return (
    <div>
      <h1>Book Details</h1>

      {books.map(book => (
        <div key={book.id}>
          <h3>{book.name}</h3>
          <p>Price: {book.price}</p>
        </div>
      ))}
    </div>
  );
}

export default BookDetails;