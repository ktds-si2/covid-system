// author KJH

import Vue from 'vue';
import Vuex from 'vuex';
import { authenticate, signupMember } from '@/Service/MemberService';
import router from '../router';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    token: 'token',
    test: 'test',
    isLogin: false, // 로그인 확인 여부
    userAuthority: 'userAuthority', // 접속한 유저 권한
    userName: 'userName', // 접속한 유저 이름
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
  },
  getters: {
    getToken(state) {
      return state.token;
    },
  },
});
