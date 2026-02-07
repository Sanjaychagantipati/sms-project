import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../services/api";

function Login() {
    const [username , setUsername] = useState("");
    const [password , setPassword] = useState("");
    const navigate = useNavigate();

    const login = async () => {
    try {
        const response = await API.post("/api/auth/login", {
        username,
        password,
    });

    console.log("Login response:", response.data);

    localStorage.setItem("token", response.data.token);

    alert("Login Successful");

    navigate("/students"); 
  } catch (error) {
    console.error("Login failed:", error);
    alert("Login failed");
  }
};

    return (
        <div>
            <h2>login</h2>
            <input
            placeholder = "username"
            onChange={(e) => setUsername(e.target.value)} 
            />

            <br />
            <input
            type = "password"
            placeholder = "password"
            onChange={(e) => setPassword(e.target.value)}
            />
            <br />

            <button onClick = {login}>Login</button>
        </div>
    );
}

export default Login;