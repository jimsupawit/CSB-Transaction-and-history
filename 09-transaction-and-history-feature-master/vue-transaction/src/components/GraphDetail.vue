<template>
  <div id="app-1">
    <v-container fluid>
      <v-sparkline
        :fill="fill"
        :line-width="width"
        :padding="padding"
        :smooth="radius || false"
        :value="value"
        :color="color"
        :type="type"
        :labels="label"
        :label-size="lbs"
        :auto-draw-easing="auto"
        :auto-draw-duration="time"
        :auto-draw="draw"
      ></v-sparkline>
    </v-container>
  </div>
</template>
<script>
export default {
  props: ["value","draw","color"],
  data: () => ({
    fill: true,
    padding: 5,
    radius: 0,

    width: 8,
    type: "bar",
    
    label: [
      "January",
      "Febuary",
      "March",
      "Apirl",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    ],
    lbs: "3",
    auto: "north",
    time: 1000,
    draw: true,
    drawer: false,
    item: 1
  })
};
</script>