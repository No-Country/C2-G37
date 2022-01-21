import "./Header.css";
import Search from "./Search";
import logo from "../../assets/img/logo transparent.png";
import MenuDesktop from "./MenuDesktop";
import NavDesktop from "./NavDesktop";

const Header = () => {
  return (
    <header className="header ">
      <MenuDesktop />
      <div className="logo-mobile">
        <h1 className="logo-mobile__title">NO CRUELTY STORE</h1>
        <img className="logo-img" src={logo} alt="logo" />
      </div>
      <div className="header__right-side">
        <Search />
        <NavDesktop />
      </div>
    </header>
  );
};

export default Header;
