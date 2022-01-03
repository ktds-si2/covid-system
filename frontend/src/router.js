import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      component: () => import('./components/page/Main.vue'),
    },
    {
      path: '/login',
      name: 'LoginTest',
      component: () => import('./components/page/LoginForm.vue'),
    },
    {
      path: '/favorite',
      name: 'Favorite',
      component: () => import('./components/page/Favorite.vue'),
    },
    {
      path: '/admin',
      name: 'Admin',
      component: () => import('./components/page/Admin.vue'),
    },
    {
      path: '/signup',
      name: 'Signup',
      component: () => import('./components/page/SignupForm.vue'),
    },
    {
      path: '/map',
      anme: 'GoogleMap',
      component: () => import('./components/page/Map.vue'),
    },
    {
      path: '/admin/createPage',
      name: 'CreatePage',
      component: () => import('./components/page/admin_page/CreatePage'),
    },
    {
      path: '/admin/deletePage',
      name: 'DeletePage',
      component: () => import('./components/page/admin_page/DeletePage'),
    },
  ],
});

export default router;
