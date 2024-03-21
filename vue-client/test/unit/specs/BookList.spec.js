import Vue from 'vue'
import BookList from '@/components/BookList'
import MockAdapter from 'axios-mock-adapter'
import { mount } from '@vue/test-utils';
import {Message} from 'element-ui';
Vue.prototype.$message = Message;

let bookListResponse = {
  "code": 0,
  "msg": "操作成功",
  "data": [
    {
      "id": 1,
      "title": "红楼梦",
      "author": "曹雪芹",
      "remark": "《红楼梦》，别名《石头记》等"
    },
    {
      "id": 2,
      "title": "西游记",
      "author": "吴承恩",
      "remark": "《西游记》是明代吴承恩创作的中国古代"
    },
    {
      "id": 3,
      "title": "水浒传",
      "author": "施耐庵",
      "remark": "《水浒传》是元末明初施耐庵"
    }
  ]
}

let successResponse = {
  "code": 0,
  "msg": "操作成功"
}

let mock = new MockAdapter(Vue.prototype.$axios)

//模拟查询列表接口
mock.onPost('/book/list').reply(200,bookListResponse)

//模拟删除接口
mock.onPost('/book/delete').reply(config=>{
  return new Promise((resolve,reject)=>{
    //删除第一个数组
    bookListResponse.data.pop()
    resolve([200,successResponse])
  })
})

//模拟新增接口
mock.onPost('/book/add').reply(config=>{
  return new Promise((resolve,reject)=>{
    let book = JSON.parse(config.data);
    //添加数组
    book.id=new Date().getTime()
    bookListResponse.data.push(book)
    resolve([200,successResponse])
  })
})

//模拟获取图书接口
mock.onGet('/book/get/1').reply(config=>{
  return new Promise((resolve,reject)=>{
    let book = bookListResponse.data[0];
    resolve([200,{
      "code": 0,
      "msg": "操作成功",
      "data": book
    }])
  })
})

//模拟更新图书接口
mock.onPost('/book/update').reply(config=>{
  return new Promise((resolve,reject)=>{
    let book = JSON.parse(config.data);
    bookListResponse.data[0]=book;
    resolve([200,successResponse])
  })
})

describe('测试BookList.vue页面', () => {
  
  //挂载组件
  const wrapper = mount(BookList);

  it('测试查询列表功能',async ()=> {
    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))
    //获取tr组件
    let trs = wrapper.find("tbody").findAll("tr");
    //校验是否有3个tr组件
    expect(trs.length).toBe(3)
  })


  it('测试删除功能',async ()=> {
    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))
    //获取tr数量
    let length = wrapper.find("tbody").findAll("tr").length

    let delBtn = wrapper.find("tbody").find("tr").find(".delete-btn");
    await delBtn.trigger("click");

    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))

    //获取所有tr组件
    let trs = wrapper.find("tbody").findAll("tr")
    //校验tr数量是否减少了一个
    expect(trs.length).toBe(length-1)
  })


  it('测试新增功能',async ()=> {
    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))
    //获取新增按钮
    let addBtn = wrapper.find(".add-btn");
    await addBtn.trigger("click");
    
    let bookDialog = wrapper.find(".book-dialog")

    let titleInput = bookDialog.find(".title-input").find("input")
    titleInput.setValue("天龙八部")

    let authorInput = bookDialog.find(".author-input").find("input")
    authorInput.setValue("金庸")

    let remarkInput = bookDialog.find(".remark-input").find("textarea")
    remarkInput.setValue("是中国现代作家金庸创作的长篇武侠小说。这部小说从1963年9月开始创作并连载于《明报》")
    
    let saveBtn = bookDialog.find(".save-btn")
    saveBtn.trigger("click")

    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))

    //获取所有tr组件
    let trs = wrapper.find("tbody").findAll("tr");
    //获取最后一个数组
    let tr = trs.at(trs.length-1)
    //校验天龙八部是否添加成功
    expect(tr.text()).toContain("天龙八部")
  })


  it('测试修改功能',async ()=> {
    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))
    //获取新增按钮
    let editBtn = wrapper.find("tbody").find("tr").find(".edit-btn");
    await editBtn.trigger("click");
    
    let bookDialog = wrapper.find(".book-dialog")

    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))

    let titleInput = bookDialog.find(".title-input").find("input")
    titleInput.setValue("新红楼梦")

    let saveBtn = bookDialog.find(".save-btn")
    saveBtn.trigger("click")

    //延迟等待接口处理完
    await new Promise(res => setTimeout(res, 100))

    //获取所有tr组件
    let trs = wrapper.find("tbody").findAll("tr");
    //获取最后一个数组
    let tr = trs.at(0)
    //校验天龙八部是否添加成功
    expect(tr.text()).toContain("新红楼梦")
  })


})
