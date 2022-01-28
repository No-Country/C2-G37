import HeaderFilters from "./HeaderFilters";
import GridProductsFound from "./GridProductsFound";

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
