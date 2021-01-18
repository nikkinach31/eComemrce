<template>
<div class="add-to-cart">
<button class="btn btn-primary" @click="addToCart">Add to Cart</button>
</div>
</template>
<script>
export default {
  name: 'AddToCart',
  props: {
    name: String,
    price: String,
    productId: String
  },
  data () {
    return {
      item: {
        productName: this.name,
        productPrice: this.price,
        product_id: this.id,
        productQuantity: 1
      }
    }
  },
  methods: {
    addToCart () {
      this.$router.push('/checkout')
      this.$store.commit('addToCart', this.item)
    }
  }
}
</script>
