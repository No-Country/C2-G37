import { NavLink } from "react-router-dom";

const LiButton = ({ delayAnimation = 0, to, icon: Icon, title = null }) => {
  return (
    <li style={{ "--i": delayAnimation }}>
      <NavLink
        to={to}
        className={({ isActive }) => `btns-link ${isActive ? "active" : ""}`}
      >
        <Icon />
        {title && <span className="btns-link__name">{title}</span>}
      </NavLink>
    </li>
  );
};

export default LiButton;
