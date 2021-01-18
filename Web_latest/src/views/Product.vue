<template>
    <main class="products">
        <div class="product">
            <img :src="img" alt="" />
            <div class="product__info">
            <a href="/productdetails"><p>{{title}}</p></a>
            <p class="product__price">
                <small>₹</small>
                <strong>{{price}}</strong>
            </p>
            </div>
        </div>
    </main>
</template>

<script>

export default {
  name: 'Products',
  props: {
    img: String,
    title: String,
    price: String
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
a :link{
    text-decoration: none;
}
.product__info {
    height: 100px;
    margin-bottom: -60px;
}

.product__price {
    margin-top: 2px;
}
</style>
