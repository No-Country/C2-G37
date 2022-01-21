import logo from "../../assets/img/logo transparent.png";
import { Link } from "react-router-dom";
const MenuDesktop = () => {
  return (
    <nav className="menu-desk">
      <Link to="/">
        <img src={logo} alt="logo" className="logo-img" />
      </Link>
      <ul className="menu-desk__wrapper">
        <li>MUJERES</li>
        <li>HOMBRES</li>
        <li>NIÑOS</li>
        <li>HOGAR</li>
        <li>COMIDA</li>
      </ul>
    </nav>
  );
};

export default MenuDesktop;
