import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import weatherIcon from "../assets/weather-icon.jpg";
import LoginButton from "./LoginButton";

const LoginPage = ({ onLogin }) => {
    return (
        <div className="d-flex justify-content-center align-items-center vh-100">
            <div className="login-container d-flex p-4 border border-5 ">
                <div className="me-4">
                    <img src={weatherIcon} alt="Weather App" className="img-fluid " style={{ width: "320px" }} />
                </div>
                <div className="text-center flex-grow-1">
                    <h2 className="fw-bold text-primary">Welcome To Weather App</h2>
                    <p>Please press 'Login' to see the weather details</p>
                    <br /><br /> <br />
                    <LoginButton />
                </div>
            </div>
        </div>
    );
};

export default LoginPage;