<template>
  <main class="productvue">
    <div v-for="(item,index) in items" :key="index">
      <Product :img="item.img" :title="item.title" :price="item.price" />
    </div>
  </main>
</template>

<script>
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Product from '../views/Product.vue'
Vue.use(VueAxios, axios)
export default {
  components: {
    Product
  },
  props: {
    category: Number
  },
  // PRops categories

  // make an api call on change of category to fetch new items
  // axios.get('url'+'?categories='+props.category).then((res) => {items=res})
  data: () => ({
    items: [
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      },
      {
        img:
          'https://images-na.ssl-images-amazon.com/images/I/71MHTD3uL4L._SL1500_.jpg',
        title: 'Iphone 12 max pro',
        price: '90999'
      }
    ]
  })
  // mounted () {
  //   axios.get('')
  //     .then(res => {
  //       this.items = res
  //       console.warn(res)
  //       console.log('its coming')
  //     }
  //     )
  // }
}
</script>

<style scoped>

.productvue {
display: flex;
flex-direction: row;
flex-wrap: wrap;
justify-content: space-evenly;
width: 100%;
}

</style>
