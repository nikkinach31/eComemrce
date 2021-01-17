<template>
  <section>
    <save-product-form
      :product="productInForm"
      v-on:submit="onFormSave"
    ></save-product-form>
    <product-list
      :products="products">
    </product-list>
  </section>
</template>
<script>
import uuid from 'uuid'
import ProductList from './ProductList'
import SaveProductForm from './SaveProductForm'

const initialData = () => {
  return {
    productInForm: {
      id: null,
      name: '',
      price: null,
      quantity: null,
      specs: '',
      file: ''
    },
    products: [{
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
    ]
  }
}

export default {
  components: {
    ProductList,
    SaveProductForm
  },
  data: initialData,
  methods: {
    onFormSave (product) {
      product.id = uuid.v4()
      this.products.push(product)
      this.resetProductInForm()
    },
    resetProductInForm () {
      this.productInForm = initialData().productInForm
    }
  }
}
</script>
