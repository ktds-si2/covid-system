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
import { authenticate } from '@/Service/MemberService';

export default {
    name:"LoginTest",
    data() {
        return {
            tokenDto: 'token',
            email : '',
            password : '',
            tokenValue: ''
        }
    },
    methods: {
        async login () {
            this.tokenDto = (await authenticate({
                "email":this.email,
                "password":this.password
            })).data.token;

            this.email = '';
            this.password = '';          
            this.$store.state.token = this.tokenDto;     
        },
        print() {
            alert(this.tokenDto);
        }
    }
}
</script>
