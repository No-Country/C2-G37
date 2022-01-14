import { AiOutlineHome, AiOutlineHeart, AiOutlineUser } from "react-icons/ai";
import { CgMenu } from "react-icons/cg";
import { FiShoppingCart } from "react-icons/fi";
import { NavLink } from "react-router-dom";
import LiButton from "./LiButton";
import "./NavMobile.css";
const NavMobile = () => {
  return (
    <nav className="nav-btns">
      <ul className="nav-btns__ul">
        <LiButton
          delayAnimation={2}
          to="/"
          icon={AiOutlineHome}
          title="Inicio"
        />
        <LiButton delayAnimation={3} to="/menu" icon={CgMenu} title="Menu" />
        <LiButton
          delayAnimation={4}
          to="/favorites"
          icon={AiOutlineHeart}
          title="Favoritos"
        />
        <LiButton
          delayAnimation={4}
          to="/user"
          icon={AiOutlineUser}
          title="Perfil"
        />

        <li style={{ "--i": 5 }}>
          <NavLink to="/cart" className={`cart-icon btns-link`}>
            <span className="cart-icon__position">
              <FiShoppingCart />
            </span>
          </NavLink>
          <span className="btns-link__name">Carrito</span>
        </li>
      </ul>
    </nav>
  );
};

export default NavMobile;
