import axios from 'axios'

const service = axios.create({
    baseURL: 'http://h5.library.frp.ijjk.top:28091',
    timeout: 6000
  })
   
  service.interceptors.request.use(
    (config) => {
      return config
    },
    (error) => {
      return Promise.reject(error)
    }
  )
   
  // 设置响应拦截器
  service.interceptors.response.use(
    // 响应成功
    (response) => {
      return response.data
    },
    // 响应失败
    (error) => {
      return Promise.reject(error)
    }
  )
   
  export default service