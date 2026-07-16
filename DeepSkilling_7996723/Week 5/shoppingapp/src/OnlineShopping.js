import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

    constructor() {

        super();

        this.items = [
            new Cart("Laptop", 50000),
            new Cart("Mobile", 20000),
            new Cart("Headphones", 3000),
            new Cart("Keyboard", 1500),
            new Cart("Mouse", 800)
        ];
    }

    render() {

        return (

            <div>

                <h1>Online Shopping Cart</h1>

                {
                    this.items.map((item, index) => (

                        <div key={index}>

                            <h3>{item.itemName}</h3>

                            <p>₹ {item.price}</p>

                            <hr />

                        </div>

                    ))
                }

            </div>
        );
    }
}

export default OnlineShopping;