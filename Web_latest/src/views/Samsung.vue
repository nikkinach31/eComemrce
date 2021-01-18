<template>
    <main class="samsung">
        <nav class="product-filter">
        <img class="samsung__image" src="https://os-jo.com/image/catalog/revslider_media_folder/-samsung-logo-transparent-9.png" alt=""/>
  </nav>
<section class="products__container">
  <!-- It's likely you'll need to link the card somewhere. You could add a button in the info, link the titles, or even wrap the entire card in an <a href="..."> -->
  <div class="product-card">
    <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
        <div class="product-image">
      <img src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg">
    </div>
    <div class="product-info">
      <h5>Iphone</h5>
      <h6>₹90,999</h6>
    </div>
  </div>
  <!-- more products -->
</section>
    </main>
</template>

<script>
export default {
  name: 'Samsung'
}
</script>

<style scoped>

/* .product-filter h1 {
  display: flex;
  margin-top: 10px;
  flex-grow: 1;
} */

.samsung__image {
flex-grow: 1;
max-height: 150px;
max-width: 100%;
}

.products__container {
  display: flex;
  flex-wrap: wrap;
}

.product-card {
  padding: 2%;
  flex-grow: 1;
  flex-basis: 16%;
   display: flex; /* so child elements can use flexbox stuff too! */
}

.product-card {
  flex: 1 16%;
}

.product-image img {
  max-width: 100%;
}

.product-info {
  margin-top: auto;
}

@media (max-width: 920px) {
  .product-card {
    flex: 1 21%;
  }
}

</style>
