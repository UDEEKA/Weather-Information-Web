import { useAuth0 } from "@auth0/auth0-react";

const LoginButton = () => {
    const { loginWithRedirect } = useAuth0();

    return (
        <div className="d-grid gap-2">
        <button className="btn btn-primary btn-lg" onClick={() =>
            loginWithRedirect()}>Log in
        </button>
        </div>
    )
};

export default LoginButton;
