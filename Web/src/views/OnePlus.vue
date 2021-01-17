<template>
    <main class="onePlus">
        <img class="onePlus__image" src="https://www.gadgetdetail.com/wp-content/uploads/2017/06/oneplus-logo.png" alt=""/>
        <h3>Never Settle</h3>
    </main>
</template>

<script>
export default {
  name: 'OnePlus'
}
</script>

<style scoped>

.onePlus__image {
flex-grow: 1;
max-height: 150px;
max-width: 100%;
padding: 15px;
}

.onePlus h3 {
  width: 300px;
  border: 2px solid black;
  padding: 1px;
  margin-top: -10px;
  left: 40%;
  position: fixed;
}

</style>
