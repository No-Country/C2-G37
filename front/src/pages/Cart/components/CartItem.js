import { FiPlus, FiMinus, FiX } from "react-icons/fi";
const CartItem = ({ img, altItem = "producto del carrito", name, price }) => {
  return (
    <article className="cart-item">
      <div className="cart-item__visual">
        <img className="cart-item__img" src={img} alt={altItem} />
        <div className="cart-item__count">
          <FiMinus className="icon-click" /> 0 <FiPlus className="icon-click" />
        </div>
      </div>
      <section className="cart-item__info">
        <header className="cart-item__name">
          <h4>{name}</h4>
          <button className="btn-cart" aria-label="borrar producto completo">
            <FiX className="icon-click" />
          </button>
        </header>
        <div className="cart-item__details">
          <p>{price}</p>
        </div>
      </section>
    </article>
  );
};

export default CartItem;
