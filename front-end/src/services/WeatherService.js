import axios from "axios";
import { useAuth0 } from "@auth0/auth0-react";
import { useEffect, useState } from "react";

const REST_API_BASE_URL = "http://localhost:8080/weather/all";

export const getWeatherData = () => {
    const { getAccessTokenSilently, isAuthenticated } = useAuth0();
    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            if (!isAuthenticated) {
                console.warn("User is not authenticated.");
                return;
            }

            try {
                const token = await getAccessTokenSilently();
                console.log("🔑 JWT Token:", token); // ✅ Debugging: Ensure token exists

                const response = await axios.get(REST_API_BASE_URL, {
                    headers: {
                        Authorization: `Bearer ${token}`, // ✅ Ensure token is sent
                        "Content-Type": "application/json",
                    },
                });

                setData(response.data);
            } catch (err) {
                console.error("❌ Error fetching weather data:", err);
                setError(err);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, [getAccessTokenSilently, isAuthenticated]);

    return { data, loading, error };
};



export const listCityCodes = () => axios.get(REST_API_BASE_URL);

