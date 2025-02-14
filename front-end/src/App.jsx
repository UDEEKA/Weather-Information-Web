import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { useAuth0 } from "@auth0/auth0-react";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";
import 'bootstrap/dist/css/bootstrap.min.css'
import HomePage from "./components/HomePage";

const App = () => {
  const { isAuthenticated, user } = useAuth0();

  return (
    <Router>
      <div className="container">
        <h1 className="text-center mb-2">Weather App</h1>
        {isAuthenticated ? (
          <>
            <div className="d-flex justify-content-end align-items-center mb-2">
              <p className="text-center font-weight-bold font-italic mb-2">Welcome, {user.name}</p>
            </div>

            <HomePage />
            <div className="d-flex justify-content-center align-items-center">
              <LogoutButton />
            </div>
          </>
        ) : (
          <div className="d-flex justify-content-center align-items-center">

            <LoginButton />
          </div>

        )}
      </div>
    </Router>
  );
};

export default App;
