import girl from "../../../assets/img/vegan-girl.png";
import crueltyFree from "../../../assets/img/Cruelty-Free Badge.svg";
import ecoFriendly from "../../../assets/img/Eco Friendly Badge.svg";
import vegan from "../../../assets/img/Vegan Badge.svg";
const CardMain = () => {
  return (
    <section className="home-card row-reverse">
      <div className="home-card__desk-left">
        <div className="home-card__icons">
          <div className="icon-home">
            <img src={crueltyFree} alt="logo" /> <p>Cruelty free</p>
          </div>
          <div className="icon-home">
            <img src={ecoFriendly} alt="logo" /> <p>Eco friendly</p>
          </div>
          <div className="icon-home">
            <img src={vegan} alt="logo" /> <p>Vegan</p>
          </div>
        </div>
        <h2 className="home-card__title">
          Por una vida bella y libre de sufrimiento
        </h2>
      </div>
      <div className="home-card__desk-right">
        <img src={girl} alt="mujer vegana" />
      </div>
    </section>
  );
};

export default CardMain;
