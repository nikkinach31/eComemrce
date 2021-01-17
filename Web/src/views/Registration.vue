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
                <input type="email" class="form-control form-control-lg"  placeholder="Enter Email"/>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" placeholder="Enter password"/>
            </div>

            <button type="submit" class="btn btn-warning btn-lg btn-block">Sign Up</button>
            <p></p>
            <div class="social-icons">
                <ul>
                    <li><a href=""><i class="fa fa-google"></i></a></li>
                    <li><a href=""><i class="fa fa-facebook"></i></a></li>
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
export default {
  data () {
    return {
    }
  }
}
</script>
