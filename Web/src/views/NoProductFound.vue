<template>
  <main class="noProductFound">
      <p></p>
      <div>
        <img src="https://lh3.googleusercontent.com/proxy/W2zLdc7N6UQuol_KfyLuNMKJCmu6sHRmI605o3lmwUkSKHSXu0Fr8MA4dz-wWi1yKyqcm1VHiq5kcKWT_yOd7Qv_jQgR" alt="image here"/>
    </div>
    <h2>
        Sorry! No products found.
        <span style='font-size:40px;'>&#128532;</span>
        <p></p>
    </h2>
    <router-link to="/">
  <button id="myButton" class="btn btn-dark btn-lg btn-block">Start Shopping!</button>
 </router-link>
  </main>
</template>

<script>
export default {
  name: 'NoProductFound'
}
</script>

<style scoped>
.emptyCart {
  color: gray;
  text-decoration: grey;
}
.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
    width: 350px;
    margin-left: 580px;
}
</style>
