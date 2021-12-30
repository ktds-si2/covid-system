<!-- API 테스트용  Author : JHW -->
<template>
    <div>
      로그인 폼
      <button @click="print()">토큰 출력</button>
      <v-btn elevation="19" @click="print()">로그인</v-btn>
  </div>
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
        },
        signup() {
          signupMember({
            'email' : this.email,
            'password' : this.password
          })
        },
        print() {
            alert(this.getToken);
        }
    }
}
</script>
