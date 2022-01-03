<!-- 즐겨찾기 -->
<!-- Author: KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-8" align="center">
      <v-col sm="2">
        <div class="menuTitle" > 즐겨찾기 </div>
        <v-divider class="my-2"> </v-divider>   
      </v-col>
    </v-row>
    <v-row class="mt-8">
      <v-col>
        <v-data-table
          v-model="selected"
          show-select
          :headers="headers"
          :items="placeList.data"
          :items-per-page="5"
          dark
        >
        </v-data-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="right">
        <v-btn color="#f1ed01" @click="deleteFavorite"> 즐겨찾기 삭제</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import { getFavoriteList } from "../../Service/PlaceService";
import { deleteFavorite } from "../../Service/PlaceService";

export default {
  name: "Favorite",
  components: {},
  data: () => ({
    headers: [
      {
        text: "장소 이름",
        align: "start",
        sortable: false,
        value: "placeName",
      },
      { text: "주소", value: "address" },
      { text: "전화 번호", value: "phoneNumber" },
      { text: "현재 인원", value: "currentNumberOfPeople" },
      { text: "최대 인원", value: "capacity" },
    ],
    placeList: [],
    selected: [],
  }),
  created() {
    this.getPlace();
  },
  methods: {
    async getPlace() {
      this.placeList = await getFavoriteList(this.$store.getters.getToken);
    },
    async deleteFavorite() {
      for (let i = 0; i < this.selected.length; i++) {
        console.log(this.selected)
        await deleteFavorite(
          
          this.$store.getters.getToken, 
          {
          id: this.selected[i].id,
        }
        );
      }
      alert("즐겨찾기가 삭제되었습니다");
      this.selected = [];
      this.getPlace();
   },
  }
}
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}

</style>
