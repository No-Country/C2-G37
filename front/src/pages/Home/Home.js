import React from "react";
import Footer from "../Footer/Footer";
import CardLayout from "./components/CardLayout";
import CardMain from "./components/CardMain";
import veganFood from "../../assets/img/vegan-food.png";
import cosmeticos from "../../assets/img/cosmeticos.png";
import "./Home.css";

const Home = () => {
  return (
    <>
      <main className="home scroll">
        <CardMain />
        <CardLayout className="home-card">
          <img src={veganFood} alt="comida vegana" />
        </CardLayout>
        <CardLayout className="home-card">
          <img src={cosmeticos} alt="" />
        </CardLayout>
        <Footer />
      </main>
    </>
  );
};

export default Home;
