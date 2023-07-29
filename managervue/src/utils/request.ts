import axios ,{AxiosError, AxiosResponse} from "axios";
import { ElMessage, ElNotification } from "element-plus";

const requests = axios.create({
    baseURL: "/api",
    timeout: 10000,
    headers:{
        "Content-Type": "application/json;charset=UTF-8"
    }
})




requests.interceptors.response.use(
    (response: AxiosResponse) => {
      switch (response.data.code) {
        case 400:
            ElNotification({
              title: "失败",
              message: response.data.msg,
              type: "error",
            });
            break;
      }
      return response;
    },
    (error: AxiosError) => {
      let { message } = error;
      if (message == "Network Error") {
        message = "后端接口连接异常";
      } else if (message.includes("timeout")) {
        message = "系统接口请求超时";
      } else if (message.includes("Request failed with status code")) {
        message = "系统接口" + message.substring(message.length - 3) + "异常";
      }
      ElMessage({
        message: message,
        type: "error",
        duration: 5 * 1000,
      });
      return Promise.reject(error);
    }
  );

export default requests