<template>
  <main class="emptyCart">
      <p></p>
      <div>
        <img src="https://professionalscareer.com/assets/images/emptycart.png" alt="image here"/>
    </div>
    <h2>
        Your cart feels so light!
        <span style='font-size:40px;'>&#128532;</span>
        <p></p>
    </h2>
    <router-link :to="{name: 'home'}">
  <button id="myButton" class="btn btn-dark btn-lg btn-block">Start Shopping!</button>

</router-link>
  </main>
</template>

<script>
export default {
  name: 'EmptyCart'
}
</script>

<style scoped>
.emptyCart {
  color: gray;
  text-decoration: grey;

}
.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
    width: 400px;
    margin-left: 520px;
}
</style>
