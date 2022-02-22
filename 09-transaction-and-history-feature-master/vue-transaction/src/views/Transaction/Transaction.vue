<template>
  <div>
    {{data.Date}} 
    <span :style="typeStyle">{{formatAmount}} {{data.currency}}  {{data.type}}</span>
  </div>
</template>

<script>
export default {
  props: ["data"],
  computed: {
    typeStyle() {
      if (this.data.type==="Transfer") {
        return { color: "blue"};
      }if(this.data.type ==="Withdraw"){
        return {color:"red"};
      }else{
        return {color:"green"};
      }
    },
    formatAmount(){
      return parseFloat(this.data.amount).toFixed(2);
    }
  },
   async mounted(){
    if(this.data.account_id != this.data.payee_id){
      return this.data.type=this.data.type.replace("Withdraw","Transfer");
    }
  }
};
</script>