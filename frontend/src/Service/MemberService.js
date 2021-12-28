// Author : JHW
import request from '@/util/HttpUtil.js';

// export function
export function authenticate(params) {
  return request({
    url: '/authenticate',
    method: 'post',
    data: params,
  });
}
