import ProductFound from "./ProductFound";
import "./GridProducts.css";
import { useEffect } from "react/cjs/react.development";
import { useDispatch } from "react-redux";
import {
  fetchProducts,
  selectProducts,
} from "../../features/products/productsSlice";
import { useSelector } from "react-redux";
const GridProductsFound = () => {
  // const dispatch = useDispatch();
  // const products = useSelector(selectProducts);

  useEffect(() => {
    const fetchProducts = async () => {
      const res = await fetch("http://34.133.133.181:8080/products");
      console.log(res);
      const data = await res.json();
      console.log(data);
    };
    fetchProducts();

    // dispatch(fetchProducts("http://localhost:3000/products"));
  }, []);
  return (
    <section className="grid-products">
      {/* {products?.map((product, i) => (
        <ProductFound
          key={product.id}
          img={product.urlImage}
          title={product.name}
          price={product.price}
          altDetails={product.name}
        />
      ))} */}
    </section>
  );
};

export default GridProductsFound;
