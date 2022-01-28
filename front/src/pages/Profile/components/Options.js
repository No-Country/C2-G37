import React from "react";
import { useDispatch } from "react-redux";
import { isUserAuth } from "../../../features/authUser/authSlice";

const Options = () => {
  const dispatch = useDispatch();
  const handleLogout = () => {
    dispatch(isUserAuth(false));
  };
  return (
    <section className="options">
      <h2>Mi cuenta</h2>
      <div className="options__info">
        <h3>Detalles personales</h3>
        <p>Datos de envío</p>
        <h3>Detalles de ordenes</h3>
        <p>Historial</p>
      </div>
      <button
        onClick={handleLogout}
        aria-label="cerrar sesión"
        className="btn-warning"
      >
        Cerrar Sesión
      </button>
    </section>
  );
};

export default Options;
