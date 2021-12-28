import request from "@/util/HttpUtil.js"

export function getPlaceList(param) {
    return request({
        url: "/place",
        method: "get",
        params: param
    })
}