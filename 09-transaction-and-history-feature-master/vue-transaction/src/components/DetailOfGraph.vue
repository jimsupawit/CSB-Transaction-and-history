<template>
  <div>
    <v-card style=" margin:10px;padding:10px;background-color:#2196F3;">
      <v-row style="display:flex; justify-content:space-between; padding:15px;">
          <v-card id="box" height="150px" width="200px" v-for="item in top" :key="item.month">
            <v-card-text style="font-size:30px;color:#2196F3;text-align:center;">{{item.month}}</v-card-text>
            <v-card-text style="font-size:20px;color:#2196F3;text-align:center;">{{item.val}} {{data}}</v-card-text>
          </v-card>
      </v-row>
    </v-card>

    <v-card style=" margin:10px;padding:10px;background-color:#2196F3;">
      <v-row style="display:flex; justify-content:space-between; padding:15px;">
          <v-card id="box" height="150px" width="200px" v-for="item in down" :key="item.month">
            <v-card-text style="font-size:30px;color:#2196F3;text-align:center;">{{item.month}}</v-card-text>
            <v-card-text style="font-size:20px;color:#2196F3;text-align:center;">{{item.val}} {{data}}</v-card-text>
          </v-card>
      </v-row>
    </v-card>

  </div>
</template>
<script>
import axios from "@/axios/axios.js";
export default {
  props: ["value","id"],
  data() {
    return {
      top: [],
      down: [],
      months: ["Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
      data:""
    };
  },
  methods: {
    initValue() {
      this.top = [];
      this.down = [];
      for (let i = 0; i < 6; i++) {
        this.top.push({
          month: this.months[i],
          val: parseFloat(this.value[i]).toFixed(2)
        });
      }
      for (let j = 6; j < 12; j++) {
        this.down.push({
          month: this.months[j],
          val: parseFloat(this.value[j]).toFixed(2)
        });
      
      }
    }
  },
  async mounted() {
    
    this.initValue();
console.log('this')
    console.log(this.$route.params.id)
    const res = await axios.get("/currency",{
       params:{account_id:this.$route.params.id}
     })
     this.data=res.data.NameCurrency;
     console.log('Currency')
    console.log(this.data);
  },
  watch:{
    value(){
      this.initValue();
    }
  }
};
</script>>
<style scoped>
#box {
  margin-top: 30px;
}
</style>