import { configureStore } from "@reduxjs/toolkit";
import authSlice from "../features/authUser/authSlice";
import productsSlice from "../features/products/productsSlice";

export default configureStore({
  reducer: {
    auth: authSlice,
    products: productsSlice,
  },
});
