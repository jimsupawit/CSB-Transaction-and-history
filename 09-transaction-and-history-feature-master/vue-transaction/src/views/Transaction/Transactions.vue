<template>
<div>
   <div v-if="renderTransactions != null && renderTransactions.length > 0" id="app2">
    <div id="scroll" style="max-height:600px; overflow-y: auto; max-width:100vw">
      <v-card-text v-for="(transaction, index) in renderTransactions" :key="index">
        <Transaction :data="transaction"></Transaction>
        <detail :data="transaction"></detail>
       
      </v-card-text>
    </div>
  </div>
  <div v-else style="padding:20px;">
    No transaction
  </div>
</div>
 
</template>

<script>
import detail from "./detail";
import Transaction from "./Transaction";
export default {
  props:['transactions','pi'],
  components: {
    Transaction,
    detail
  },
  data(){
    return{
       renderTransactions:[]
    }
  },
  async mounted(){
    
    this.renderTransactions = this.transactions;
  
    this.updateRender();
  },
  watch:{
    transactions(){
      this.renderTransactions = this.transactions;
      this.updateRender();
    },
    pi(){
      this.updateRender();
    }
  },
  methods:{
    updateRender(){
      this.renderTransactions = [];
     
      for(let i=0;i<this.transactions.length;i++){
       
        if(this.transactions[i].Date.substring(0,7) === this.pi){
          this.renderTransactions.push(this.transactions[i]);
        }
      } 
    }
  }
};
</script>