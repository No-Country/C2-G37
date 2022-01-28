import React from "react";
import Footer from "../../components/Footer/Footer";
import CardLayout from "./components/CardLayout";
import CardMain from "./components/CardMain";
import cosmeticos from "../../assets/img/cosmeticos.png";
import "./Home.css";

const Home = () => {
  return (
    <>
      <main className="home scroll">
        <CardMain />
        <CardLayout className="home-card"></CardLayout>
        <CardLayout className="home-card">
          <img
            loading="lazy"
            className="home-card__img"
            src={cosmeticos}
            alt="cosmeticos"
          />
          <div className="home-card__info">
            <h2 className="home-card__title">COSMÉTICOS</h2>
            <p>
              Marcas comprometidad con los derechos en defensa de los animales
            </p>
          </div>
        </CardLayout>
        <Footer />
      </main>
    </>
  );
};

export default Home;
