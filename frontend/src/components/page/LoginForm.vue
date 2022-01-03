<!-- API 테스트용  Author : JHW -->
<template>
    <v-container class="pa-8">
        <v-row class="mt-8">
        <v-col sm="2"> 
            <div class="menuTitle" > 로그인 </div>
            <v-divider class="my-2"> </v-divider>   
        </v-col>    
    </v-row>
        <v-row class="mt-8">
            <v-col sm="3">
                <v-text-field v-model="email" label="email" > </v-text-field>
                <v-text-field v-model="password" label="password" type="password"> </v-text-field>
                <v-btn @click="login"> Login </v-btn>
                <!-- <v-btn @click="print"> getToken </v-btn> -->
            </v-col>
        </v-row>
        
    </v-container>
    
</template>

<script>
import {mapActions} from 'vuex';
import {signupMember} from '../../Service/MemberService';


export default {
    name:"LoginTest",
    computed: {
        getToken() {
            return this.$store.getters.getToken
        }
    },
    data() {
        return {
            tokenDto: 'token',
            email : '',
            password : '',
            tokenValue: ''
        }
    },
    methods: {
        ...mapActions(['loginToken'])
        ,
        login() {
            this.loginToken({
                'email' : this.email,
                'password' : this.password
            })
            this.email = '';
            this.password = '';
            alert('로그인 되었습니다. ')
        },
        signup() {
          signupMember({
            'email' : this.email,
            'password' : this.password
          })
        },
        print() {
            alert('Bearer ' + this.getToken);
        }
    }
}
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}

</style>