// Author : KJH
import request from '@/util/HttpUtil.js';

// export function
export function getPlaceList() {
  return request({
    url: '/place',
    method: 'get'
  });
}
