import { AxiosPromise } from "axios";
import { LoginForm } from "./types";
import { Result } from "@/model";
import request from "@/utils/request";

export function login(data: LoginForm): AxiosPromise<Result<string>>{
    return request({
        url:"/login",
        method:"post",
        data,
    });
}