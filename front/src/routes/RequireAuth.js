import React from "react";
import { Navigate } from "react-router-dom";
import PropTypes from "prop-types";
import { useSelector } from "react-redux";
import { selectUserAuth } from "../features/authUser/authSlice";
const RequireAuth = ({ children }) => {
  const isAuth = useSelector(selectUserAuth);
  return !isAuth ? <Navigate to="/login" /> : children;
};
RequireAuth.propTypes = {
  children: PropTypes.object.isRequired,
};
export default RequireAuth;
