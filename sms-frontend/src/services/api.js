import axios from "axios";

const API = axios.create({
    baseURL:"http://localhost:8088",
});


API.interceptors.request.use((req) => {
    const token = localStorage.getItem("token");
    if(token && !req.url.includes("/auth/login")){
        req.headers.Authorization = `Bearer ${token}`;
    }

    return req;
});

export default API;