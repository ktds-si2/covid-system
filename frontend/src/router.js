import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Main',
            component: () => import('./components/page/LoginForm.vue')
        },
        {
            path: '/pagetest',
            name: 'PageTest',
            component: () => import('./components/page/PageTest.vue')
        },
        {
            path: '/login',
            name: 'LoginTest',
            component: () => import('./components/page/LoginForm.vue')
        }
    ]
});

export default router;