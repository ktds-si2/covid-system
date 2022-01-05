<!-- 정책 변경  Author : KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-8">
      <v-col sm="2">
        <div class="menuTitle">정책 변경</div>
        <v-divider class="my-2"> </v-divider>
      </v-col>
    </v-row>
    <v-row class="mt-8">
      <v-col sm="3">
        <v-select :items="items" label="placeType" v-model="selectedPlaceType"></v-select>
      </v-col>
      <v-col sm="3">
        <v-text-field v-model="limitTime" label="제한 시간"> </v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-btn @click="change"> 변경 </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { changePolicy } from "../../../service/PlaceService";

export default {
  name: "UpdatePolicy",
  computed: {
    getToken() {
      return this.$store.getters.getToken;
    },
  },
  data() {
    return {
      items: ["COMMON", "SPORTS", "RESTAURANT", "PARTY"],
      limitTime: "",
      selectedPlaceType: '',
    };
  },
  methods: {
      async change() {
          await changePolicy({
            "placeType": this.selectedPlaceType,
            "limitTime": this.limitTime
          })

          this.selectedPlaceType = ''
          this.limitTime = ''
          alert("정책이 변경되었습니다")
          this.$router.push('/');
      }
      
  },
};
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}
</style>
