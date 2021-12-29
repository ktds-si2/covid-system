// Author : JHW
import axios from 'axios';

// Make a axios instance
const service = axios.create({
  // Local api 요청용
  baseURL: 'http://127.0.0.1:8090/',

  timeout: 8000,
  headers: {
    'Content-Type': 'application/json',
  },
});

export default service;
