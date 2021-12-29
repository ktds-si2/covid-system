// author KJH

import Vue from 'vue';
import Vuex from 'vuex';
import { authenticate } from '@/Service/MemberService';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state: {
    token: 'token',
    test: 'test',
    isLogin: false,
  },
  mutations: {
    setToken(state, tokenValue) {
      // 토큰값 Setting(로그인)     Author : JHW
      state.token = tokenValue;
      state.isLogin = true;
    },

    setTokenEmpty(state) {
      // 토큰값 비우기(로그아웃)    Author : JHW
      state.token = '';
      state.isLogin = false;
    },
  },
  actions: {
    async loginToken({ commit }, loginRequest) {
      // api 서버에 토큰값 요청       Author : JHW

      let tokenDto = await authenticate({
        email: loginRequest.email,
        password: loginRequest.password,
      });

      commit('setToken', tokenDto.data.token);
    },
  },
  getters: {
    getToken(state) {
      return state.token;
    },
  },
});
