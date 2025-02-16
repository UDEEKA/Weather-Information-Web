# Weather App

## **Objective**
Develop a secure web/API application that retrieves and displays weather information, integrating authentication and authorization mechanisms.

## **Technologies Used**
- **Frontend:** React + Vite + Bootstrap 5
- **Backend:** Spring Boot
- **Authentication:** Auth0
- **API Services:** OpenWeather API
- **Version Control:** GitHub

## **Features**
1. Reads city codes from a JSON file.
2. Fetches weather data using OpenWeatherMap APIs.
3. Displays the weather information with a user-friendly UI.
4. Implements data caching (5-minute expiration).
5. Secure the application using Auth0 for authentication and authorization.
    - Users must log in to access the weather data.
    - Enable Multi-Factor Authentication (MFA) via email verification.
    - Disable public user signups.
    - Only pre-registered users in the Auth0 backend should have access.
6. **Test User Account:**
    - Email: `careers@fidenz.com`
    - Password: `Pass#fidenz`

## **Setup Instructions**
### **1️⃣ Clone the repository**
```bash
git clone https://github.com/UDEEKA/Weather-Information-Web.git
```

### **2️⃣ Backend Setup** (Spring Boot)
```bash
cd backend
mvn spring-boot:run
```
- The backend runs on **port 8080** by default.
- Ensure you have Java and Maven installed.

### **3️⃣ Frontend Setup** (React + Vite)
```bash
cd frontend
npm install
npm run dev
```
- The frontend runs on **port 5173** by default.

### **4️⃣ Environment Variables (.env)**
Create a **.env** file in the `frontend` directory and add:
```env
VITE_AUTH0_DOMAIN=YOUR_AUTH0_DOMAIN
VITE_AUTH0_CLIENT_ID=YOUR_AUTH0_CLIENT_ID
VITE_AUTH0_AUDIENCE=https://weather-app.com
```

## **Backend Configuration (`application.properties`)**
```properties
spring.application.name=weather-app-backend
server.port=8080
spring.main.allow-bean-definition-overriding=true
openweathermap.api.key=YOUR_OPEN_WEATHER_API_KEY
logging.level.org.springframework.web=DEBUG
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://YOUR_AUTH0_DOMAIN/
spring.security.oauth2.resourceserver.jwt.audience=https://weather-app.com
```

## **API Endpoints**
### **🔹 Get Weather Data**
```http
GET /weather/all
```
- Returns a list of weather details for all cities.
- Requires an **Auth0 Bearer Token** in the headers.

## **City Codes (Stored in `cities.json`)**
Example:
```json
{
  "List": [
    { "CityCode": "1248991", "CityName": "Colombo", "Temp": "33.0", "Status": "Clouds" },
    { "CityCode": "1850147", "CityName": "Tokyo", "Temp": "8.6", "Status": "Clear" },
    { "CityCode": "2644210", "CityName": "Liverpool", "Temp": "16.5", "Status": "Rain" }
  ]
}
```

## **Authentication & Authorization**
- Auth0 is integrated for login/logout.
- Users must authenticate before accessing weather data.
- **MFA Enabled:** Users must verify via email.
