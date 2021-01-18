<template>
  <div class="panel">
    <div class="header">
      <a href="/">
          <img class="header__logo"
            src="" alt="logo"/>
      </a>
          <div class="header__search">
            <input class="header__searchInput"
              type="text" placeholder="Search for products"/>
            <a href="/noProductFound"><i class="material-icons">search</i></a>
          </div> <div class="header__nav">
            <div class="header__option">
              <span class="header__optionLineOne">Hello Guest</span>
              <a class="log" href="/login"><span class="header__optionLineTwo">Sign-in</span></a>
            </div>
            <a href="/checkout">
            <div class="header__option">
              <span class="header__optionLineTwo"><i class="material-icons shopping__cart">shopping_cart</i></span>
            </div>
            </a>
            <a href="/checkout">
            <div class="header__optionBasket">
              <span class="header__optionLineTwo header__basketCount">0</span>
            </div>
            </a>
          </div>
        </div>
          <div class="categories">
            <span class="all__categories">All categories</span>
            <div class="categoriesName">
              <a href="./Apple"><span class="apple">Apple</span></a>
              <a href="./OnePlus"><span class="apple">OnePlus</span></a>
              <a href="./Samsung"><span class="apple">Samsung</span></a>
              <a href="./Sony"><span class="apple">Sony</span></a>
              <a href="./xiaomi"><span class="apple">Xiaomi</span></a>
              <a href=""><span class="tagline">SALE! SALE! SALE!</span></a>
            </div>
          </div>
  <nav id="nav">
    <router-link class="nav-item" to="/xiaomi"></router-link>
    <router-link class="nav-item" to="/apple"></router-link>
    <router-link class="nav-item" to="/samsung"></router-link>
    <router-link class="nav-item" to="/onePlus"></router-link>
    <router-link class="nav-item" to="/sony"></router-link>
  </nav>
  </div>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>

.header {
  height: 60px;
  display: flex;
  align-items: center;
  background-color: #5F9EA0;
  position: sticky;
  top: 0;
  z-index: 100;
}

.header__logo {
  width: 100px;
  object-fit: contain;
  margin: 0 20px;
  margin-top: 10px;
}

.header__search {
  display: flex;
  flex: 1;
  align-items: center;
  border-radius: 24px;
}

.header__searchInput {
  height: 12px;
  padding: 15px;
  border: none;
  width: 100%;
}

.material-icons {
  padding: 3px;
  height: 31px !important;
  background-color: orange;
  margin-top: 3px;
}

.header__optionLineOne {
  font-size: 10px;
}

.header__optionLineTwo {
  font-size: 15px;
  font-weight: 800;
}
.log a:link {
  text-decoration: none;
}

.header__optionBasket {
  display: flex;
  align-items: center;
  margin-top: 10px;
  margin-right: 10px;
  color: white;
}

.shopping__cart {
  display: flex;
  align-items: center;
}

.header__nav {
  display: flex;
  justify-content: space-evenly;
}

.header__option {
  display: flex;
  flex-direction: column;
  margin-left: 10px;
  margin-right: 10px;
  color: white;
}

.categories {
  height: 60px;
  display: flex;
  flex: 1;
  align-items: center;
  background-color: #ADD8E6;
  position: sticky;
  top: 20px;
  z-index: 100;
}

.apple {
  display: flex;
  flex: 1;
  /* font-size: 10px; */
  font-weight: 800;
  /* margin-right: 50px; */
  align-items: center;
  /* margin-left: 50px; */
  color: white;
  filter: drop-shadow(0px 0px 7px rgba(150, 150, 150, .7));
}

a:link {
  text-decoration: none;
}

.categoriesName {
  display: flex;
  flex: 1;
  justify-content: space-between;
  flex-wrap: wrap;
  align-items: center;
  color: hsl(0, 0%, 96%);
  flex-direction: row;
  padding-left: 35px;
  /* margin-left: 10px;
  margin-right: 10px; */
}

.all__categories {
  display: flex;
  font-size: 20px;
  margin-left: 28px;
  align-items: center;
}

.tagline {
  display: flex;
  /* flex: 1; */
  flex-direction: row;
  align-items: center;
  font-family: sans-serif;
  /* margin-left: px; */
  font-size: 35px;
  color: black;
}

/* .nav {
  padding: 10px;
}

.nav-item {
  padding: 10px;
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

.nav-item:hover {
  background-color:  #2c3e50;
  color: #42b983;
}

.nav-item.router-link-exact-active {
  text-decoration: underline;
  text-underline-offset: 10px;
} */

</style>
