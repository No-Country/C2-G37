import { IoIosArrowBack } from "react-icons/io";

const Submenu = ({ setShowMenu, showMenu, toFindCategories, data }) => {
  return (
    <section className={`sub-section ${showMenu && "sub-section_show"}`}>
      <header onClick={() => setShowMenu(false)} className="headers-menu">
        <h4 className="sub-section__title ">
          <IoIosArrowBack className="sub-section__icon" /> Regresar
        </h4>
      </header>
      {toFindCategories}
    </section>
  );
};

export default Submenu;
