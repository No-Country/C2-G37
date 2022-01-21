import EmptyFavorites from "../Favorites/components/EmptyFavorites";
import PathName from "../components/PathName";
import WrapperFilteredProducts from "../components/WrapperFilteredProducts";

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
