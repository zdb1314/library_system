import Vue from 'vue'
import Router from 'vue-router'
import BookList from '@/components/BookList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BookList',
      component: BookList
    }
  ]
})
