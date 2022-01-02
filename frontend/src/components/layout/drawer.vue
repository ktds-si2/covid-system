<!-- author: KJH -->
<template>
  <v-navigation-drawer 
  id="drawer"
  dark width="260" 
  app>
    <v-list dense nav>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="firstlist" v-text="'kt ds'" />
        </v-list-item-content>
      </v-list-item>
    </v-list>

    <v-divider class="mb-2" />

    <v-list expand nav>
      <v-list-item v-for="item in items" :key="item.title" :to="item.link" link>
        <v-list-item-content>
          <v-list-item-title class="secondlist"> {{ item.title }} </v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  name: "drawer",

  data: () => ({
    drawer: null,
    items: [
      { title: "Home", link: "/" },
      { title: "Favorite", link: "/favorite" },
      { title: "Login", link: "/login" },
      { title: "Admin", link: "/admin"}
    ],
  }),
};
</script>
<style scoped>
.firstlist {
  font-size: 20px !important;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.drawer {
  padding: 8px !important
}
</style>
