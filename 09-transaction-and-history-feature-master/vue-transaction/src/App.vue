<template>
<v-app>
    <Nav/>
    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>
import Nav from './components/Nav';


  export default {
      components: {
        Nav
      }
  }
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Nunito&display=swap");

#app {
  font-family: "Nunito", sans-serif;
}

a {
  text-decoration: none;
}

</style>
