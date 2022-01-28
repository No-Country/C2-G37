import { Formik, Field, ErrorMessage, Form } from "formik";
import { FiX } from "react-icons/fi";
import { Link, useNavigate } from "react-router-dom";
import "./Register.css";
const validate = (values) => {
  const errors = {};
  if (!values.names) {
    errors.names = "Campo requerido";
  } else if (values.names.length > 20) {
    errors.names = "Deben ser almenos 20 caracteres";
  }

  if (!values.lastName) {
    errors.lastName = "Campo requerido";
  } else if (values.lastName.length > 20) {
    errors.lastName = "Deben ser al menos 20 caracteres";
  }

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
  if (!values.confirmPassword) {
    errors.confirmPassword = "Campo requerido";
  } else if (values.confirmPassword.length < 6) {
    errors.confirmPassword = "Debe ser de más de 5 caracteres";
  } else if (values.confirmPassword !== values.password) {
    errors.confirmPassword = "La contraseña no coincide";
  }
  if (values.telNumber.length === 0) {
    errors.telNumber = "Campo requerido";
  }
  return errors;
};

const Register = () => {
  const navigate = useNavigate();
  const handleExit = () => {
    navigate("/");
  };
  return (
    <main className="signup-container">
      <h1 className="signup-container__title">
        <FiX onClick={handleExit} className="signup-container__icon" />
        Registrarse
      </h1>

      <Formik
        initialValues={{
          email: "",
          password: "",
          confirmPassword: "",
          names: "",
          lastName: "",
          telNumber: "",
          zone: "",
        }}
        validate={validate}
        onSubmit={(values) => console.log(values)}
      >
        <Form className="form-sign" autoComplete="off">
          <label htmlFor="names">Nombre(s)</label>
          <Field
            className="form-sign__input"
            type="text"
            name="names"
            id="names"
          />
          <ErrorMessage
            className="form-sign__error"
            component="span"
            name="names"
          />

          <label htmlFor="lastName">Apellidos</label>
          <Field
            className="form-sign__input"
            type="text"
            name="lastName"
            id="lastName"
          />
          <ErrorMessage
            component="span"
            className="form-sign__error"
            name="lastName"
          />

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

          <label htmlFor="confirmPassword">Confirmar contraseña</label>
          <Field
            className="form-sign__input"
            type="password"
            name="confirmPassword"
            id="confirmPassword"
          />
          <ErrorMessage
            className="form-sign__error"
            component="span"
            name="confirmPassword"
          />

          <label htmlFor="telNumber"> Número de teléfono</label>
          <Field
            id="telNumber"
            className="form-sign__input"
            type="tel"
            name="telNumber"
          />
          <ErrorMessage
            className="form-sign__error"
            component="span"
            name="telNumber"
          />
          <label htmlFor="zone">País</label>
          <Field id="zone" name="zone" className="form-sign__input" as="select">
            <option value=""></option>
            <option value="mexico">méxico</option>
          </Field>
          <button
            className="form-sign__input form-sign__input_send"
            type="submit"
          >
            Registrarse
          </button>
          <Link className="signup-link" to="/login">
            Iniciar Sesión
          </Link>
        </Form>
      </Formik>
    </main>
  );
};

export default Register;
