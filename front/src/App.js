import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import NotFound from "./components/NotFound";
import Cart from "./pages/Cart/Cart";
import Favorites from "./pages/Favorites/Favorites";
import Home from "./pages/Home/Home";
import MenuMobile from "./pages/MenuMobile/MenuMobile";
import Profile from "./pages/Profile";
import Login from "./pages/SignUp/Login";
import Register from "./pages/SignUp/Register";
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
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </Layout>
    </Router>
  );
}

export default App;
