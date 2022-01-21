import { BiDotsVerticalRounded } from "react-icons/bi";
import { FiPlus, FiMinus } from "react-icons/fi";
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
          <BiDotsVerticalRounded className="icon-click" />
        </header>
        <div className="cart-item__details">
          <p>{price}</p>
        </div>
      </section>
    </article>
  );
};

export default CartItem;
