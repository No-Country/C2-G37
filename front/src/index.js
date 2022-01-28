import React, { Suspense } from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { Provider } from "react-redux";
import store from "./app/store";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NotFound from "./components/NotFound";
import Cart from "./pages/Cart/Cart";
import Favorites from "./pages/Favorites/Favorites";
import Profile from "./pages/Profile/Profile";
import Login from "./pages/SignUp/Login";
import Register from "./pages/SignUp/Register";
import RequireAuth from "./routes/RequireAuth";
import Loader from "./components/Loader";
import NoRequireAuth from "./routes/NoRequireAuth";
const HomeLazy = React.lazy(() => import("./pages/Home/Home"));
ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <Router>
        <Routes>
          <Route path="/" element={<App />}>
            <Route
              index
              element={
                <Suspense fallback={<Loader />}>
                  <HomeLazy />
                </Suspense>
              }
            />
            <Route
              path="/favorites"
              element={
                <RequireAuth>
                  <Favorites />
                </RequireAuth>
              }
            />
            <Route
              path="/user"
              element={
                <RequireAuth>
                  <Profile />
                </RequireAuth>
              }
            />
            <Route
              path="/cart"
              element={
                <RequireAuth>
                  <Cart />
                </RequireAuth>
              }
            />
            <Route path="*" element={<NotFound />} />
          </Route>

          <Route
            path="/login"
            element={
              <NoRequireAuth>
                <Login />
              </NoRequireAuth>
            }
          />
          <Route
            path="/register"
            element={
              <NoRequireAuth>
                <Register />
              </NoRequireAuth>
            }
          />
        </Routes>
      </Router>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
