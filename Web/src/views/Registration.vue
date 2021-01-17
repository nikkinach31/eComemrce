<template>
 <div class="vue-tempalte">
 <form class="form-sty">
 <h3>Register here!</h3>
 <div class="form-group">
 <label>Full Name</label>
 <input type="text" class="form-control form-control-lg" placeholder="Enter your name"/>
 </div>
 <div class="form-group">
 <label>Email address</label>
 <input type="email" class="form-control form-control-lg" placeholder="Enter Email"/>
 </div>

 <div class="form-group">
 <label>Password</label>
 <input type="password" class="form-control form-control-lg" placeholder="Enter password"/>
 </div>

 <button type="submit" class="btn btn-warning btn-lg btn-block">Sign Up</button><br>
 <p>OR</p>
 <div class="social-icons">
 <ul>
 <li><a href=""><button v-google-signin-button="clientId" class="google-signin-button"> <img src="https://img-authors.flaticon.com/google.jpg" height="40px"/> Continue with Google</button></a></li>
 </ul>
 </div>
 <p>
 </p>
 <p class="forgot-password text-right" style="align-right">
 Already registered
 <router-link to= "/login">sign in?</router-link>
 </p>
 </form>
 </div>
</template>

<script>
import GoogleSignInButton from 'vue-google-signin-button-directive'
export default {
  directives: {
    GoogleSignInButton
  },
  data () {
    return {
      clientId: 'Your_Google_Client-Id'
    }
  },
  methods: {
    OnGoogleAuthSuccess (idToken) {
      // Receive the idToken and make your magic with the backend
    },
    OnGoogleAuthFail (error) {
      console.log(error)
    }
  }
}
</script>
<style>
.google-signin-button {
 color:red;
 width: 190px;
 font-size: 14px;
 border-radius: 10px;
 /* padding: 10px; */
 box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
 justify-content: center;
 margin-left: -50px;
 background: white;
 border: 1px solid palevioletred
}
</style>
