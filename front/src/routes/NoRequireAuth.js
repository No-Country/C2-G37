import React from "react";
import { useSelector } from "react-redux";
import { Navigate } from "react-router-dom";
import { selectUserAuth } from "../features/authUser/authSlice";

const NoRequireAuth = ({ children }) => {
  const isAuth = useSelector(selectUserAuth);
  return !isAuth ? children : <Navigate to="/" />;
};

export default NoRequireAuth;
