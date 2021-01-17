import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
// import Product from '..views/Product.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/addToCart',
    name: 'AddToCart',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "addToCart" */ '../views/AddToCart.vue')
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "login" */ '../views/Login.vue')
  },
  {
    path: '/cart',
    name: 'Cart',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "login" */ '../views/Cart.vue')
  },
  {
    path: '/registration',
    name: 'Registration',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "login" */ '../views/Registration.vue')
  },
  {
    path: '/product',
    name: 'Product',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "product" */ '../views/Product.vue')
  },
  {
    path: '/apple',
    name: 'Apple',
    component: () => import(/* webpackChunkName: "apple" */ '../views/Apple.vue')
  },
  {
    path: '/onePlus',
    name: 'OnePlus',
    component: () => import(/* webpackChunkName: "onePlus" */ '../views/OnePlus.vue')
  },
  {
    path: '/samsung',
    name: 'Samsung',
    component: () => import(/* webpackChunkName: "samsung" */ '../views/Samsung.vue')
  },
  {
    path: '/sony',
    name: 'Sony',
    component: () => import(/* webpackChunkName: "sony" */ '../views/Sony.vue')
  },
  {
    path: '/xiaomi',
    name: 'Xiaomi',
    component: () => import(/* webpackChunkName: "xiaomi" */ '../views/Xiaomi.vue')
  },
  {
    path: '/checkout',
    name: 'Checkout',
    component: () => import(/* webpackChunkName: "checkout" */ '../views/Checkout.vue')
  },
  {
    path: '/productdetails',
    name: 'ProductDetails',
    component: () => import(/* webpackChunkName: "productdetails" */ '../views/ProductDetails.vue')
  },
  {
    path: '/noProductFound',
    name: 'NoProductFound',
    component: () => import(/* webpackChunkName: "p-components" */ '../views/NoProductFound.vue')
  },
  {
    path: '/components',
    name: 'Components',
    component: () => import(/* webpackChunkName: "p-components" */ '../views/Components.vue')
  },
  {
    path: '/router',
    name: 'Router',
    component: () => import(/* webpackChunkName: "p-router" */ '../views/Router.vue')
  },
  {
    path: '/vuex/:genre?',
    name: 'Vuex',
    component: () => import(/* webpackChunkName: "p-vuex" */ '../views/Vuex.vue')
  },
  {
    path: '*',
    name: 'Error',
    component: () => import(/* webpackChunkName: "p-components" */ '../views/Error.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
