<!-- Author : JHW -->
<template>
  <v-app-bar color="white" flat app>
    <v-container class="py-6 fill-height">
      <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>
      <v-btn v-if="!isLogin" @click="signup()" text>
        SIGNUP
      </v-btn>
      <v-btn v-if="isLogin" @click="logout()" text>
        LOGOUT
      </v-btn>
      <v-spacer></v-spacer>

      <v-responsive max-width="260">
        <v-text-field
          dense
          flat
          hide-details
          rounded
          solo-inverted
          v-model="data"
          v-on:keyup.enter="input"
        ></v-text-field>
      </v-responsive>
    </v-container>
  </v-app-bar>
</template>

<script>
import {mapMutations, mapState} from 'vuex';

export default {
  name: "appbar",
  computed : {
    ...mapState(['isLogin'])
  },
  data() {
    return {
      data: '',
      items : [
        {title: "signup", method: "this.moveSignup()"},
        {title: "logout", method: "this.logout()"}
      ]
      
    };
  },
  methods: {
    ...mapMutations(['setTokenEmpty'])
    ,input() {
      // this.$store.dispatch()
    },
    logout() {
      this.setTokenEmpty();
      alert("로그아웃되었습니다.")
      this.$router.push('/login');
    },
    signup() {
      this.$router.push('/signup');
    }
  }
};
</script>
