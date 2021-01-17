<template>
  <main class="productDetails">
      <div class="left-column">
    <img data-image="black" src="" alt="">
    <img data-image="blue" src="images/blue.png" alt="">
    <img data-image="red" class="active" src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg" alt="">
  </div>
  <!-- Right Column -->
  <div class="right-column">
  <!-- Product Description -->
    <div class="product-description">
      <span>Apple</span>
      <h1>Iphone 12 Max Pro</h1>
      <p>camera features: Digital Zoom, Auto Flash, Face detection, Touch to focus
    image resolution: 4000 x 3000 Pixels
    auto focus:Yes, Phase Detection autofocus, Dual Pixel autofocus</p>
    </div>
    <!-- Product Configuration -->
    <div class="product-configuration">
 <!-- Product Color -->
      <div class="product-color">
        <span>Color</span>

        <div class="color-choose">
          <div>
            <input data-image="red" type="radio" id="red" name="color" value="red" checked>
            <label for="red"><span></span></label>
          </div>
          <div>
            <input data-image="blue" type="radio" id="blue" name="color" value="blue">
            <label for="blue"><span></span></label>
          </div>
          <div>
            <input data-image="black" type="radio" id="black" name="color" value="black">
            <label for="black"><span></span></label>
          </div>
        </div>

      </div>
      <!-- Cable Configuration -->
      <div class="cable-config">
        <span>Cable configuration</span>
        <div class="cable-choose">
          <button>Straight</button>
          <button>Coiled</button>
          <button>Long-coiled</button>
        </div>

        <a href="#">How to configurate your headphones</a>
      </div>
    </div>
    <!-- Product Pricing -->
    <div class="product-price">
      <span>₹ 90,999</span>
      <a href="#" class="cart-btn">Add to cart</a>
    </div>
  </div>

</main>
</template>
<script>
export default {
  name: 'productDetails'
}
</script>

<style scoped>
/* body {
  height: 100%;
  width: 100%;
  margin: 0;
  font-family: 'Roboto', sans-serif;
} */

.productDetails {
  max-width: 1000px;
  margin: 0 auto;
  padding: 15px;
  display: flex;
}
/* Columns */
.left-column {
  width: 65%;
  position: relative;
}

.right-column {
  width: 35%;
  margin-top: 60px;
}
/* Left Column */
.left-column img {
  width: 100%;
  position: absolute;
  left: 0;
  top: 0;
  opacity: 0;
  transition: all 0.3s ease;
}

.left-column img.active {
  opacity: 1;
}
/* Product Description */
.product-description {
  border-bottom: 1px solid #E1E8EE;
  margin-bottom: 20px;
}
.product-description span {
  font-size: 12px;
  color: #358ED7;
  letter-spacing: 1px;
  text-transform: uppercase;
  text-decoration: none;
}
.product-description h1 {
  font-weight: 300;
  font-size: 52px;
  color: #43484D;
  letter-spacing: -2px;
}
.product-description p {
  font-size: 16px;
  font-weight: 300;
  color: #86939E;
  line-height: 24px;
}
/* Product Color */
.product-color {
  margin-bottom: 30px;
}
.color-choose div {
  display: inline-block;
}

/* Cable Configuration */
.cable-choose {
  margin-bottom: 20px;
}

.cable-choose button {
  border: 2px solid #E1E8EE;
  border-radius: 6px;
  padding: 13px 20px;
  font-size: 14px;
  color: #5E6977;
  background-color: #fff;
  cursor: pointer;
  transition: all .5s;
}

.cable-choose button:hover,
.cable-choose button:active,
.cable-choose button:focus {
  border: 2px solid #86939E;
  outline: none;
}

.cable-config {
  border-bottom: 1px solid #E1E8EE;
  margin-bottom: 20px;
}

.cable-config a {
  color: #358ED7;
  text-decoration: none;
  font-size: 12px;
  position: relative;
  margin: 10px 0;
  display: inline-block;
}

/* Product Price */
.product-price {
  display: flex;
  align-items: center;
}

.product-price span {
  font-size: 26px;
  font-weight: 300;
  color: #43474D;
  margin-right: 20px;
}

.cart-btn {
  display: inline-block;
  background-color: orange;
  border-radius: 6px;
  font-size: 16px;
  color: #FFFFFF;
  text-decoration: none;
  padding: 12px 30px;
  transition: all .5s;
}
.cart-btn:hover {
  background-color: #5F9EA0;
}
</style>
