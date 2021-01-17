<template>
  <main class="orderPlaced">
      <p></p>
      <img class="image12" src="https://siteforms.ie/wp-content/uploads/2020/05/e-commerce_shopping_order_completed-5121.png"/>
    <h2>
        <br>
        YAY! <br>
        Order Placed Successfully!<br>
        Thank you for shopping with us.
        <span style='font-size:40px;'>&#128513;</span>

        <p></p>
    </h2>
    <router-link :o="{name: 'home'}">
  <button id="myButton" class="btn btn-dark btn-lg btn-block">Home</button>

</router-link>
  </main>
</template>

<script>
export default {
  name: 'OrderPlaced'
}
</script>

<style scoped>
.orderPlaced {
  color: gray;
  text-decoration: grey;

}
.image12 {
    width: 60%;
    height: 40%;
}
</style>
