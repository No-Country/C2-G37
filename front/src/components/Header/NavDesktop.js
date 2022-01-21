import { AiOutlineHeart, AiOutlineUser } from "react-icons/ai";
import { FiShoppingCart } from "react-icons/fi";
import LiButton from "./LiButton";
const NavDesktop = () => {
  return (
    <nav className="nav-btns-desk">
      <ul className="nav-btns__ul">
        <LiButton delayAnimation={2} to="/favorites" icon={AiOutlineHeart} />
        <LiButton delayAnimation={3} to="/user" icon={AiOutlineUser} />
        <LiButton delayAnimation={4} to="/cart" icon={FiShoppingCart} />
      </ul>
    </nav>
  );
};

export default NavDesktop;
