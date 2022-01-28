import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  isAuth: true,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    isUserAuth: (state, { payload }) => {
      state.isAuth = payload;
    },
  },
});

export const { isUserAuth } = authSlice.actions;
export const selectUserAuth = (state) => state.auth.isAuth;
export default authSlice.reducer;
