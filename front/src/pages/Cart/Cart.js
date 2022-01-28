import EmptyCart from "./components/EmptyCart";
import "./Cart.css";
import demoProducts from "../../assets/demoProducts";
import CartItem from "./components/CartItem";
import React, { useState } from "react";
import ReactDOM from "react-dom";
import Success from "./components/Success";

// const options = {
//   "client-id":
//     "AQmz_uNWO1hCfPGUj_gTyXfnaHiIpNUd0wgGdyL54KCnedWHvTkhAJZFcihv5Idj0UtwP3wzkXlWrUwc",
// };

const PaypalButton = window.paypal.Buttons.driver("react", { React, ReactDOM });
const Cart = () => {
  const [payerName, setPayerName] = useState("");
  const [isPaymentSuccess, setIsPaymentSuccess] = useState(false);
  const isCartEmpty = false;

  const createOrder = (data, actions) => {
    return actions.order.create({
      purchase_units: [
        {
          amount: {
            value: "40",
          },
        },
      ],
    });
  };
  const onApprove = (data, actions) => {
    return actions.order.capture().then((details) => {
      const name = details.payer.name.given_name;
      setPayerName(name);
      setIsPaymentSuccess(true);
    });
  };
  return (
    <main className="cart scroll">
      {isCartEmpty && <EmptyCart />}
      <PaypalButton
        onApprove={(data, actions) => onApprove(data, actions)}
        createOrder={(data, actions) => createOrder(data, actions)}
      />
      {isPaymentSuccess && (
        <Success
          text={`Transaccion completada por ${payerName}`}
          setIsPaymentSuccess={setIsPaymentSuccess}
        />
      )}
      <section className="cart-list">
        {demoProducts.map((item, i) => (
          <CartItem
            key={i}
            name="demo name"
            price="demo price"
            img={item.img}
            altItem="demo product"
          />
        ))}
      </section>

      {/* <div className="pay">
          <p>Total:</p>
          <button className="pay-btn">Pagar</button>
        </div> */}
    </main>
  );
};

export default Cart;
