import axios from "axios";
import { useAuth0 } from "@auth0/auth0-react";

const REST_API_BASE_URL = 'http://localhost:8080/weather/all'

export const getWeatherData = async () => {
    const { getAccessTokenSilently } = useAuth0();
  
    try {
      const token = await getAccessTokenSilently();
      const response = await fetch(API_URL, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      });
      return response.json();
    } catch (error) {
      console.error("Error fetching weather data:", error);
    }
  };

export const listCityCodes = () => axios.get(REST_API_BASE_URL);

