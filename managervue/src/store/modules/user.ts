import { login } from "@/api/login";
import { LoginForm } from "@/api/login/types";
import { defineStore } from "pinia";
import { UserState } from "../interface";

const useUserStore = defineStore("useUserStore", {
    state: (): UserState => ({
      id: null,
      avatar: "",
      roleList: [],
      permissionList: [],
    }),
    actions: {
      Login(LoginForm: LoginForm) {
        return new Promise((resolve, reject) => {
          login(LoginForm)
            .then(({ data }) => {
              if (data.flag) {
                
                resolve(data);
              } else {
                reject(data.msg);
              }
            })
            .catch((error) => {
              reject(error);
            });
        });
      },
      
    },
    getters: {},
  });

export default useUserStore;