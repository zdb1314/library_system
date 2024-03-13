<template>
  <div class="BookList">
    <div class="filter-container">
      <el-input v-model="keyword" placeholder="请输入id" style="width: 200px;" class="filter-item" @keyup.enter.native="searchBook" />
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="searchBook">
        搜索图书
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleAdd">
        新增图书
      </el-button>
    </div>
    <el-table
    :data="bookList"
    style="width: 100%">
    <el-table-column
      label="ID"
      prop="id">
    </el-table-column>
    <el-table-column
      label="标题"
      prop="title">
    </el-table-column>
    <el-table-column
      align="right">
      <template slot-scope="scope">
        <el-button
        type="primary"
          @click="handleEdit(scope.row)">编辑</el-button>
        <el-button
          type="danger"
          @click="handleDelete(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog title="图书信息" :visible.sync="dialogFormVisible">
    <el-form ref="dataForm" :rules="rules" :model="book" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
      <el-form-item label="ID" v-if="book.id">
        <el-input v-model="book.id" :disabled="true"/>
      </el-form-item>

      <el-form-item label="标题">
        <el-input v-model="book.title" placeholder="请输入标题" maxlength="50"/>
      </el-form-item>
      
      <el-form-item label="作者">
        <el-input v-model="book.author" placeholder="请输入作者" maxlength="50"/>
      </el-form-item>

      <el-form-item label="描述">
        <el-input v-model="book.remark" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="请输入描述" maxlength="256"/>
      </el-form-item>
    </el-form>

    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">
        取消
      </el-button>
      <el-button type="primary" @click="saveBook">
        保存
      </el-button>
    </div>
  </el-dialog>

 </div>



</template>

<script>
import { getBookList,addBook,updateBook,getBook,removeBook } from '@/apis/book.js'

export default {
  name: 'BookList',
  data () {
    return {
      bookList: [],
      keyword: '',
      dialogFormVisible: false,
      book:{}
    }
  },
  created(){
    this.searchBook();
  },
  methods: {
    /**
     * 新增图书
     */
    saveBook(){

      if(!this.book.title){
        this.$message('请输入标题');
      }

      if(!this.book.author){
        this.$message('请输入作者');
      }

      if(this.book.id){

        //更新
        updateBook(this.book)
          .then(res=>{
            if(res.code==0){

              this.$message('保存成功');

              //隐藏对话框
              this.dialogFormVisible=false;

              this.searchBook();

            }else{

              this.$message('保存失败');

            }
          })

      }else{

        //新增
        addBook(this.book)
          .then(res=>{
            if(res.code==0){
              this.$message('保存成功');
              
              //隐藏对话框
              this.dialogFormVisible=false;

              this.searchBook();

            }else{

              this.$message('保存失败');

            }
          })

      }
    },
    /**
     * 搜索
     */
     searchBook(){
        let params = {}

        if(this.keyword&&this.keyword.trim()!=''){
          params.id=this.keyword;
        }

        getBookList(params).then(res=>{
          console.log("getBookList",res)
          if(res.code==0){
            this.bookList=res.data;
          }
        });

     },
     /**
      * 新增图书
      */
     handleAdd(){
      this.book={}
      //显示对话框
      this.dialogFormVisible=true;
     },
     /**
      * 编辑图书
      * @param {*} row 
      */
     handleEdit(row) {
        console.log("handleEdit",row)

        getBook(row.id).then(res=>{
          if(res.code==0){
            this.book=res.data;
            //显示对话框
            this.dialogFormVisible=true;
          }
        })
        
      },
      /**
       * 删除图书
       * @param {*} row 
       */
      handleDelete(row) {
        console.log(row);
        removeBook({id:row.id}).then(res=>{
          if(res.code==0){
              this.$message('删除成功');
              
              this.searchBook();

            }else{

              this.$message('删除失败');

            }
          
        })
      }
    },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
