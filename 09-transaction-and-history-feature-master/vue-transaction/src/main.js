import Vue from "vue";
import App from "./App.vue";
import router from './router/index';
import vuetify from "./plugins/vuetify";
import index from "./store/index.js";

Vue.config.productionTip = false;

new Vue({
  router,
  vuetify,index,
  render: h => h(App)
}).$mount("#app");



