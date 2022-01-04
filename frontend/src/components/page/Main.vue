<!-- Author : JHW -->
<template>
  <v-container class="pa-8">
    <!-- 검색 추가 -->
    <v-row class="mt-8" align="center">
      <v-col sm="2">
        <div class="menuTitle"> 모든 장소 조회 </div>
        <v-divider class="my-2"> </v-divider>   
      </v-col>
      <v-col offset="7" align="right" sm="3">
        <v-text-field
          label="Search"
          hint="종류, 이름, 주소, 번호, 현재인원, 최대인원"
          v-model="SearchText"
          v-on:keyup.enter="searching"
        >
        </v-text-field>
      </v-col>
    </v-row>
    <v-row class="mt-6">
      <v-col>
        <v-data-table
          v-model="selected"
          show-select
          value="selectedRows"
          :headers="headers"
          :items="placeList.data"
          :items-per-page="5"
          @click:row="detailClick"
          dark
        >
        </v-data-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col align="right">
        <v-btn color="#f1ed01" @click="addFavorite"> 즐겨찾기 등록</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { getPlaceList } from "../../service/PlaceService";
import { searchPlace } from "../../service/PlaceService";
import { createFavorite } from "../../service/PlaceService";
import {mapMutations} from 'vuex';

export default {
  name: "Main",
  components: {},
  
  data: () => ({
    headers: [
      {
        text: "장소 종류",
        align: "start",
        sortable: false,
        value: "placeType",
      },
      { text: "장소이름", value: "placeName" },
      { text: "주소", value: "address" },
      { text: "전화 번호", value: "phoneNumber" },
      { text: "현재 인원", value: "currentNumberOfPeople" },
      { text: "최대 인원", value: "capacity" },
      { text: "제한 시간", value: "limitTime"}
    ],
    placeList: [],
    selected: [],
    selectedRows: [],
    SearchText: "",
  }),
  methods: {
    ...mapMutations(['setPlaceDetail']),
    detailClick(row) {  // 상세보기 클릭 이벤트   Author : JHW
      this.setPlaceDetail(this.placeList.data[row.id- 1]);
      this.$router.push('/placeDetail');
    },
    async searching() {
      this.searchPlace(this.SearchText);
    },
    async getPlace() {
      this.placeList = await getPlaceList();
    },

    async searchPlace(words) {
      if (words.length <= 0) {
        this.getPlace();
      } else {
        let wordlist = words.split(",");
        let placeType = wordlist[0];
        let placeName = wordlist[1];
        let address = wordlist[2];
        let phoneNumber = wordlist[3];
        let currentNumberOfPeople = wordlist[4];
        let capacity = wordlist[5];

        if (typeof placeType != "undefined") {
          placeType = placeType.trim();
        }
        if (typeof placeName != "undefined") {
          placeName = placeName.trim();
        }
        if (typeof address != "undefined") {
          address = address.trim();
        }
        if (typeof phoneNumber != "undefined") {
          phoneNumber = phoneNumber.trim();
        }
        if (typeof currentNumberOfPeople != "undefined") {
          currentNumberOfPeople = currentNumberOfPeople.trim();
        }
        if (typeof capacity != "undefined") {
          capacity = capacity.trim();
        }

        this.placeList = await searchPlace({
          placeType: placeType,
          placeName: placeName,
          address: address,
          phoneNumber: phoneNumber,
          currentNumberOfPeople: currentNumberOfPeople,
          capacity: capacity,
          pageNum: 0,
          pageSize: 10,
        });
      }
    },

    async addFavorite() {
      for (let i = 0; i < this.selected.length; i++) {
        await createFavorite(
          this.$store.getters.getToken, 
          {
            place_id: this.selected[i].id,
        }
        );
      }
      alert("즐겨찾기가 등록되었습니다");
      this.selected = [];
    },
  },
  created() {
    this.getPlace();
  },
  mounted() {},
};
</script>
<style scoped>
.menuTitle {
  font-size: 17px;
}

</style>
