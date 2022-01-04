<!-- 장소 상세보기 페이지       Author : JHW -->
<template>
    <div>
    <v-form>
    <v-container>
      <v-row>
        <v-col
          cols="12"
          sm="2"
        >
          <v-text-field
            readonly
            v-model="placeDetail.placeName"
            label="장소이름"
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          sm="2"
        >
          <v-text-field
            readonly
            v-model="placeDetail.placeType"
            label="장소타입"
          ></v-text-field>
        </v-col>

        
        <v-col
          cols="12"
          sm="2"
        >
          <v-text-field
            readonly
            v-model="placeDetail.capacity"
            label="최대수용인원"
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
          sm="2"
        >
          <v-text-field
            readonly
            v-model="placeDetail.currentNumberOfPeople"
            label="현재 인원"
          >
          </v-text-field>
        </v-col>
        </v-row>
        
        <v-row>
        <v-col
          cols="12"
          sm="4"
        >
          <v-text-field
            readonly
            v-model="placeDetail.address"
            label="주소"
          ></v-text-field>
        </v-col>
        <v-col
          cols="12"
          sm="4"
        >
          <v-text-field
            readonly
            v-model="placeDetail.phoneNumber"
            label="연락처"
          ></v-text-field>
        </v-col>

        </v-row>
        <v-row>

        <v-col
          cols="12"
          sm="8"
        >
          <v-text-field
            readonly
            v-model="placeDetail.memo"
            label="공지"
          ></v-text-field>
        </v-col>



      </v-row>
    </v-container>
  </v-form>
    <Map />
    </div>
</template>


<script>
import Map from './Map.vue';
import {mapState} from 'vuex';

export default {
    name: '',
    components: {
        Map
    },
    computed: {
        ...mapState(['placeDetail'])
    },
    data () {
      return {
        title: 'Preliminary report',
        description: 'California is a state in the western United States',
        rules: [v => v.length <= 25 || 'Max 25 characters'],
        wordsRules: [v => v.trim().split(' ').length <= 5 || 'Max 5 words'],
      }
    },
}
</script>

<style scoped>
    .disable-events {
    pointer-events: none
    }
</style>
