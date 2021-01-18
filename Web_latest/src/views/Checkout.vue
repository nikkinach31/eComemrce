<template>
  <main class="checkout">
     <div class="checkout__left">
        <img class="checkout__ad" src="https://webmarketingtips.mx/wp-content/uploads/668des-1-1170x395.jpg" alt=""/>
        <div>
            <h2 class="checkout__title">Your Shopping Basket</h2>
            <!-- basket item -->
            <!-- basket item -->
        </div>
     </div>
     <div class="checkout__right">
         <Subtotal />
     </div>
  </main>
</template>

<script>
import Subtotal from '../views/Subtotal.vue'
export default {
  name: 'Checkout',
  components: {
    Subtotal
  }
}
</script>

<style scoped>

.checkout{
    display: flex;
    padding: 15px;
    background-color:white;
    height: max-content;
}
.checkout__ad {
    width: 100%;
    margin-bottom: 10px;
    height: 350px;
}

.checkout__title {
    margin-right: 10px;
    padding: 10px;
    border-bottom: 1px solid lightgray;
}

</style>
