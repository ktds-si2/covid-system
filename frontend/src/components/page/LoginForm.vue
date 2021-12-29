<!-- API 테스트용  Author : JHW -->
<template>
    <div>
    <b-form>
      <b-form-group
        id="input-group-1"
        label="Email address:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="email"
          type="text"
          placeholder="Enter email"
          style="width:200px"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password :" label-for="input-2">
        <b-form-input
        type="password"
          id="input-2"
          v-model="password"
          placeholder="Enter name"
          style="width:200px"
          required
        ></b-form-input>
      </b-form-group>
      <b-button type="button" @click="login()" variant="primary">Login</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
      <button @click="print()">토큰 출력</button>

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
