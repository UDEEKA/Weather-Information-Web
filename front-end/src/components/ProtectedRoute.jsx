import { useAuth0 } from "@auth0/auth0-react";
import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ children }) => {
  const { isAuthenticated, user } = useAuth0();

  // Redirect if not authenticated
  return isAuthenticated ? children : <Navigate to="/" />;
};

export default ProtectedRoute;
