// author KJH

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({
    state: {
        token: 'token',
        test: 'test'
    },
    mutations: {},
    actions: {},
    getters: {
        getToken(state){
            return state.token;
        }
    }
})