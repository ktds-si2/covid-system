<!-- API 테스트용  Author : JHW -->
<template>
    <div>
        <form>
            ID : <input type="text" v-model="email"/>
            Password : <input type="password" v-model="password" />
            <button type="button" @click="login()" >Login</button>
        </form>
        <button @click="print()">토큰 출력</button>
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
            password : ''
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
            alert(this.tokenDto);
        },
        print() {
            alert(this.tokenDto);
        }
    }
}
</script>
