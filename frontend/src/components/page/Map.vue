<!-- Google Map     Author : JHW -->
<template>
    <div>
        <GmapMap ref="mapRef" :center="{lat : 37.5651 , lng : 126.98955}" :zoom="13" style="width:800px; height:600px">
        <GmapMarker 
         
         :position="{lat : 37.5651 , lng : 126.98955}"
         :title="'Seoul'"
         @click="toggleInfo({lat : 37.5651 , lng : 126.98955}, 0)"
         :clickable="true"
          />
        <GmapInfoWindow
          @closeclick="window_open=false"
          :opened="window_open"
         :position="infoWindowPos"><div v-html="infoContent"/></GmapInfoWindow>
     </GmapMap>
    </div>
</template>

<script>
export default {
    name: 'GoogleMap',
    data () {
        return {
            window_open: false,
                infoContent: '',
                infoWindowPos:{
                    lat: 0,
                    lng: 0
                },
                currentMidx: null
        }
    },
    methods : {
    toggleInfo(marker, index){
            this.infoWindowPos.lat = marker.lat;
            this.infoWindowPos.lng = marker.lng;
            this.infoContent = 'test';
            if(this.currentMidx == index){
                this.window_open = !this.window_open;
            }else{
                this.window_open = true;
                this.currentMidx = index;
            }
        }
    }
}
</script>