import { IoIosArrowBack } from "react-icons/io";

const Submenu = ({ setShowMenu, showMenu, toFindCategories, data }) => {
  return (
    <section className={`sub-section ${showMenu && "sub-section_show"}`}>
      <h4
        className="sub-section__title headers-menu"
        onClick={() => setShowMenu(false)}
      >
        <IoIosArrowBack /> Regresar
      </h4>
      {toFindCategories}
    </section>
  );
};

export default Submenu;
