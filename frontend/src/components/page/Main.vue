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
          :headers="headers"
          :items="placeList.data"
          :items-per-page="5"
          dark
        >
          <!-- <v-simple-table dark>
              <template>
                <thead>
                  <tr @click="rowClicked("> 
                    <th class="text-left">장소 종류</th>
                    <th class="text-left">장소 이름</th>
                    <th class="text-left">주소</th>
                    <th class="text-left">전화 번호</th>
                    <th class="text-left">현재 인원</th>
                    <th class="text-left">최대 인원</th>
                    <th class="text-left">즐겨찾기</th>
                  </tr>
                </thead>
                <tbody>
                  <tr :key="i" v-for="(place, i) in placeList.data">
                    <td>{{ place.placeType }}</td>
                    <td>{{ place.placeName }}</td>
                    <td>{{ place.address }}</td>
                    <td>{{ place.phoneNumber }}</td>
                    <td>{{ place.currentNumberOfPeople }}</td>
                    <td>{{ place.capacity }}</td>
                    <td>{{ place.id }}</td>
                  </tr>
                </tbody>
              </template>
            </v-simple-table> -->
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
import { getPlaceList } from "../../Service/PlaceService";
import { searchPlace } from "../../Service/PlaceService";
import { createFavorite } from "../../Service/PlaceService";

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
    ],
    placeList: [],
    selected: [],
    SearchText: "",
  }),
  methods: {
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
