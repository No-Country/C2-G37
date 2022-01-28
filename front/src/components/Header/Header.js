import "./Header.css";
import Search from "./Search";
import logo from "../../assets/img/logo transparent.png";
import MenuDesktop from "./MenuDesktop";
import NavDesktop from "./NavDesktop";
import { CgMenu } from "react-icons/cg";

const Header = () => {
  const handleClick = () => {
    const $menu = document.querySelector(".menu");
    $menu.classList.add("show");
  };
  return (
    <header className="header ">
      <MenuDesktop />
      <div className="header__container">
        <div className="logo-mobile">
          <h1 className="logo-mobile__title">NO CRUELTY STORE</h1>
          <img className="logo-img" src={logo} alt="logo" />
        </div>
        <button onClick={handleClick} aria-label="menú" className="menu-btn">
          <CgMenu />
        </button>
      </div>
      <div className="header__right-side">
        <Search />
        <NavDesktop />
      </div>
    </header>
  );
};

export default Header;
