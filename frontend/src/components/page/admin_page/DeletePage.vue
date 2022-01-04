<!-- 장소 삭제 -->
<!-- Author: KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-8" align="center">
      <v-col sm="2">
        <div class="menuTitle" > 장소 삭제 </div>
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
        >
        </v-data-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-btn @click="deleteSelectPlace"> 장소 삭제 </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import { getAdminPlace } from "../../../service/AdminService";
import { deletePlace } from '../../../service/AdminService'

export default {
  name: "DeletePage",
  components: {},
  data: () => ({
    headers: [
      {
        text: "id",
        align: "start",
        sortable: false,
        value: "id",
      },
      { text: "장소종류", value: "placeType"},
      { text: "장소이름", value: "placeName" },
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
      this.placeList = await getAdminPlace(this.$store.getters.getToken);
    },
    async deleteSelectPlace() {
      for (let i = 0; i < this.selected.length; i++) {
        await deletePlace( 
          {
          place_id: this.selected[i].id
          },
         this.$store.getters.getToken,
        );
      }
      this.selected = [];
      this.getPlace()
      alert("장소 삭제 완료")
   },
  }
}
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}

</style>
