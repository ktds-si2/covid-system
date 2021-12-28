// author KJH

<template>
  <div id="store">
    {{this.$store.getters.getToken}}
  </div>
</template>
<script>
    export default {
        name: 'PageTest'
    }
</script>

