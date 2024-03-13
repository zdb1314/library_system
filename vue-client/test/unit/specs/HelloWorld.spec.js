import Vue from 'vue'
import BookList from '@/components/BookList'

describe('BookList.vue', () => {
  it('should render correct contents', () => {
    const Constructor = Vue.extend(BookList)
    const vm = new Constructor().$mount()
    expect(vm.$el.querySelector('.hello h1').textContent)
      .toEqual('Welcome to Your Vue.js App')
  })
})
