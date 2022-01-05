<!-- Chart Template   Author : JHW -->
<template>
    <div class="columns" align="center" style="margin-top:100px;">
      <div class="column">
        코로나 총 확진자 수 : {{CoronaCntOfEachCity.korea.newCase}}
        <line-chart></line-chart>
      </div>
    </div>
</template>
 
<script>
  import LineChart from './LineChart.vue'
  import {mapActions,mapState} from 'vuex';
 
  export default {
    name: 'CoronaChart',
    computed: {
      ...mapState(['CoronaCntOfEachCity'])
    },
    components: {
      LineChart
    },
    methods: {
      ...mapActions(['setCoronaCntOfEachCity']),
    },
    created () {
      this.setCoronaCntOfEachCity();
    }
  }
</script>
 
<style scoped>
 
</style>