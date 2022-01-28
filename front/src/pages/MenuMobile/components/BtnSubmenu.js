import { useState } from "react";
import { IoIosArrowDown } from "react-icons/io";
import { Link } from "react-router-dom";

const BtnSubmenu = ({ category, subCategory, list }) => {
  const [showDropDown, setshowDropDown] = useState(false);
  const handleClick = () => {
    setshowDropDown(!showDropDown);
  };
  return (
    <div onClick={handleClick} className="dropdown">
      <button className="btn-menu">
        {subCategory}
        <IoIosArrowDown
          className={`btn-menu__icon ${
            showDropDown && "btn-menu__icon_rotate"
          }`}
        />
      </button>
      <div
        className={`dropdown__list ${showDropDown && "dropdown__list_show"}`}
      >
        {list.map((el, i) => (
          <Link
            className="dropdown__link"
            key={i}
            to={`/${category.toLowerCase()}/${subCategory.toLowerCase()}/${el.title.toLowerCase()}`}
          >
            {el.title}
          </Link>
        ))}
      </div>
    </div>
  );
};

export default BtnSubmenu;
