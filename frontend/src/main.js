import Vue from 'vue';
import App from './App.vue';
import router from './router';

// Vuex 설정
import { store } from './store/store.js';

import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
Vue.use(Vuetify);

Vue.config.productionTip = false;

new Vue({
  router,
  vuetify: new Vuetify(),
  render: (h) => h(App),
  // Vuex 설정
  store,
}).$mount('#app');
