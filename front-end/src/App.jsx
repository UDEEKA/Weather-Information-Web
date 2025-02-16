import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { useAuth0 } from "@auth0/auth0-react";
import LogoutButton from "./components/LogoutButton";
import 'bootstrap/dist/css/bootstrap.min.css'
import LoginPage from "./components/LoginPage";
import HomePage from "./components/HomePage";

const App = () => {
  const { isAuthenticated, user } = useAuth0();

  return (
    <Router>
      <div className="position-relative">
        {isAuthenticated && (
          <div className="position-absolute top-0 end-0 mt- me-3 p-3 bg-white shadow rounded">
            <p className="text-center fw-bold mb-2">Welcome, {user.name}</p>
            <div className="d-flex justify-content-center">
              <LogoutButton />
            </div>
          </div>
        )}

        <div className="container">
          {isAuthenticated ? <HomePage /> : <LoginPage />}
        </div>
      </div>
    </Router>
  );
};

export default App;