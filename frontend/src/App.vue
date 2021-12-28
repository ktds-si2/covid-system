<template>
  <div id="app">
    <Header />
    <img alt="Vue logo" src="./assets/logo.png">
    <Main/>
  </div>
</template>

<script>
import Header from './components/layout/Header.vue'
import Main from './components/page/Main.vue'

export default {
  name: 'App',
  components: {
    Header, Main
  }
}
</script>

