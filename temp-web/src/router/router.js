import {createRouter, createWebHashHistory} from 'vue-router';

import Login from '../components/Login.vue';
import Register from '../components/Register.vue';
import ShowSchedules from '../components/ShowSchedules.vue';

let router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: "/",
      component: ShowSchedules
    },
    {
      path: "/showSchedules",
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

export default router;

