import EmptyFavorites from "../Favorites/components/EmptyFavorites";
import WrapperFilteredProducts from "../../components/GridProductsFound/WrapperFilteredProducts";

const Favorites = () => {
  const isFavEmpty = false;
  return (
    <main className="scroll">
      {isFavEmpty && <EmptyFavorites />}
      {/* <PathName /> */}
      <WrapperFilteredProducts />
    </main>
  );
};

export default Favorites;
