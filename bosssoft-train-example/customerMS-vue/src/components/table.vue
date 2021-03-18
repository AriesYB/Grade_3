<template>
  <div>
    <p v-if="empty">{{message}}</p>
    <div class="right">
      <input class="btn" type="button" value="添加" @click="showAdd" />
      <input class="btn" type="button" value="删除" @click="remove" />
    </div>
    <table v-if="!empty">
      <caption>客户信息列表</caption>
      <thead>
        <tr>
          <th scope="row">客户ID</th>
          <th scope="row">姓名</th>
          <th scope="row">性别</th>
          <th scope="row">年龄</th>
          <th scope="row">电话号码</th>
          <th scope="row">地址</th>
          <th scope="row">修改</th>
        </tr>
      </thead>
      <tbody v-for="(item,index) in data" :key="item.id">
        <tr @click="select(item.id,$event)">
          <td>{{item.id}}</td>
          <td>{{item.name}}</td>
          <td>{{item.sex}}</td>
          <td>{{item.age}}</td>
          <td>{{item.phone}}</td>
          <td>{{item.address}}</td>
          <td>
            <input
              type="button"
              value="修改"
              class="btn btn-change"
              @click.stop="showModify(item.id,index)"
            />
          </td>
        </tr>
      </tbody>
    </table>
    <v-add :show="addStatus"></v-add>
    <v-modify :show="modifyStatus" :data="modifyData"></v-modify>
  </div>
</template>

<script>
import vAdd from "./add";
import vModify from "./modify";

export default {
  name: "v-table",
  components: {
    vAdd,
    vModify
  },
  //组件的属性
  props: {
    message: {
      type: String,
      default: "空"
    },
    data: {
      type: [Object, Array],
      default: () => {}
    },
    empty: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      selectedId: new Set(),
      deletedId: [],
      addStatus: false,
      modifyStatus: false,
      modifyData: {}
    };
  },
  methods: {
    select(id, $event) {
      let set = this.$data.selectedId;
      if (set.has(id)) {
        set.delete(id);
        $event.currentTarget.className = "";
      } else {
        set.add(id);
        $event.currentTarget.className = "selected";
      }
    },
    showAdd() {
      this.$data.addStatus = true;
    },
    //子组件调用这个方法，由于数据单向流动所以子组件不能直接修改prop的值
    hiddenAdd() {
      this.$data.addStatus = false;
    },
    showModify(id, index) {
      this.$data.modifyData = this.data[index];
      this.$data.modifyStatus = true;
    },
    hiddenModify() {
      this.$data.modifyStatus = false;
    },
    add(data) {
      this.$axios({
        method: "post",
        url: "/saveCustomer",
        data: data
      })
        .then(result => {
          if (result.data) {
            alert("添加成功");
            this.$router.go(0);
          } else {
            alert("添加失败");
          }
        })
        .catch(err => {
          alert("添加错误!");
        });
    },
    remove() {
      let set = this.$data.selectedId;
      let deletedId = this.$data.deletedId;
      if (set.size === 0) {
        alert("请选择至少一行后删除!");
      } else {
        for (let it of set) {
          this.data.forEach(function(item, index, arr) {
            if (item.id === it) {
              arr.splice(index, 1);
            }
          });
          deletedId.push(it);
          set.delete(it);
        }
        if (deletedId.length === 1) {
          this.$axios({
            method: "post",
            url: "/removeCustomer",
            data: "id=" + deletedId[0]
          })
            .then(result => {
              if (result.data === false) {
                alert("删除失败!");
                this.$router.go(0);
              } else {
                alert("删除成功");
              }
            })
            .catch(err => {
              alert("删除错误!");
              this.$router.go(0);
            });
        } else if (deletedId.length > 1) {
          this.$axios({
            method: "post",
            url: "/removeCustomerList",
            data: deletedId
          })
            .then(result => {
              alert("删除成功!");
              this.$router.go(0);
            })
            .catch(err => {
              alert("删除错误!");
              this.$router.go(0);
            });
        }
      }
    },
    modify(data) {
      this.$axios({
        method: "post",
        url: "/updateCustomer",
        data: data
      })
        .then(result => {
          alert("修改成功!");
          this.$router.go(0);
        })
        .catch(err => {
          alert("修改错误!");
          this.$router.go(0);
        });
    }
  }
};
</script>

<style>
.right {
  margin-left: 85%;
  margin-bottom: 10px;
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

.btn-change {
  margin-bottom: 0 !important;
}

table {
  border-collapse: collapse;
  width: 100%;
  margin-bottom: 1rem;
  color: #212529;
}
table th,
table td {
  padding: 0.75rem;
  vertical-align: top;
  border: 1px solid #000;
}

table thead th {
  vertical-align: bottom;
  border: 1px solid #000;
}

table tbody + tbody {
  border: 1px solid #000;
}

tr:hover {
  background-color: #cfcfcf;
}

.selected {
  background-color: darkgray !important;
}
</style>