import axios from "axios";

const api = axios.create({
    // header : {"Access-Control-Allow-Origin": "GET"},
    baseURL : "http://localhost:8080/"
})

export default api;
