<template>
  <div>
    <div class="input">
      <input type="text" v-model="id" placeholder="请输入ID" />
    </div>
    <div class="input">
      <input type="password" v-model="password" placeholder="请输入密码" />
    </div>
    <div>
      <button v-on:click="login" class="btn">登录</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      id: "",
      password: "",
      responseResult: []
    };
  },
  methods: {
    login() {
      this.$axios({
        method: "post",
        url: "/login",
        data: "id=" + this.$data.id + "&password=" + this.$data.password
      })
        .then(result => {
          if (result.data == true) {
            alert("登录成功");
            this.$router.push({
              path: "/list"
            });
          } else {
            alert("账号或密码错误");
            this.$router.go(0);
          }
        })
        .catch(err => {
          alert("登录失败");
          this.$router.go(0);
        });
    }
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  list-style: none;
}
#app {
  width: 300px;
  margin: 100px auto;
}
.input {
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border-radius: 0.25rem;
}
.btn {
  width: 80px;
  height: 35px;
  background-color: #ffffff;
  border: 1px solid;
  display: inline-block;
  font-weight: 400;
  padding: 6px 9px;
  vertical-align: middle;
  font-size: 1rem;
  line-height: 1.5;
  box-shadow: none !important;
  -webkit-box-shadow: none !important;
}
.btn:focus {
  outline: none;
}
.btn:hover {
  cursor: pointer !important;
  background-color: #5b72f2;
  border-color: #5b72f2;
  color: white;
}
</style>