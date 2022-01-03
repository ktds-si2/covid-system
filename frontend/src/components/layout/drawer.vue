<!-- author: KJH -->
<template>
  <v-navigation-drawer 
  id="drawer"
  dark width="260" 
  app>
    <v-list dense nav>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="firstlist" v-text="'kt ds'" />
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-divider class="mb-2" />  <!-- 메뉴바 변경(로그인, 권한)    Author : JHW  -->
    <v-list expand nav>
      <v-list-item @click="moveHome()" link>
        <v-list-item-icon>
          <v-icon> mdi-home-outline </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> Home </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      <v-list-item @click="moveFavorite()" link>
        <v-list-item-icon>
          <v-icon> mdi-star-outline </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> Favorite </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item @click="moveLogin()" link>
        <v-list-item-icon>
          <v-icon> {{isLogin? 'mdi-account-outline' : 'mdi-login'}} </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> {{isLogin? 'MyPage' : 'Login'}} </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item @click="moveAdmin()" v-if="userAuthority == 'ROLE_ADMIN'" link>
        <v-list-item-icon>
          <v-icon> mdi-shield-account-outline </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> Admin </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

    <v-list-item @click="moveMap()" link>
        <v-list-item-icon>
          <v-icon> mdi-shield-account-outline </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> Map </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import {mapState} from 'vuex';

export default {
  name: "drawer",
  computed: { 
    ...mapState(['isLogin','userAuthority'])     // 로그인, 유저권한 확인   Author : JHW
  },
  data: () => ({
    drawer: null,
    
  }),
  methods: {  // 라우터 이동 함수   Author : JHW
    moveMap() {
      this.$router.push('/map');
    },
    moveHome() {
      this.$router.push('/');
    },
    moveFavorite() {
      this.$router.push('/favorite');
    },
    moveLogin() {
      if(!this.isLogin)
        this.$router.push('/login')
      else
        this.$router.push('/');
    },
    moveAdmin() {
      this.$router.push('/admin');
    }
  }
};
</script>
<style scoped>
.firstlist {
  font-size: 20px !important;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.drawer {
  padding: 8px !important
}
</style>
