import notFound from "../assets/img/notFound.svg";
import "./NotFound.css";
const NotFound = () => {
  return (
    <main className="not-found scroll">
      <img
        className="not-found__img"
        src={notFound}
        alt="página no encontrada"
      />
      <h2 className="not-found__title">No podemos encontrar la página</h2>
    </main>
  );
};

export default NotFound;
