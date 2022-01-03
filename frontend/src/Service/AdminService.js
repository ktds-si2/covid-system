// Author : KJH
import request from "@/util/HttpUtil.js";

// admin place 조회
export function getAdminPlace(token) {
  return request({
    url: "admin/place",
    method: "get",
    headers: {
      Authorization: "Bearer " + token,
    },
  });
}

// 새로운 place 등록
export function createNewPlace(params, token) {
  return request({
    url: "/admin/place",
    method: "post",
    data: params,
    headers: {
      Authorization: "Bearer " + token,
    },
  });
}

// place 삭제
export function deletePlace(params, token) {
  return request({
    url: "/admin/place",
    method: "delete",
    data: params,
    headers: {
      Authorization: "Bearer " + token,
    },
  });
}

// 유저 리스트 얻기
export function getUserList(token) {
  return request({
    url: "/users",
    method: 'get',
    headers: {
      Authorization: "Bearer " + token,
    },
  })
}

export function deleteUser(params, token) {
  return request({
    url: "/users",
    method: 'delete',
    data: params,
    headers: {
      Authorization: "Bearer " + token,
    },
  })
}
