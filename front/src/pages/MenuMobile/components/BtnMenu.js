import { IoIosArrowForward } from "react-icons/io";
const BtnMenu = ({ title, onClick, showMenu, id }) => {
  return (
    <button onClick={() => onClick(id)} className="btn-menu">
      {title}
      <IoIosArrowForward
        className={`btn-menu__icon ${showMenu && "btn-menu__icon_rotate"}`}
      />
    </button>
  );
};

export default BtnMenu;
