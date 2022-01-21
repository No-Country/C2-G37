import { IoIosArrowBack } from "react-icons/io";
import BtnSubmenu from "./BtnSubmenu";

const Submenu = ({ setShowMenu, showMenu, idToFindCategories, categories }) => {
  const categoriesFound = categories.find(
    (category) => category.id === idToFindCategories
  );
  return (
    <section className={`sub-section ${showMenu && "sub-section_show"}`}>
      <header onClick={() => setShowMenu(false)} className="headers-menu">
        <h4 className="sub-section__title ">
          <IoIosArrowBack className="sub-section__icon" />
          {categoriesFound?.title}
        </h4>
      </header>
      {categoriesFound?.subCategories.map(
        ({ title, list }, i) =>
          list.length > 0 && <BtnSubmenu key={i} title={title} list={list} />
      )}
    </section>
  );
};

export default Submenu;
