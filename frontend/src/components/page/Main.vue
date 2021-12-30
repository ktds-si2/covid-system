<!-- Author : JHW -->
<template>
    <div>
        <router-link to="/pagetest"> PageTest </router-link> |
        <router-link to="/login"> Login </router-link>
        <router-link to="/vuetify">뷰티파이</router-link>
        <router-view/>
        <br>
        <!-- {{this.data}} page -->
        <!-- <login-form /> -->
        
    
    </div>
</template>

// <script>
// import LoginForm from './LoginForm.vue'

//     export default {
//         components: { LoginForm },
//         name:'Main',
//         data() {
//             return {
//                 data : 'Main',
//             }
//         }        
//     }
// </script>