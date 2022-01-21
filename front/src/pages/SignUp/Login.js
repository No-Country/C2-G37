import { Formik, Field, ErrorMessage, Form } from "formik";
import { IoIosArrowBack } from "react-icons/io";
import "./Register.css";
const validate = (values) => {
  const errors = {};

  if (!values.email) {
    errors.email = "Campo requerido";
  } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
    errors.email = "Dirección de correo inválido";
  }

  if (!values.password) {
    errors.password = "Campo requerido";
  } else if (values.password.length < 6) {
    errors.password = "Debe ser de mas de 5 caracteres";
  }

  return errors;
};
const Login = () => {
  return (
    <main className="signup-container">
      <h1 className="signup-container__title">
        <IoIosArrowBack className="signup-container__icon" />
        Iniciar Sesión
      </h1>

      <Formik
        initialValues={{
          email: "",
          password: "",
          confirmPassword: "",
          names: "",
          lastName: "",
          telNumber: "",
        }}
        validate={validate}
        onSubmit={(values) => console.log(values)}
      >
        <Form className="form-sign" autoComplete="off">
          <label htmlFor="email">Correo</label>
          <Field
            className="form-sign__input"
            type="email"
            name="email"
            id="email"
          />
          <ErrorMessage
            className="form-sign__error"
            component="span"
            name="email"
          />

          <label htmlFor="password">Contraseña</label>
          <Field
            className="form-sign__input"
            type="password"
            name="password"
            id="password"
          />
          <ErrorMessage
            className="form-sign__error"
            component="span"
            name="password"
          />

          <button
            className="form-sign__input form-sign__input_send"
            type="submit"
          >
            Iniciar Sesión
          </button>
        </Form>
      </Formik>
    </main>
  );
};

export default Login;
