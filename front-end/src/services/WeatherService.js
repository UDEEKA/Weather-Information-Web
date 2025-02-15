import axios from "axios";
import { useAuth0 } from "@auth0/auth0-react";

const REST_API_BASE_URL = "http://localhost:8080/weather/all";

export const getWeatherData = async () => {
  const { getAccessTokenSilently } = useAuth0();

  try {
    const token = await getAccessTokenSilently();
    console.log("🔑 JWT Token:", token); // ✅ Debugging: Print token in console

    const response = await axios.get(REST_API_BASE_URL, {
      headers: {
        Authorization: `Bearer ${token}`, // ✅ Ensure token is sent
      },
    });

    return response.data;
  } catch (error) {
    console.error("❌ Error fetching weather data:", error);
  }
};


export const listCityCodes = () => axios.get(REST_API_BASE_URL);

