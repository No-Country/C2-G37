import emptyCart from "../../../assets/img/empty cart.png";
const EmptyCart = () => {
  return (
    <section className="empty-section">
      <img className="empty-section__img" src={emptyCart} alt="carrito vacío" />
      <div className="empty-section__wrapper">
        <h3 className="empty-section__title">Tú carro está vacío</h3>
        <p className="empty-section__text">
          Parece que aún no has añadido ningún articulo a tu carrito. Comiensa a
          comprar
        </p>
      </div>
    </section>
  );
};

export default EmptyCart;
