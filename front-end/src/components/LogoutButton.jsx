import { useAuth0 } from "@auth0/auth0-react";

const LogoutButton = () => {
    const { logout } = useAuth0();

    return (
    <div>
    <button className="btn btn-primary btn-lg" onClick={() =>
        logout({ returnTo: window.location.origin })}>Log out
    </button>
    </div>
    )

};

export default LogoutButton;
