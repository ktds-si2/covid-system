import Vue from 'vue';
import App from './App.vue';
import router from './router';

// Vuex 설정
import { store } from './store/store.js';

import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';
// vuetify 기본 icon 추가
import '@mdi/font/css/materialdesignicons.css';

// GoogleMap 설정
import * as VueGoogleMaps from 'vue2-google-maps';

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyAaHN-G7IJ96aRgJrH8P9avXTXqBLrM8-E',
    libraries: 'places',
  },
});

Vue.use(Vuetify);

Vue.config.productionTip = false;

new Vue({
  router,
  vuetify: new Vuetify(),
  render: (h) => h(App),
  // Vuex 설정
  store,
}).$mount('#app');
