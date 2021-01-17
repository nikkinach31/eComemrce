<template>
  <main class="noProductFound">
      <p></p>
      <div>
        <img src="https://lh3.googleusercontent.com/proxy/nY7-lt5da8gyL1aoY88S9jqNlc-WNnakVIjReVAtgciMhUxmt78Ju-mMrcEli59QRSvo8YxF5tjNWuG-aagVT4SXaOe3g3B9" alt="image here"/>
    </div>
    <h2>
        Sorry! No products found.
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
  name: 'NoProductFound'
}
</script>

<style scoped>
.emptyCart {
  color: gray;
  text-decoration: grey;

}
</style>
