// Author : JHW
import request from '@/util/HttpUtil.js';

// 로그인 api 요청
export function authenticate(params) {
  return request({
    url: '/authenticate',
    method: 'post',
    data: params,
  });
}

// 회원가입 api 요청
export function signupMember(params) {
  return request({
    url: '/member/signup',
    method: 'post',
    data: params,
  });
}
