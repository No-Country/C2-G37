import emptyFavorites from "../../../assets/img/empty-favorites.png";
const EmptyFavorites = () => {
  return (
    <section className="empty-section">
      <img
        className="empty-section__img"
        src={emptyFavorites}
        alt="no hay articulos favoritos"
      />
      <div className="empty-section__wrapper">
        <h3 className="empty-section__title">No tienes favoritos</h3>
        <p className="empty-section__text">
          en la lista de productos seleccione el corazón para guardarlo en esta
          sección
        </p>
      </div>
    </section>
  );
};

export default EmptyFavorites;
