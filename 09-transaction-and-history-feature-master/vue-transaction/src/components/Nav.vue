<template>
  <nav>
    <v-app-bar app color="blue darken-2" light>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <router-link to="/History">
        <v-img src="../assets/logo.svg" max-width="60px" class="mr-3"></v-img>
      </router-link>
      <v-toolbar-title class="d-flex align-center title1" style="color:white">
        CS Banking
      </v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-spacer></v-spacer>
    <v-navigation-drawer app v-model="drawer" stateless>
      <v-list flat>
        <v-list-item-group v-model="item" color="primary">
          <router-link
            :to="item.link"
            v-for="(item, i) in items"
            :key="i"
            style="text-decoration:none"
          >
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title v-text="item.text"></v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </router-link>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      items: [
        { text: "Home", link: "/" },
        { text: "My Account", link: "/View" },
        { text: "Open Account", link: "/Open" },
        { text: "Close Account", link: "/Close" },
        { text: "Location", link: "/location" },
        { text: "Equipment Management", link: "/equipment" }
      ],
      drawer: false
    };
  }
};
</script>

<style>
.v-toolbar__title {
  font-size: 1.6em;
  line-height: 1.5;
  overflow: hidden;
  overflow-x: hidden;
  overflow-y: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  font-weight: 900;
}
</style>