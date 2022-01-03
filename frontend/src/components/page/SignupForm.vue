<template>
    <v-container class="pa-8">
        <v-row class="mt-8">
        <v-col sm="2"> 
            <div class="menuTitle" > 회원가입 </div>
            <v-divider class="my-2"> </v-divider>   
        </v-col>    
    </v-row>
        <v-row class="mt-8">
            <v-col sm="3">
                <v-text-field v-model="name" label="name" > </v-text-field>
                <v-text-field v-model="email" label="email" > </v-text-field>
                <v-text-field v-model="password" label="password" type="password"> </v-text-field>
                <v-btn @click="signup"> SignUp </v-btn>
                <!-- <v-btn @click="print"> getToken </v-btn> -->
            </v-col>
        </v-row>
        
    </v-container>
</template>


<script>
import {mapActions} from 'vuex';

export default {
    name: 'SignupForm',
    data () {
        return {
            name: '',
            email: '',
            password: '',
        }
    },
    methods: {
        ...mapActions(['signupAction']),
        signup() {
            this.signupAction({
                name: this.name,
                email: this.email, 
                password:this.password
            });

            alert('회원가입 완료!');
            this.$router.push('/login');
        }
    }
}
</script>
