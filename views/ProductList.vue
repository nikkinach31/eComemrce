<template>
  <table class="table table-hover product-table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Specifications</th>
        <th>Image</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in products" v-bind:key="product.id">
        <td>{{product.name}}</td>
        <td>{{product.price}}:-</td>
        <td>{{product.quantity}}</td>
        <td>{{product.specs}}</td>
        <td><img v-bind:src= 'product.url' width="150px" height="150px" alt=""></td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  props: ['products']
}
</script>
