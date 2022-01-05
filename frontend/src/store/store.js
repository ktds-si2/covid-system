// author KJH

import Vue from 'vue';
import Vuex from 'vuex';
import { authenticate, signupMember } from '@/service/MemberService';
import { getPlaceDetail } from '@/service/PlaceService';
import { getCoronaCntOfEachCity } from '@/service/CoronaService';

import router from '../router';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    token: 'token',
    test: 'test',
    isLogin: false, // 로그인 확인 여부
    userAuthority: 'userAuthority', // 접속한 유저 권한
    userName: 'userName', // 접속한 유저 이름
    placeDetail: {}, // Place 상세페이지 데이터
    CoronaCntOfEachCity: {}, // 각 도시별 코로나 수
  },
  mutations: {
    setToken(state, loginResponse) {
      // 토큰값, 권한 Setting(로그인)     Author : JHW
      state.token = loginResponse.token;
      state.userAuthority = loginResponse.authority;
      state.userName = loginResponse.memberName;
      state.isLogin = true;

      router.push('/');
    },

    setTokenEmpty(state) {
      // 토큰값, 권한 비우기(로그아웃)    Author : JHW
      state.token = '';
      state.userAuthority = '';
      state.userName = '';
      state.isLogin = false;
    },
    setPlaceDetail(state, placeDto) {
      // place 상세정보 Setting   Author : JHW

      state.placeDetail = placeDto;
    },

    setCoronaCntOfEachCity(state, CoronaCntOfEachCity) {
      // 지역별 코로나 확진자 수 Setting    Author : JHW
      state.CoronaCntOfEachCity = CoronaCntOfEachCity;
      console.log(state.CoronaCntOfEachCity);
    },
  },
  actions: {
    async loginToken({ commit }, loginRequest) {
      // api 서버에 토큰값 요청       Author : JHW

      let loginResponse = await authenticate({
        email: loginRequest.email,
        password: loginRequest.password,
      });

      commit('setToken', loginResponse.data);
    },

    async signupAction({ commit }, singupRequest) {
      // api 서버에 회원가입 요청     Author : JHW

      await signupMember({
        name: singupRequest.name,
        email: singupRequest.email,
        password: singupRequest.password,
      });

      commit('setTokenEmpty');
    },

    async getPlaceDetail({ commit }, placeId) {
      // api 서버에 장소 디테일정보 요청 및 Setting   Author : JHW
      let placeResponse = await getPlaceDetail(placeId);

      commit('setPlaceDetail', placeResponse.data);
    },

    async setCoronaCntOfEachCity({ commit }) {
      // 도시별 코로나 현황 요청    Author : JHW
      getCoronaCntOfEachCity().then((result) => {
        let tmp = result.data;

        let CoronaCntOfEachCity = {
          busan: tmp.busan,
          daegu: tmp.daegu,
          gwangju: tmp.gwangju,
          gyeonggi: tmp.gyeonggi,
          seoul: tmp.seoul,
          daejeon: tmp.daejeon,
          korea: tmp.korea,
        };

        commit('setCoronaCntOfEachCity', CoronaCntOfEachCity);
      });
    },
  },
  getters: {
    getToken(state) {
      return state.token;
    },
  },
});
