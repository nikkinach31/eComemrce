<template>
  <main class="productvue">
    <div v-for="(item,index) in items" :key="index">
      <Product :img="item.img" :title="item.title" :price="item.price" />
    </div>
  </main>
</template>

<script>
import Product from '../views/Product.vue'
export default {
  components: {
    Product
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
