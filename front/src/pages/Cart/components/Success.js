import React, { useEffect } from "react";

const Success = ({ text, setIsPaymentSuccess }) => {
  useEffect(() => {
    setTimeout(() => {
      setIsPaymentSuccess(false);
    }, 5000);
    return () => {};
  }, [setIsPaymentSuccess]);
  return <div className="payment-success">{text}</div>;
};

export default Success;
