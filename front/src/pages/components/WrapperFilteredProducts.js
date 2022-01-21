import HeaderFilters from "./HeaderFilters";
import GridProductsFound from "../components/GridProductsFound";

const WrapperFilteredProducts = () => {
  return (
    <div className="wrapper-filtered">
      <section>
        <HeaderFilters />
        <GridProductsFound />
      </section>
    </div>
  );
};

export default WrapperFilteredProducts;
