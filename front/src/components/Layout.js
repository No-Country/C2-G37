import Header from "../components/Header/Header";
import NavMobile from "./Header/NavMobile";

const Layout = ({ children }) => {
  return (
    <div className="App">
      <Header />
      {children}
      <NavMobile />
    </div>
  );
};

export default Layout;
