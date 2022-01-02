<!-- 장소 등록  -->
<!-- Author : KJH -->
<template>
  <v-container class="pa-8">
    <v-row class="mt-10">
        <v-col> <div class="menuTitle"> 장소 등록 </div> </v-col>    
    </v-row>
    <v-row class="mt-6">
      <v-col sm="3">
        <v-text-field v-model="placeType" label="PlaceType"> </v-text-field>
        <v-text-field v-model="placeName" label="PlaceName"> </v-text-field>
        <v-text-field v-model="address" label="Address"> </v-text-field>
        <v-text-field v-model="phoneNumber" label="PhoneNumber"> </v-text-field>
        <v-text-field v-model="currentNumberOfPeople" label="CurrentNumberOfPeople"> </v-text-field>
        <v-text-field v-model="capacity" label="Capacity"> </v-text-field>
      </v-col>
    </v-row>
    <v-row>
      <v-col> <v-btn @click="createPlace"> 등록 </v-btn> </v-col>
    </v-row>
  </v-container>
</template>
<script>
import { createNewPlace } from "../../../Service/AdminService";

export default {
  name: "CreatePage",
  computed: {
    getToken() {
      return this.$store.getters.getToken;
    },
  },
  data() {
    return {
      tokenDto: "token",
      placeType: '',
      placeName: '',
      address: '',
      phoneNumber: '',
      currentNumberOfPeople: '',
      capacity: '',
    };
  },
  methods: {
    async createPlace() {
      if (typeof this.placeType != "undefined") {
        this.placeType = this.placeType.trim();
      }
      if (typeof this.placeName != "undefined") {
        this.placeName = this.placeName.trim();
      }
      if (typeof this.address != "undefined") {
        this.address = this.address.trim();
      }
      if (typeof this.phoneNumber != "undefined") {
        this.phoneNumber = this.phoneNumber.trim();
      }
      if (typeof this.currentNumberOfPeople != "undefined") {
        this.currentNumberOfPeople = this.currentNumberOfPeople.trim();
      }
      if (typeof this.capacity != "undefined") {
        this.capacity = this.capacity.trim();
      }

      this.placeList = await createNewPlace({
        'placeType': this.placeType,
        'placeName': this.placeName,
        'address': this.address,
        'phoneNumber': this.phoneNumber,
        'currentNumberOfPeople': this.currentNumberOfPeople,
        'capacity': this.capacity,
        'pageNum': 0,
        'pageSize': 10,
      }, this.$store.getters.getToken); 
      
      if (this.placeList != null) {
          alert("장소등록이 되었습니다.")
          
          this.placeType = ''
          this.placeName = ''
          this.address = ''
          this.phoneNumber = ''
          this.currentNumberOfPeople = ''
          this.capacity = ''
          this.$router.go(-1)
      }
      else {
          alert("장소등록 실패!")
      }
    },
  },
};
</script>
<style scoped>
.menuTitle {
  font-size: 17px !important
}

</style>