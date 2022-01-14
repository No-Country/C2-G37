import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import Cart from "./pages/Cart/Cart";
import Favorites from "./pages/Favorites";
import Home from "./pages/Home";
import MenuMobile from "./pages/MenuMobile/MenuMobile";
import Profile from "./pages/Profile";
function App() {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/menu" element={<MenuMobile />} />
          <Route path="/favorites" element={<Favorites />} />
          <Route path="/user" element={<Profile />} />
          <Route path="/cart" element={<Cart />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
