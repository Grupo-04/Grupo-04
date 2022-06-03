import axios from "axios";

const api_geo_map = axios.create({
    // header : {"Access-Control-Allow-Origin": "GET"},
    baseURL : "https://maps.googleapis.com/maps/api/geocode/"
})

export default api_geo_map;
