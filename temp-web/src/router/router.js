import {createRouter, createWebHashHistory} from 'vue-router';

import Login from '../components/Login.vue';
import Register from '../components/Register.vue';
import ShowSchedules from '../components/ShowSchedules.vue';
import pinia from './../utils/pinia';
import { defineUser } from '../store/userStore';

let sysUser = defineUser(pinia);
let router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: "/",
      redirect: '/show'
    },
    {
      path: "/show",
      component: ShowSchedules
    },
    {
      path: "/login",
      component: Login
    },
    {
      path: "/register",
      component: Register
    }
  ]
});

router.beforeEach(
  (to, from, next) => {
    if(to.path == "/show"){
      if(sysUser.username === ""){
        next("/login");
      } else {
        next();
      }
    } else {
      next();
    }
  }
);

export default router;

