<!-- Author : JHW -->
<template>
  <v-app-bar color="white" flat app>
    <v-container class="py-6 fill-height">
      <v-avatar class="mr-10" color="grey darken-1" size="32"></v-avatar>

      <v-btn v-for="link in links" :key="link" text>
        {{ link }}
      </v-btn>

      <v-spacer></v-spacer>

      <v-responsive max-width="260">
        <v-text-field
          dense
          flat
          hide-details
          rounded
          solo-inverted
          v-model="data"
          v-on:keyup.enter="input"
        ></v-text-field>
      </v-responsive>
    </v-container>
  </v-app-bar>
</template>

<script>
export default {
  name: "appbar",
  data() {
    return {
      data: '',
      links: ["arr1", "arr2", "Profile", "Updates"],
    };
  },
  methods: {
    input() {
      // this.$store.dispatch()
    }
  }
};
</script>
