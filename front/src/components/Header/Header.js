import "./Header.css";
import Search from "./Search";
import logo from "../assets/img/logo transparent.png";
const Header = () => {
  return (
    <header className="header">
      <div className="logo-mobile">
        <h1 className="logo-mobile__title">NO CRUELTY STORE</h1>
        <img className="logo-mobile__img" src={logo} alt="logo" />
      </div>
      <Search />
    </header>
  );
};

export default Header;
