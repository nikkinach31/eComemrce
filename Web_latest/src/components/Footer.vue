<template>
 <div id="footer">
 <div id="container">
 <div id="contacts">
 <div id="contacts--contact">
 <p>{{ mail }}</p>
 <p>{{ phone }}</p>
 </div>
 <div id="contacts--social">
 <div><a href="#" class="fa fa-facebook"></a></div>
 <div><a href="#" class="fa fa-instagram"></a></div>
 <div><a href="#" class="fa fa-whatsapp"></a></div>
 </div>
 </div>
 <div id="mentions">
 <p>{{ mention }}</p>
 </div>
 </div>
 </div>
</template>
<script>
export default {
  Name: 'Footer',
  data () {
    return {
      mail: 'contact@phoneZ.com',
      phone: '+91-9876543210',
      mention: '2021 | PhoneZ'
    }
  }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css?family=Open+Sans');

body{
 display:flex;
 background-color:#F0F8FF;
 height:105vh;
 justify-content:center;
 align-items:flex-end;
 font-family:Open Sans;
}

#container{
 padding-top:20px;
 width:100vw;
 color:white;
 background-color:darkgray;
 display:flex;
 flex-direction:column;
 align-items:center;
 height: 100px;
}
#contacts{
 display:flex;
 justify-content:space-around;
 align-items:center;
 width:100%;
}
#contacts--contact{
 text-align:right;
}
#contacts--social{
 width:30px;
 display : flex;
 justify-content : space-between;
}
#contacts--social div{
 height:30px;
 width:30px;
 padding:20px;
 border-radius:80%;
}
#mentions p {
 font-size:1em;
}
#footer{
 left: 0;
 bottom: 0;
 position: fixed;
}
</style>
