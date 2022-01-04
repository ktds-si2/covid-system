<!-- 장소 삭제 -->
<!-- Author: KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-8" align="center">
      <v-col sm="2">
        <div class="menuTitle" > 유저 관리 </div>
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
        <v-btn @click="deleteSelectUser"> 유저 삭제 </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import { getUserList } from "../../../service/AdminService";
import { deleteUser } from "../../../service/AdminService";


export default {
  name: "UserManagement",
  components: {},
  data: () => ({
    headers: [
      {
        text: "id ",
        align: "start",
        sortable: false,
        value: "id",
      },
      { text: "유저 이름", value: "name"},
      { text: "Email", value: "email"},
      { text: "Authority", value: "authority" },
    ],
    placeList: [],
    selected: [],
  }),
  created() {
    this.getPlace();
  },
  methods: {
    async getPlace() {
      this.placeList = await getUserList(this.$store.getters.getToken);
    },
    async deleteSelectUser() {
      for (let i = 0; i < this.selected.length; i++) {
        await deleteUser( 
          {
            id: this.selected[i].id
          },
         this.$store.getters.getToken,
        );
      }
      this.selected = [];
      this.getPlace()
      alert("유저 삭제 완료")
   },
  }
}
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}

</style>
