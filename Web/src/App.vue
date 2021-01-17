<template>
  <div id="app">
    <Header class=""/>
    <!-- <Product /> -->
    <router-view/>
    <!-- <Footer></Footer> -->
  </div>
</template>

<script>
import Header from './components/Header'
// import Footer from './components/Footer'
// import Product from './views/Product'
// import HomePage from './components/HomePage'

export default {
  name: 'App',
  components: {
    Header
    // Product
  },
  methods: {
    App () {
      return (
        <h1>how u'doing?</h1>
      )
    }
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
body {
  background: whitesmoke;
  padding: 0;
  margin: 0;
}

// color-green = #42b983
// color-blue = #2c3e50
</style>
