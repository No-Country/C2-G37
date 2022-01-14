import { useEffect, useState } from "react";
import BtnMenu from "./components/BtnMenu";
import Submenu from "./components/Submenu";
import "./MenuMobile.css";
const initialOptions = [
  {
    id: 1,
    title: "MUJERES",
    categories: {
      vestuario: "Vestuario",
      vestuarioList: [
        { title: "Camisetas" },
        { title: "Camisas" },
        { title: "Vestidos" },
        { title: "Pantalones" },
        { title: "Chaquetas" },
        { title: "Yoga" },
      ],
      accesorios: "Accesorios",

      accesoriosList: [
        { title: "Bolsos" },
        { title: "Maquillaje" },
        { title: "Bisutería" },
      ],
      zapatot: "Zapatos",
      zapatosList: [
        { title: "Botas" },
        { title: "Tacones" },
        { title: "Sandalias" },
        { title: "Tenis" },
        { title: "Crocs" },
        { title: "Babuchas" },
      ],
    },
  },
  {
    id: 2,
    title: "HOMBRES",
    categories: {
      vestuario: [
        { title: "Camisetas" },
        { title: "Camisas" },
        { title: "Pantalones" },
        { title: "Chaquetas" },
        { title: "Yoga" },
      ],
      accesorios: [],
      zapatos: [{ title: "Tenis" }],
    },
  },
];
const MenuMobile = () => {
  const [data, setData] = useState([]);
  useEffect(() => {
    setData(initialOptions);
  }, []);
  const [showMenu, setShowMenu] = useState(false);
  const [toFindCategories, setToFindCategories] = useState(null);
  const handleClick = (title) => {
    setShowMenu(!showMenu);
    setToFindCategories(title);
  };
  console.log("renderizando menu");
  return (
    <main className="menu">
      <h4 className="menu__title headers-menu">Menu</h4>
      <section className="menu__section">
        {data.map(({ id, title }) => (
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
        toFindCategories={toFindCategories}
        data={data}
      />
    </main>
  );
};

export default MenuMobile;
