import axios from 'axios'

const api = axios.create({baseURL:'http://localhost:8080//v1.0/telephony-plan-calculator'});

export default api;