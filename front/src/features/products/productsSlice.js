import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

export const fetchProducts = createAsyncThunk(
  "products/getProducts",
  async (url) => {
    const res = await fetch(url);
    const data = await res.json();

    return data;
    // if (!res.ok) throw new Error(`${res.status}: ${res.statusText}`);
    // console.log(data);
  }
);

const initialState = {
  listProducts: [],
};

const productsSlice = createSlice({
  name: "products",
  initialState,
  reducers: {},
  extraReducers: {
    [fetchProducts.fulfilled]: (state, action) => {
      state.listProducts = action.payload;
    },
  },
});

export const {} = productsSlice.actions;
export const selectProducts = (state) => state.products.listProducts;
export default productsSlice.reducer;
