<template>
    <main class="apple">
        <img class="apple__image" src="https://www.pngkey.com/png/detail/24-241942_apple-ipad-logo-png-download-apple-logo-with.png" alt=""/>
        <!-- <ProductRow :category="apple"/> -->
    </main>
</template>

<script>
// for second method: api call again for apple products
export default {
  name: 'Apple'
}
</script>

<style scoped>

.apple__image {
flex-grow: 1;
max-height: 150px;
max-width: 100%;
padding: 15px;
}

</style>
