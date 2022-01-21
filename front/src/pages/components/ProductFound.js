import { FiShoppingCart } from "react-icons/fi";
import { AiOutlineHeart } from "react-icons/ai";

const ProductFound = ({
  img,
  altDetails,
  description = "",
  title,
  price = "Precio sin establecer",
}) => {
  return (
    <article className="card">
      <section className="card__visual">
        <img src={img} alt={altDetails} />
        <button
          aria-label="agragar al carrito"
          className="card__icon card__icon_add"
        >
          <FiShoppingCart />
        </button>
        <button
          aria-label="agregar a favoritos"
          className="card__icon card__icon_fav"
        >
          <AiOutlineHeart />
        </button>
      </section>
      <section className="card__info">
        <h4>{title}</h4>
        <p>${price}</p>
      </section>
    </article>
  );
};

export default ProductFound;
