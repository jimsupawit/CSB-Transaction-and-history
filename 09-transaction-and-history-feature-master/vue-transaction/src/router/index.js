import Vue from "vue";
import VueRouter from "vue-router";
import Home from '@/views/Homepage/Home';
import Graph from '@/views/Graph/Graph';


Vue.use(VueRouter);

const routes = [
  {
    path: '/History',
    name: 'Home',
    component: Home
  },
  {
    path:'/Graph/:id',
    name:'Graph',
    component:Graph
  },
];

const router = new VueRouter({
  routes,
  mode:'history'
});
console.log(router);
export default router;
