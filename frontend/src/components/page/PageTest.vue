<!-- author KJH -->

<template>
  <div>
    <div>
    <p> 1. /find TEST (get) </p>
    <table>
      <thead>
        <th>장소종류</th>
        <th>장소이름</th>
        <th>주소</th>
        <th>전화번호</th>
        <th>현재 수용인원 </th>
        <th>최대 수용인원 </th>
      </thead>
      <tbody>
        <tr :key="i" v-for="(place, i) in placeList.data">
          <td>{{place.placeType}}</td>
          <td>{{place.placeName}}</td>
          <td>{{place.address}}</td>
          <td>{{place.phoneNumber}}</td>
          <td>{{place.currentNumberOfPeople}}</td>
          <td>{{place.capacity}}</td>
        </tr>
      </tbody>
    </table>
    </div>
    <div>

    </div>

  </div>
</template>
<script>
import {getPlaceList} from '../../Service/PlaceService'

export default {
  name: 'PlaceTest',
  data() {
    return {
      placeList: []
    }
  },
  created() {
    this.getPlace();
  },
  methods: {
    async getPlace () {
      this.placeList = await getPlaceList();
    }
  }
}
</script>
<style scoped>
table {
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
p {
  font-size: 20px;
  font-weight: bold;
  margin: 8px;

}
</style>