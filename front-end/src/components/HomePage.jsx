import React, { useEffect, useState } from 'react'
import { listCityCodes } from '../services/WeatherService'


const HomePage = () => {

    const [city, setCity] = useState([])

    useEffect(() => {
        listCityCodes().then((response) => {
            setCity(response.data)
        }).catch(error => {
            console.error("Error fetching city data:", error);

        })
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
                            <th>City Temprature (°C)</th>
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
    )
}

export default HomePage