import React from "react";
import DropdownCategory from "./DropdownCategory";

const DropdownDesktop = ({ title, subcategories }) => {
  return (
    <li className="dropdown">
      {title}
      <div className="dropdown__menu">
        {subcategories.map((subcategory, i) => (
          <DropdownCategory
            key={i}
            categoryName={title}
            subCategoryName={subcategory.title}
            subCategoryList={subcategory.list}
          />
        ))}
      </div>
    </li>
  );
};

export default DropdownDesktop;
