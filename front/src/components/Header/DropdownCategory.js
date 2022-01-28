import React from "react";
import { Link } from "react-router-dom";

const DropdownCategory = ({
  categoryName,
  subCategoryName,
  subCategoryList,
}) => {
  const categoryLower = categoryName.toLowerCase();
  const subCategoryLower = subCategoryName.toLowerCase();
  return (
    <section>
      <h3>{subCategoryName}</h3>
      <ul className="dropdown-subcategory">
        {subCategoryList.map((subCategory, i) => (
          <li key={i}>
            <Link
              className="dropdown__path"
              to={`${categoryLower}/${subCategoryLower}/${subCategory.title.toLowerCase()}`}
            >
              {subCategory.title}
            </Link>
          </li>
        ))}
      </ul>
    </section>
  );
};

export default DropdownCategory;
