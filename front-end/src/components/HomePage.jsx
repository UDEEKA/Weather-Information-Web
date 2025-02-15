// import React, { useEffect, useState } from 'react';
// import { useAuth0 } from "@auth0/auth0-react";
// import { listCityCodes } from '../services/WeatherService';

// const HomePage = () => {
//     const { getAccessTokenSilently } = useAuth0();
//     const [city, setCity] = useState([]);

//     useEffect(() => {
//         // Fetch JWT Token for Debugging
//         const fetchToken = async () => {
//             try {
//                 const token = await getAccessTokenSilently();
//                 console.log("🔑 JWT Token:", token); // ✅ Print token to console
//             } catch (error) {
//                 console.error("❌ Error fetching token:", error);
//             }
//         };

//         fetchToken();
//     }, [getAccessTokenSilently]);

//     useEffect(() => {
//         listCityCodes().then((response) => {
//             setCity(response.data);
//         }).catch(error => {
//             console.error("Error fetching city data:", error);
//         });
//     }, []);

//     return (
//         <div className='container mt-5'>
//             <h2 className='text-center fw-bold mb-4 fs-1'>WEATHER INFORMATION</h2>
            
//             <div className="table-responsive">
//                 <table className='table table-striped table-bordered table-hover fs-4'>
//                     <thead>
//                         <tr className='text-center'>
//                             <th>City Code</th>
//                             <th>City Name</th>
//                             <th>City Temperature (°C)</th>
//                             <th>Weather Description</th>
//                         </tr>
//                     </thead>
//                     <tbody>
//                         {
//                             city.map((city, index) =>
//                                 <tr key={index}>
//                                     <td>{city.cityCode || city.CityCode}</td>
//                                     <td>{city.cityName || city.CityName}</td>
//                                     <td>{city.temperature || city.Temp}</td>
//                                     <td>{city.weatherCondition || city.Status}</td>
//                                 </tr>
//                             )}
//                     </tbody>
//                 </table>
//             </div>
//         </div>
//     );
// };

// export default HomePage;

import React, { useEffect, useState } from "react";
import { useAuth0 } from "@auth0/auth0-react";
import { getWeatherData, listCityCodes } from "../services/WeatherService";

const HomePage = () => {
    const { getAccessTokenSilently, isAuthenticated } = useAuth0();
    const [city, setCity] = useState([]);

    useEffect(() => {
        const fetchToken = async () => {
            if (!isAuthenticated) {
                console.warn("User is not authenticated.");
                return;
            }

            try {
                const token = await getAccessTokenSilently();
                console.log("🔑 JWT Token:", token);
            } catch (error) {
                console.error("❌ Error fetching token:", error);
            }
        };

        fetchToken();
    }, [getAccessTokenSilently, isAuthenticated]);

    useEffect(() => {
        listCityCodes().then((response) => {
            setCity(response.data);
        }).catch(error => {
            console.error("Error fetching city data:", error);
        });
    }, []);

    return (

        <div className='container mt-5'>

            <h2 className='text-center fw-bold mb-4 fs-1'>WEATHER INFORMATION</h2>

            <div className="table-responsive">
                <table className='table table-striped table-bordered table-hover fs-4'>
                    <thead>
                        <tr className='text-center'>
                            <th>City Code</th>
                            <th>City Name</th>
                            <th>City Temperature (°C)</th>
                            <th>Weather Description</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            city.map((city, index) =>
                                <tr key={index}>
                                    <td>{city.cityCode || city.CityCode}</td>
                                    <td>{city.cityName || city.CityName}</td>
                                    <td>{city.temperature || city.Temp}</td>
                                    <td>{city.weatherCondition || city.Status}</td>
                                </tr>
                            )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default HomePage;
