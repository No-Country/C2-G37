import React from "react";
import "./Footer.css";
const Footer = () => {
  return (
    <footer className="footer-home">
      <section className="footer-home__section">
        <h3>ABOUT US</h3>
        <p>Who we are</p>
        <p>Quality in the details</p>
        <p>Customer Reviews</p>
      </section>
      <section className="footer-home__section">
        <h3>DEPARTMENTS</h3>
        <p>Women fashion</p>
        <p>Kidswear</p>
        <p>Home</p>
      </section>
      <section className="footer-home__section">
        <h3>HELP</h3>
        <p>Customer service</p>
        <p>Size guide</p>
        <p>Contact us</p>
      </section>
      <section className="footer-home__section">
        <h3>PAYMENTS &amp DELIVERY</h3>
        <p>Purchase terms</p>
        <p>Guarantee</p>
        <p>Contact us</p>
      </section>
      <section className="footer-home__section">
        <h3>SOCIAL</h3>
      </section>
    </footer>
  );
};

export default Footer;
