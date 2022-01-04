<!-- 장소 등록 Author : KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-8">
        <v-col sm="2">
            <div class="menuTitle"> 관리자 메뉴 </div>
            <v-divider class="my-2"> </v-divider>   
        </v-col>  
    </v-row>
    <v-row class="mt-8">
      <v-col sm="3">
        <v-text height="40" @click="moveToCreatePage"> <div class="menuList"> 장소 등록 </div> </v-text>
      </v-col>
    </v-row>
    <v-row class="mt-8"> 
      <v-col sm="3">
        <v-text height="40" @click="moveToDeletePage"> <div class="menuList"> 장소 삭제 </div> </v-text>
      </v-col>
    </v-row>
    <v-row class="mt-8"> 
      <v-col sm="3">
        <v-text height="40" @click="moveToUsermanagementPage"> <div class="menuList"> 유저 관리 </div> </v-text>
      </v-col>
    </v-row>
    <v-row class="mt-8"> 
      <v-col sm="3">
        <v-text height="40" @click="moveToUpdatePolicyPage"> <div class="menuList"> 정책 변경 </div> </v-text>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>

export default {

  name: "Admin",
  components:
  {

  },
  computed: {
    getToken() {
      return this.$store.getters.getToken;
    },
  },
  data() {
    return {

    };
  },
  methods: {
   moveToCreatePage () {
       this.$router.push('/admin/createPage')
   },
   moveToDeletePage () {
       this.$router.push('/admin/deletePage')
   },
   moveToUsermanagementPage() {
      this.$router.push('/admin/userManagement')
   },
   moveToUpdatePolicyPage() {
     this.$router.push('/admin/updatePolicy')
   }
  },
};
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}
.menuList {
    text-decoration: underline;
    text-underline-position: under;
    text-decoration-color: gray;
}
</style>