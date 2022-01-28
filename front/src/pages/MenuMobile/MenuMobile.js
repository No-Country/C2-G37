import { useEffect, useState } from "react";
import BtnMenu from "./components/BtnMenu";
import Submenu from "./components/Submenu";
import { FiX } from "react-icons/fi";
import "./MenuMobile.css";
export const initialOptions = [
  {
    id: 1,
    title: "MUJERES",
    subCategories: [
      {
        title: "Vestuario",
        list: [
          { title: "Camisetas" },
          { title: "Camisas" },
          { title: "Vestidos" },
          { title: "Pantalones" },
          { title: "Chaquetas" },
          { title: "Yoga" },
        ],
      },
      {
        title: "Accesorios",
        list: [
          { title: "Bolsos" },
          { title: "Maquillaje" },
          { title: "Bisutería" },
        ],
      },
      {
        title: "Zapatos",
        list: [
          { title: "Botas" },
          { title: "Tacones" },
          { title: "Sandalias" },
          { title: "Tenis" },
          { title: "Crocs" },
          { title: "Babuchas" },
        ],
      },
    ],
  },
  {
    id: 2,
    title: "HOMBRES",
    subCategories: [
      {
        title: "Vestuario",
        list: [
          { title: "Camisetas" },
          { title: "Camisas" },
          { title: "Pantalones" },
          { title: "Chaquetas" },
          { title: "Yoga" },
        ],
      },
      {
        title: "Accesorios",
        list: [],
      },
      {
        title: "Zapatos",
        list: [{ title: "Tenis" }],
      },
    ],
  },
];
const MenuMobile = () => {
  const [categories, setCategories] = useState([]);
  useEffect(() => {
    setCategories(initialOptions);
  }, []);
  const [showMenu, setShowMenu] = useState(false);
  const [idToFindCategories, setIdToFindCategories] = useState(null);
  const handleClick = (title) => {
    setShowMenu(!showMenu);
    setIdToFindCategories(title);
  };
  const handleHideMenu = () => {
    const $menu = document.querySelector(".menu");
    $menu.classList.remove("show");
  };
  return (
    <div className="menu scroll">
      <header className="headers-menu">
        <h4 className="menu__title ">Menú</h4>
        <button
          onClick={handleHideMenu}
          aria-label="salir del menú"
          className="menu-btn"
        >
          <FiX />
        </button>
      </header>
      <section className="menu__section">
        {categories.map(({ id, title }) => (
          <BtnMenu
            key={id}
            id={id}
            title={title}
            onClick={handleClick}
            showMenu={showMenu}
          />
        ))}
      </section>
      <Submenu
        setShowMenu={setShowMenu}
        showMenu={showMenu}
        idToFindCategories={idToFindCategories}
        categories={categories}
      />
    </div>
  );
};

export default MenuMobile;
