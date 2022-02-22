<template>
  <div class="graph">
    <div style="display:flex; justify-content:space-between; padding:15px;">
      <h1 id="hold">Graph of Your Banked Statement</h1>
      <router-link to="/History">
        <v-btn  large color="primary">Back</v-btn>
      </router-link>
    </div>
    <div>
      <GraphDetail :value="value" :color="color" :draw="draw"></GraphDetail>
    </div>
    <div id="app" style="padding:20px;">
      <v-row>
        <div>
          <v-btn v-on:click="update_deposit" large color="primary">Change to Deposit</v-btn>
          
        </div>
        <div style="margin-left:20px;">
          <v-btn v-on:click="update_withdraw" large color="primary">Change to withdraw</v-btn>
        </div>
      </v-row>
    </div>
    <h1 style="padding:10px;">This is Table show details of Graph</h1>
    <DetailOfGraph :id="id" :value="value"></DetailOfGraph>
  </div>
</template>
<script>
import axios from '../../axios/axios.js';
import GraphDetail from "@/components/GraphDetail.vue";
import DetailOfGraph from "@/components/DetailOfGraph.vue";
export default {
  props:["data"],
  el: "app-1",
  components: {
    GraphDetail,
    DetailOfGraph
  },
  data: () => ({
    graph:"",
    color: "#2196F3",
    id:"",
    id2:"",
    value: [1,2,3,4,5,6,7,8,9,10,11,12],
    items: [
      { text: "Home", link: "/" },
      { text: "My Account", link: "/View" },
      { text: "Open Account", link: "/Open" },
      { text: "Close Account", link: "/Close" },
      { text: "Location", link: "/location" },
      { text: "Equipment Management", link: "/equipment" }
    ],
    currency:null
  }),
  methods: {
    update_deposit:async function() {
      (this.value = []),
        (this.color = "#2196F3");
      this.draw = false;
      const response = await axios.get("/allhistory",{
       params:{accid:this.id}
       
     });
     this.graph = response.data.Money;
     console.log(response.data);
     this.value=this.graph;
    },
    update_withdraw:async function() {
      
      (this.value2 = []),
        (this.color = "red");
      this.draw = false;
      const res = await axios.get("/withdraw",{
       params:{accid:this.id}
     })
     this.withdraw = res.data.MoneyWithdraw;
     this.value =this.withdraw;
    }
  },
   async mounted(){
     
     this.currency = this.$route.params.currency;
 
     this.id=this.$route.params.id;
     this.update_deposit(); 
     console.log('id')
     console.log(this.id)
   
     this.id2=this.$route.params.id;
   },
   watch:{
     graph(){
      //  for(let i =0; i<this.graph.length;i++){
      //    this.graph[i] = parseFloat(this.graph[i]).toFixed(2);
      //  }
       console.log('hello');
       
     }
   }
};
</script>
<style>
@import url("https://fonts.googleapis.com/css?family=Nunito&display=swap");

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