<template>
  <main class="productDetails">
    <div class="left-column">
      <img data-image="black" src="" alt="" />
      <img data-image="blue" src="images/blue.png" alt="" />
      <img
        data-image="red"
        class="active"
        src="https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg"
        alt=""
      />
    </div>
    <!-- Right Column -->
    <div class="right-column">
      <!-- Product Description -->
      <div class="product-description">
        <span>Apple</span>
        <h1>Iphone 12 Max Pro</h1>
        <p>
          camera features: Digital Zoom, Auto Flash, Face detection, Touch to
          focus image resolution: 4000 x 3000 Pixels auto focus:Yes, Phase
          Detection autofocus, Dual Pixel autofocus
        </p>
      </div>
      <!-- Product Configuration -->
      <div class="product-configuration">
        <!-- Product Color -->
        <div class="product-color">
          <span>QTY</span>

          <div class="quantity">
            <div>
              <input
                type="number"
                id="red"
                name="QTY"
                value="red"
                checked
                placeholder="0"
              />
              <label for="red"><span></span></label>
            </div>
            <!-- <div>
            <input data-image="blue" type="radio" id="blue" name="color" value="blue">
            <label for="blue"><span></span></label>
          </div>
          <div>
            <input data-image="black" type="radio" id="black" name="color" value="black">
            <label for="black"><span></span></label>
          </div> -->
          </div>
        </div>
        <!-- Cable Configuration -->
        <div class="cable-config">
          <span>SOLD BY:</span>
          <div class="cable-choose">
            <button>Seller 1</button>
            <button>Seller 2</button>
            <button>Seller 3</button>
          </div>

          <!-- <a href="#">How to configurate your headphones</a> -->
        </div>
      </div>
      <!-- Product Pricing -->
      <div class="product-price">
        <span>₹ 90,999</span>
        <a href="#" class="cart-btn" @click="ax">Add to cart</a>
      </div>
    </div>
  </main>
</template>
<script>
// import Vue from 'vue'
import axios from 'axios'
// import VueAxios from 'vue-axios'
export default {
  name: 'productDetails',
  methods: {
    ax () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/cart/addToCart',
        data: {
          userId: '1',
          productId: '4',
          productName: 'iPhone 7',
          merchantId: '1',
          price: '90000',
          quantity: '2',
          imageURL:
            'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
          cartId: '1'
        }
      })
    }
  }
}
// methods: {
//   clickProducts() {
// axios.post('http://10.177.68.76:8000/cart/addToCart', {
//     userId: '1',
//     productId: '4',
//     productName: 'iPhone 7',
//     merchantId: '1',
//     price: '90000',
//     quantity: '2',
//     imageURL: 'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
//     cartId: '1'
// })
// .then((response) => {
//   console.log(response);
// }, (error) => {
//   console.log(error);
// })
// }
// }
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
  border-bottom: 1px solid #e1e8ee;
  margin-bottom: 20px;
}
.product-description span {
  font-size: 12px;
  color: #358ed7;
  letter-spacing: 1px;
  text-transform: uppercase;
  text-decoration: none;
}
.product-description h1 {
  font-weight: 300;
  font-size: 52px;
  color: #43484d;
  letter-spacing: -2px;
}
.product-description p {
  font-size: 16px;
  font-weight: 300;
  color: #86939e;
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
  border: 2px solid #e1e8ee;
  border-radius: 6px;
  padding: 13px 20px;
  font-size: 14px;
  color: #5e6977;
  background-color: #fff;
  cursor: pointer;
  transition: all 0.5s;
}

.cable-choose button:hover,
.cable-choose button:active,
.cable-choose button:focus {
  border: 2px solid #86939e;
  outline: none;
}

.cable-config {
  border-bottom: 1px solid #e1e8ee;
  margin-bottom: 20px;
}

.cable-config a {
  color: #358ed7;
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
  color: #43474d;
  margin-right: 20px;
}

.cart-btn {
  display: inline-block;
  background-color: orange;
  border-radius: 6px;
  font-size: 16px;
  color: #ffffff;
  text-decoration: none;
  padding: 12px 30px;
  transition: all 0.5s;
}
.cart-btn:hover {
  background-color: #5f9ea0;
}
</style>
