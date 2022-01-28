import { Outlet } from "react-router-dom";
import "./App.css";
import Layout from "./components/Layout";
import MenuMobile from "./pages/MenuMobile/MenuMobile";
function App() {
  return (
    <>
      <Layout>
        <MenuMobile />
        <Outlet />
      </Layout>
    </>
  );
}

export default App;
