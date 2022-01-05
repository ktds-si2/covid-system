<!-- 그래프 라인    Author : JHW -->
<script>
  import {Bar} from 'vue-chartjs'
import { mapState } from 'vuex'
  export default { 
    extends: Bar,
    computed:{
      ...mapState(['CoronaCntOfEachCity'])
    },
    data () {
      return {
        datacollection:null,
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true 
              },
              gridLines: {
                display: true 
              }
            }],
            xAxes: [ {
              gridLines: {
                display: true 
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: false, 
          maintainAspectRatio: false,
          width:1000
        }
      }
    },
    mounted () {
      this.renderChart(this.datacollection, this.options) 
    },
    created(){
      this.datacollection = {
        labels: ["서울", "경기", "대전", "대구", "부산", "광주"],
        datasets:[
          {
            label:'주요 도시 코로나 확진자 수',
            backgroundColor: 'darkyellow',
            data: [(this.CoronaCntOfEachCity.seoul.newCase).replace(",",""), (this.CoronaCntOfEachCity.gyeonggi.newCase).replace(",",""), 
            (this.CoronaCntOfEachCity.daejeon.newCase).replace(",",""), (this.CoronaCntOfEachCity.daegu.newCase).replace(",",""), 
            (this.CoronaCntOfEachCity.busan.newCase).replace(",",""), (this.CoronaCntOfEachCity.gwangju.newCase).replace(",","")],
          }
        ]
      }
    }
  }
</script>