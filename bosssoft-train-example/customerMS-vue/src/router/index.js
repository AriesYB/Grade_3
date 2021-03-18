import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login';
import list from '../components/list';

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: login
    }
    ,
    {
      path: '/login',
      name: 'login',
      component: login
    }, {
      path: '/list',
      name: 'list',
      component: list
    }
  ]
})
