// Author : KJH
import request from '@/util/HttpUtil.js';

// place table의 모든 data 출력
export function getPlaceList() {
  return request({
    url: '/place',
    method: 'get',
  });
}

// place table의 데이터 검색
export function searchPlace(params) {
  return request({
    url: '/place/find',
    method: 'post',
    data: params,
  });
}

// 즐겨찾기 : Favorite 테이블의 데이터 검색
// todo: Login 구현 시, 매개변수 제거
export function getFavoriteList(token) {
  return request({
    url: '/place/favorite',
    method: 'get',
    headers: {
      Authorization: 'Bearer ' + token,
    },
  });
}

// 즐겨찾기 추가 : Favorite 테이블에 insert
export function createFavorite(token, params) {
  return request({
    url: '/place/favorite',
    method: 'post',
    data: params,
    headers: {
      Authorization: 'Bearer ' + token,
    },
  });
}

// 즐겨찾기 삭제
export function deleteFavorite(token, params) {
  return request({
    url: '/place/favorite',
    method: 'delete',
    data: params,
    headers: {
      Authorization: 'Bearer ' + token,
    },
  });
}

// 장소 상세정보 얻기   Author : JHW
export function getPlaceDetail(placeId) {
  return request({
    url: '/place/' + placeId,
    method: 'get',
  });
}
