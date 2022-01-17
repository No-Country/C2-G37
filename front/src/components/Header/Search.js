import "./Search.css";
import { RiSearch2Line } from "react-icons/ri";
const Search = () => {
  return (
    <form className="search-form">
      <input
        type="text"
        className="search__product"
        placeholder="Buscar productos, marcas y más"
      />
      <button aria-label="buscar" className="search__btn">
        <RiSearch2Line />
      </button>
    </form>
  );
};

export default Search;
