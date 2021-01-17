<template>
    <main class="products">
        <div class="product">
            <img :src="img" alt="" />
            <div class="product__info">
            <p>{{title}}</p>
            <p class="product__price">
                <small>₹</small>
                <strong>{{price}}</strong>
            </p>
            </div>
        </div>
    </main>
</template>

<script>
// import Vue from 'vue'
// import axios from 'axios'
// import VueAxios from 'vue-axios'
// Vue.use(VueAxios, axios)

export default {
  name: 'Products',
  props: {
    img: String,
    title: String,
    price: Number
  }
}
</script>

<style scoped>

.product {
    margin: 10px;
    padding: 20px;
    max-height: 400px;
    min-width: 100px;
    background-color:whitesmoke;
    z-index: 1;
}

.product > img:hover {
    transform: scale(1.5);
}
.product > img {
    max-height: 200px;
    width: auto;
    object-fit: contain;
    margin-bottom: 0PX;
    transition: transform 600ms;
}

.product__info {
    height: 100px;
    margin-bottom: -60px;
}

.product__price {
    margin-top: 2px;
}
</style>
