<template>
  <div class="shop">
    <div v-for="item in items" v-bind:key="item[0]">
      <div>
          <button v-on:click="selectCategory(item.category)">{{item.category}}</button></div>
    </div>
    <div v-for="item in items" v-bind:key="item[0]" class="wrap-products">
        <span v-if='item.category == activeCategory'>
          <div v-for="product in item.products" v-bind:key="product[0]" >
            <div class="product">{{product.name}}</div>
            <img v-bind:src= 'product.url' width="80px" height="150px" alt="">
          </div>
        </span>
        <span v-if='activeCategory == ""'>
          <div v-for="product in item.products" v-bind:key="product[0]" >
            <div class="product">{{product.name}}</div>
          </div>
        </span>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      items: {
        1: {
          category: 'Apple',
          products: [{ name: 'Apple iPhone 7 (32GB) - Black', url: 'https://www.gizmochina.com/wp-content/uploads/2016/09/iphone7-plus-5-1-500x500.jpg', specification: '4.7-inch Retina HD LCD display, 7MP FaceTime HD camera with 1080p video, A10 Fusion chip' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' },
            { name: 'Apple iPhone 11 (64GB) - Black', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWgHnyP8JvECBficuzx5tQO3mAB_1qK12XHvttIiCzsCPCZq0h2rvJnEip47inOh5wEiGVsjg&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' },
            { name: 'Apple iPhone 11 Pro (512GB) - Space Grey', url: 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-11-pro-max-space-select-2019?wid=834&hei=1000&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1566953858806', specification: '5.8-inch (14.7 cm) Super Retina XDR OLED display' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A13 Bionic chip with third-generation Neural Engine' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' },
            { name: 'Apple iPhone 12 (128GB) - White', url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc', specification: '6.1-inch Super Retina XDR display, 12MP TrueDepth front camera with Night mode, 4K Dolby Vision HDR recording, A14 Bionic chip, the fastest chip ever in a smartphone' }
          ]
        },
        2: { category: 'Samsung', products: [{ name: 'S9', url: 'S10' }, 'Tablet'] }

      },
      activeCategory: ''
    }
  },
  methods: {
    selectCategory (val) {
      this.activeCategory = val
    }
  }
}
</script>

<style scoped>
    .product {
        width: 200px;
        height: 80px;
        background: pink;
        margin: 20px;
    }

    .wrap-products {
        width: 100vw;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
    }
</style>
