<template>
  <v-app id="app">
    <appbar/>
    <drawer />
    <v-main>
      <router-view/>
    </v-main>
    
  </v-app>
</template>

<script>
import drawer from './components/layout/drawer.vue'
import appbar from './components/layout/appbar.vue';


export default {
  name: 'App',
  components: {drawer, appbar},
};
</script>
