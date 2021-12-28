<!-- API 테스트용  Author : JHW -->
<template>
    <div>
        <button @click="login()">Login</button>
        <button @click="print()">print</button>
    </div>
</template>

<script>
import { authenticate } from '@/Service/MemberService';

export default {
    name:"LoginTest",
    data() {
        return {
            tokenDto: 'token'
        }
    },
    methods: {
        async login() {
            this.tokenDto = (await authenticate({"email":"user","password":"user"})).data;
        },
        print() {
            console.log(this.tokenDto);
        }
    }
}
</script>
