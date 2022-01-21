import EmptyCart from "./components/EmptyCart";
import "./Cart.css";
import demoProducts from "../../assets/demoProducts";
import CartItem from "./components/CartItem";
const Cart = () => {
  const isCartEmpty = false;
  return (
    <main className="scroll">
      {isCartEmpty && <EmptyCart />}

      <section className="cart-list">
        {demoProducts.map((item, i) => (
          <CartItem
            key={i}
            name="demo price"
            price="demo price"
            img={item.img}
            altItem="demo product"
          />
        ))}
      </section>
      <div className="pay">
        <p>Total: </p>
        <button className="pay-btn">Pagar</button>
      </div>
    </main>
  );
};

export default Cart;
