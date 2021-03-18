<template>
  <div :class="classObject">
    <div class="cover"></div>
    <div class="content">
      <div class="head">
        <!--弹窗头部 title-->
        <h4 name="header">添加客户</h4>
      </div>
      <div class="main">
        <!--弹窗的内容-->
        <div class="row">
          <label>姓名</label>
          <input type="text" v-model="customer.name" />
        </div>
        <div class="row">
          <label>性别</label>
          <select v-model="customer.sex">
            <option disabled value>请选择</option>
            <option>男</option>
            <option>女</option>
          </select>
        </div>
        <div class="row">
          <label>年龄</label>
          <input type="number" v-model="customer.age" />
        </div>
        <div class="row">
          <label>电话</label>
          <input type="text" v-model="customer.phone" />
        </div>
        <div class="row">
          <label>地址</label>
          <input type="text" v-model="customer.address" />
        </div>
      </div>
      <!--弹窗按钮-->
      <div class="close" @click="close">
        <input class="btn" type="button" value="保存" @click="store" />
        <input class="btn" type="button" value="取消" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "v-add",
  props: {
    show: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      customer: {}
    };
  },
  methods: {
    close() {
      this.$parent.hiddenAdd();
    },
    store() {
      this.$parent.add(this.$data.customer);
    }
  },
  computed: {
    // 可以直接用vif
    classObject: function() {
      return {
        show: this.show,
        hidden: !this.show
      };
    }
  }
};
</script>

<style>
/* 遮罩层 */
.cover {
  background: rgba(0, 0, 0, 0.8);
  position: fixed;
  z-index: 200;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.content {
  z-index: 999;
  position: absolute;
  top: 25%;
  right: 30%;
  background-color: whitesmoke;
  width: 600px;
  height: 350px;
}
.head {
  margin-right: 80%;
}
.close {
  margin-top: 40%;
}

.show {
  display: block;
}
.hidden {
  display: none;
}
.row {
  clear: both;
  float: left;
  margin-top: 5px;
  margin-bottom: 5px;
  margin-left: 35%;
}
</style>