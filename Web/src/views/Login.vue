<template>
    <div class="vue-te">
        <form class="form">
            <div>
            <h3>Log in to continue.</h3>

            <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control form-control-lg" placeholder="Enter Email"/>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control form-control-lg" placeholder="Enter password"/>
            </div>
            <button type="submit" class="btn btn-warning btn-lg btn-block">LOG IN</button>
            <p>
            </p>
            </div>
            <div class="social-icons">
                <ul>
                    <li><a href=""><i class="fa fa-google"></i></a></li>
                    <li><a href=""><i class="fa fa-facebook"></i></a></li>
                </ul>
            </div>
            <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/Registration">New User ?</router-link>
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
<style scoped>

.vue-te {
    padding: 40px;
    width: 100%;
    height: 60%;
    align-items: center;
    justify-content: center;
}

.form {
    align-items: center;
    width: 80%;
    height: 80%;
    padding: 70px;
    border: 1px solid black;
    justify-content: center;
    background-color: white;
    margin-left: 110px;
}

</style>
