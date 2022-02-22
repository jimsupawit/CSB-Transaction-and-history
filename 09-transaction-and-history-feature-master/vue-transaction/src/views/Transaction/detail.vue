<template>
  <!-- <v-dialog v-model="dialog" persistent max-width="290">
    <template v-slot:activator="{ on }">
      <v-btn color="primary" dark v-on="on">Open Dialog</v-btn>
    </template>
    <v-card>
      <v-card-title class="headline">Use Google's location service?</v-card-title>
      <v-card-text>Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.</v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="green darken-1" text @click="dialog = false">Disagree</v-btn>
        <v-btn color="green darken-1" text @click="dialog = false">Agree</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>-->
  <v-dialog v-model="dialog" persistent max-width="600" id="dailog" overlay-color="#2196F3">
    <template v-slot:activator="{ on }">
      <v-btn id="dialog" color="primary" dark v-on="on">Open Detail</v-btn>
    </template>
    <v-card id="popup">
      <v-card-title class="headline">Details</v-card-title>
      <v-card-text id="timestamp">{{data.Date}}</v-card-text>
      <v-card-text id="from1">From</v-card-text>
      <v-card-text id="from">AccountID</v-card-text>
      <v-card-text id="left">{{data.account_id}}</v-card-text>
      <v-card-text></v-card-text>
      <v-card-text></v-card-text>
      <v-card-text></v-card-text>
      <v-card-text></v-card-text>
      <v-card-text></v-card-text>
      <v-card-text></v-card-text>

      <v-card-text id="to">To CSB</v-card-text>
      <v-card-text id="from2">{{data.note}}</v-card-text>
      <v-card-text id="left2">{{data.payee_id}}</v-card-text>
      <v-card-text id="income">Income / Expense</v-card-text>
      <v-card-text id="amount">
        <span :style="typeStyle">{{data.type}} {{formatAmount}}</span>
      </v-card-text>
      <v-card-text id="bath">{{data.currency}}</v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>

        <v-btn color="white" text @click="dialog =false">Back</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: ["data"],
  data() {
    return {
      dialog: false,
    };
  },
  computed: {
    typeStyle() {
      if (this.data.type==="Transfer") {
        return { color: "blue" };
      }if(this.data.type ==="Withdraw"){
        return {color:"red"};
      }else{
        return {color:"green"};
      }
    },
    formatAmount(){
      return parseFloat(this.data.amount).toFixed(2);
    }
  }
};
</script>

<style >
#dialog {
  display: flex;
  justify-content: flex-end;
}
#left {
  position: absolute;
  left: 70%;
  top: 10%;
}
#timestamp {
  text-align: center;
  color: white;
  font-family: "Nunito", sans-serif;
  font-size: 25px;
  font-weight: 50;
}
#from {
  position: absolute;
  top: 35%;
  left: 15%;
  color: white;
}
#from1 {
  position: absolute;
  top: 35%;
  left: 5%;
  color: white;
}
#left {
  position: absolute;
  top: 35%;
  left: 55%;
  width: 200px;
  color: white;
}
#left2 {
  position: absolute;
  top: 50%;
  left: 55%;
  width: 200px;
  color: white;
}
#to {
  position: absolute;
  top: 50%;
  left: 5%;
  color: white;
}
#from2 {
  position: absolute;
  top: 50%;
  left: 15%;
  color: white;
}
#income {
  position: absolute;
  top: 65%;
  left: 5%;
  color: white;
}
#amount {
  position: absolute;
  top: 65%;
  left: 30%;
  color: lightgreen;
}
#bath {
  position: absolute;
  top: 65%;
  left: 60%;
  color: white;
}
#popup {
  background-color: #2196f3;
}
.headline {
  color: white;
}
</style>>