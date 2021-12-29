<!-- API 테스트용  Author : JHW -->
<template>
    <div>
        <form>
            ID : <input type="text" v-model="email"/>
            Password : <input type="password" v-model="password" />
            <button type="button" @click="login()" >Login</button>
        </form>
        <button @click="print()">토큰 출력</button>
        <p><br>{{tokenValue}}</p>
    </div>
</template>

<script>
import {mapActions} from 'vuex';

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
        
        print() {
            alert(this.getToken);
        }
    }
}
</script>
