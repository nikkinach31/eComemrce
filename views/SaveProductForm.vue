<template>
  <form>
    <div class="form-group">
      <label for="productName">Product name</label>
      <input type="text" v-model="product.name" class="form-control" id="productName" maxlength="32" placeholder="Enter product name">
    </div>
    <div class="form-group">
      <label for="price">Price</label>
      <input type="number" v-model="product.price" class="form-control" id="price" placeholder="Enter Price" number>
    </div>
    <div class="form-group">
      <label for="quantity">Quantity</label>
      <input type="number" v-model="product.quantity" class="form-control" id="quantity" placeholder="Enter Quantity" number>
    </div>
    <div class="form-group">
      <label for="productDescription">Specifications <small class="text-muted">(optional)</small></label>
      <textarea class="form-control" v-model="product.description" id="productDescription" rows="3" maxlength="128" placeholder="Enter description"></textarea>
    </div>

    <div class="form-group">
      <label for="Add Picture">Upload</label>
      <input type="file" class="form-control" id="imageUpload" width="110px" height="110px">
    </div>
    <button type="submit" v-on:click.prevent="onSubmit" class="btn btn-primary">Save product</button>
  </form>
</template>
<script>
// import UploadButton from 'vuetify-upload-button';
export default {
  // 'upload-btn': UploadButton,
  props: ['product'],
  methods: {
    onSubmit () {
      this.$emit('submit', this.product)
    }
  }
}
</script>
<style scoped>
.form-group{
  width:750px;
  text-align: left;
}
.btn:not(:disabled):not(.disabled) {
  margin-right: 500px;;
}
</style>
