
<template>
  <div class="home">
    <div class="home__container">
      <img class="home__image
      " src="https://assets.awwwards.com/awards/images/2020/10/ecommerce-trends-cover.jpg" alt=""/>
      <header>Top Selling Products</header>
      <div class="home__row">
      <ProductRow :category="all" />
      <!-- api call for home component and instead of categories send item -->
      <!-- axios.get('url').then((res) => {items=res}) -->
      <!-- response would be redirected to the product row -->
      </div>
    </div>
  </div>
</template>

<script>
import ProductRow from '../components/ProductRow.vue'
// @ is an alias to /src
// import Header from '@/components/Header'
// import SearchIcon from '@material-ui/icons/Search';
// import Product from '../views/About.vue'

export default {
  name: 'homevue',
  // name: 'products'
  components: {
    ProductRow
  }
}
</script>

<style scoped>

.home {
  display: flex;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
  max-width: 1500px;
}

.home__row {
  display: flex;
  z-index: 1;
  margin-bottom: 89px;
  margin-left: 5px;
  margin-right: 5px;
}

.home__image{
  width: 100%;
  height: 450px;
  z-index: -1;
  margin-bottom: -80px;
  mask-image: linear-gradient(to bottom, rgb(19, 194, 107), rgba(18, 218, 208, 0));
}

header {
    border-bottom: solid 2px black;
    font-size: x-large;
    padding: 40px;
    font-weight: 500;
    margin: 0px 35px;
}

</style>
