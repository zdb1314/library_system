import request from '@/utils/request.js'
 
/**
 *  获取图书列表
 */
export const getBookList = (data) => {
  return request({
    url: '/book/list',
    method: 'POST',
    data
  })
}
 
 /**
 *  获取图书详情
 */
export const getBook = (id) => {
    return request({
      url: `/book/get/${id}`,
      method: 'GET'
    })
  }

   
/**
 *  新增图书
 */
export const addBook = (data) => {
    return request({
      url: '/book/add',
      method: 'POST',
      data
    })
  }


   
/**
 *  更新图书
 */
export const updateBook = (data) => {
  return request({
    url: '/book/update',
    method: 'POST',
    data
  })
}   

/**
 *  删除图书
 */
export const removeBook = (data) => {
  return request({
    url: '/book/delete',
    method: 'POST',
    data
  })
}