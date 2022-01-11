import { AiOutlineHome, AiOutlineHeart, AiOutlineUser } from "react-icons/ai";
import { CgMenu } from "react-icons/cg";
import { FiShoppingCart } from "react-icons/fi";
import "./NavMobile.css";
const NavMobile = () => {
  return (
    <nav className="nav-mobile">
      <ul>
        <li>
          <AiOutlineHome />
          <span className="section-name">Inicio</span>
        </li>
        <li>
          <CgMenu />
          <span className="section-name">Menú</span>
        </li>
        <li>
          <AiOutlineHeart />
          <span className="section-name">Favoritos</span>
        </li>
        <li>
          <AiOutlineUser />
          <span className="section-name">Perfil</span>
        </li>
        <li>
          <span className="cart-icon">
            <span className="cart-icon__position">
              <FiShoppingCart />
            </span>
          </span>
          <span className="section-name">Carrito</span>
        </li>
      </ul>
    </nav>
  );
};

export default NavMobile;
