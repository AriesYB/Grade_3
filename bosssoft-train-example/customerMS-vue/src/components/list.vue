<template>
  <div>
    <v-table :empty="data.length==0" :message="'未查询到信息'" :data="data"></v-table>
  </div>
</template>

<script>
import vTable from "./table";

export default {
  name: "list",
  components: {
    vTable
  },
  data() {
    return {
      data: [],
    };
  },
  created() {
    this.$axios({
      method: "get",
      url: "/listCustomerAll"
    })
      .then(result => {
        if (result.data.length != 0) {
          this.$data.data = result.data;
        }
      })
      .catch(err => {
        alert("数据加载失败");
      });
  }
};
</script>

<style>
</style>