import logo from "../../assets/img/logo transparent.png";
import { Link } from "react-router-dom";
import { initialOptions } from "../../pages/MenuMobile/MenuMobile";
import DropdownDesktop from "./DropdownDesktop";
const MenuDesktop = () => {
  return (
    <nav className="menu-desk">
      <Link to="/">
        <img src={logo} alt="logo" className="logo-img" />
      </Link>
      <ul className="menu-desk__wrapper">
        {initialOptions.map((categorie) => (
          <DropdownDesktop
            key={categorie.id}
            title={categorie.title}
            subcategories={categorie.subCategories}
          />
        ))}
      </ul>
    </nav>
  );
};

export default MenuDesktop;
