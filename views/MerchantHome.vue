<template>
    <div class="product1">
        <div class="product-card">
        <div v-for="item in items" v-bind:key="item.id" class="wrap-products">
            <div class="product-info">
                <div class="item1">{{item.name}}</div>
                <div class="item">{{item.price}}</div>
                <div class="item">{{item.quantity}}</div>
                <div class="item">{{item.specs}}</div>
                <div class="product-img">
                <img v-bind:src= 'item.url' width="150px" height="150px" alt="">
                </div>
                <br>
                <button id="show-modal" class="button1" @click="editProducts(item)">Edit</button>
            </div>
            </div>
        </div>
        <!-- </span> -->
        <Modal v-if="showModal" @close="showModal = false">
            <h3 slot="header"> Edit
            </h3>
            <div slot="body" class="name">
                <label>Name</label> <br> <input label="Name" value="" v-model="editing.name"/><br>
                <label>Price</label> <br> <input type="number" value="" v-model="editing.price"/><br>
                <label>Quantity</label> <br> <input type ="number" value="" v-model="editing.quantity"/><br>
                <label>Specifications</label> <br> <input value="" v-model="editing.specs"/><br>
            </div>
        </Modal>
        </div>
</template>

<script>
import Modal from '../components/Modal'

export default {
  name: 'MerchantHome',
  components: {
    Modal
  },
  data () {
    return {
      showModal: false,
      items: [{
        id: '1',
        name: 'Apple iPhone 7 (32GB) - Black',
        price: 6700,
        quantity: 12,
        specs: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip',
        url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg'
      },
      {
        id: '2',
        name: 'Samsung S9',
        price: 6700,
        quantity: 12,
        specs: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip',
        url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg'
      },
      {
        id: '2',
        name: 'Samsung S9',
        price: 6700,
        quantity: 12,
        specs: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip',
        url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg'
      },
      {
        id: '2',
        name: 'Samsung S9',
        price: 6700,
        quantity: 12,
        specs: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip',
        url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg'
      },
      {
        id: '2',
        name: 'Samsung S9',
        price: 6700,
        quantity: 12,
        specs: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip',
        url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg'
      }
      ],
      category: {
        apple: ['1'],
        samsung: ['2']
      },
      editing: null
    }
  },
  methods: {
    editProducts (item) {
      this.showModal = true
      this.editing = item
      console.log(this.editing)
    }
  }
}
</script>
<style scoped>
.name{
    justify-content: left;
    padding: 0px;
    margin-left: 2px;
    width:100%;
}

.name input {
    width: 100%;
}
.item1{
    font-weight: bold;
}

.product1{
  display: flex;
  flex-wrap: wrap;
  box-shadow: 0 0 15px 4px rgba(0,0,0,0.06);
  border-radius: 5px;
  justify-content: space-between;
}
.product-card {
  padding: 2%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  flex-wrap: wrap ;
  width:100vw;
}
.product-img {
  max-width: 100%;
}
.product-info {
  margin-top: auto;
  justify-content: space-between;
  border: 1px solid black;
  padding: 35px;
  margin:20px;
  flex-wrap: wrap;
  width: 400px;
}
.button1{
    display: inline-block;
        background-color: black;
        border-radius: 10px;
        border: 2px #cccccc;
        color: #eeeeee;
        text-align: center;
        font-size: 20px;
        width: 70px;
        transition: all 0.5s;
        cursor: pointer;
}
.products .product-card:first-child,
.products .product-card:nth-child(2) {
  flex: 2 46%;
}
@media (max-width: 600px) {
  .product-card {
    flex: 1 46%;
  }
}
</style>
