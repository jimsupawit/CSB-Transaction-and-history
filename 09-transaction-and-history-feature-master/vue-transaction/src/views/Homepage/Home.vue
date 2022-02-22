<template>
  <v-container fluid class="pa-12">
    <v-card max-height="1200px" style="padding:50px;">
    <v-row>
      <v-card color="#2196F3" class="white--text">
        <v-card-text class="white--text">
          <h2>Available balance : {{Currency}}</h2>
        </v-card-text>
      </v-card>
      <v-spacer></v-spacer>
      <v-card color="#2196F3">
        <v-card-text class="white--text">
          <h2>{{ datenow }}</h2>
        </v-card-text>
      </v-card>
      <v-spacer></v-spacer>

      <v-dialog v-model="dialog" width="500">
        <template v-slot:activator="{ on }">
          <v-btn color="green lighten-2" v-on="on" class="white--text">Select History by Calendar</v-btn>
        </template>
        <v-card height="500px">
          <v-card-title class="grey lighten-2">Choose your month</v-card-title>
          <v-divider></v-divider>

          <v-card-text class="text-center">
            <v-date-picker v-model="picker" class="mt-5" type="month"></v-date-picker>
          </v-card-text>
        </v-card>
      </v-dialog>

      <router-link :to="{name:'Graph', params:{id: AccountID,currency:renderHistory}}">
        <v-btn class="green lighten-2 ml-4 white--text">Graph</v-btn>
      </router-link>
    </v-row>

    <v-row id="block2">
      <v-card color="#2196F3" max-height="80px" max-width="300px" id="account">
        <v-card-text class="white--text">
          <h2>Acount Name And Account ID</h2>
          <h2>{{e1}}</h2>
        </v-card-text>
      </v-card>
      <v-spacer></v-spacer>
      <!-- <v-card id="account" color="#2196F3" width="250px" max-height="80px">
        <v-card-text class="white--text">
          <h2>Account ID</h2>
          <h2>{{AccountID}}</h2>
        </v-card-text>
      </v-card> -->
      <v-space></v-space>
      <v-space></v-space>
      <v-card id="account2" color="#2196F3" max-height="80px">
        <v-card-text class="white--text">
          <h2>Account Type</h2>
          <h2>{{AccType}}</h2>
        </v-card-text>
      </v-card>
      <v-spacer></v-spacer>
      <v-card id="chgacc" color="#2196F3" class="white--text" width="400px">
        <v-card-text class="white--text">
          <h2>
            Choose Account :
            <v-autocomplete item-color="blue" :items="items" v-model="e1"></v-autocomplete>
          </h2>
        </v-card-text>
      </v-card>
     
    </v-row>
    <v-card style="margin:30px">
    <v-row class="pa-12">
      <v-card color="#2196F3" width="100%" class="text-center">
        <v-card-text class="white--text pa-2">
          <h2>History</h2>
        </v-card-text>
      </v-card>
    </v-row>

    <Transactions :pi="picker" :transactions="renderHistory"></Transactions>
    </v-card>
    </v-card>
  </v-container>
</template>

<script>
import axios from "../../axios/axios.js";
import Transactions from "../Transaction/Transactions";
var moment = require("moment");

export default {
  props: ["data"],
  components: {
    Transactions
  },
  data() {
    return {
      dialog: false,
      datenow: "",
      items2: [],
      transactions: [],
      picker: moment().format("YYYY-MM"),
      picker2: "",
      items: [],
      e1: "",
      renderHistory: [],
      Currency: "",
      AccountID: "",
      AccType: "",
      ArreyAccount: [],
      History:[]
    };
  },
  methods: {
    getTime() {
      return moment().format("YYYY" + "-" + "MM");
    },
    time() {
      var self = this;
      this.datenow = moment().format("DD MMMM YYYY" + " " + "hh:mm a");
      setTimeout(self.time, 1000);
    },
    onScroll(e) {
      this.offsetTop = e.target.scrollTop;
    },
    scrollToEnd: function() {
      var scroll = this.$el.querySelector("#scroll");
      scroll.scrollTop = scroll.scrollHeight;
    },
    populate: function() {
      for (var i = 200; i > 0; i--) {
        this.items2.push("Item #" + i);
      }
    },
    updateRenderHistory() {
      //get account id
      let accId = null;
      for (let i = 0; i < this.account.length; i++) {
        if (this.account[i].name + " " + this.account[i].id === this.e1) {
          accId = this.account[i].id;
          this.Currency = this.account[i].balance;
          this.AccountID = this.account[i].id;
          this.AccType = this.account[i].account_type;
        }
      }
      console.log("account id is ", accId);
      for (let i = 0; i < this.transactions.length; i++) {
        if (this.transactions[i].account_id === accId) {
          this.renderHistory.push(this.transactions[i]);
        }
      }
      //     for (let i =this.History.length-1; i >0; i--) {
      //     this.renderHistory.push(this.History[i]);
      //     console.log('Bug?');
      // }
      // for(let i =this.History.length;i>0;i--){
      //   this.renderHistory.push(this.History[i]);
      // }
      console.log('This is s')
      console.log(this.renderHistory) 
      console.log(this.transactions.length)
      console.log(this.account);
    }
  },
  watch: {
    e1() {
      this.renderHistory = [];
      this.updateRenderHistory();
    }
  },
  async mounted() {
    this.time();
    this.populate();

    const response = await axios.get("/account");
    this.account = response.data;
    for (let i = 0; i < this.account.length; i++) {
      const temp = this.account[i].name + " " + this.account[i].id;
      this.items.push(temp);
    }
    console.log("items");
    console.log(this.items);
    this.e1=this.items[0];

    
    

    const res = await axios.get("/history", {
      params: { num: 27 }
});
    this.transactions = res.data;
    console.log("all transactions");
    console.log(this.transactions);
    console.log("this is picker");
    console.log(this.picker)
    

    this.updateRenderHistory();
  },
  data2: () => ({
    date: new Date().toISOString().substr(0, 7)
  })
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Nunito&display=swap");

h2 {
  font-size: 1.4em;
}
#block2 {
  margin-top: 20px;
}
#account {
  margin-top: 30px;
}
#account2 {
  margin-top: 30px;
  margin-left: 10px;
}
#chgacc {
  margin-right: 10px;
  margin-top: 10px;
}

</style>
