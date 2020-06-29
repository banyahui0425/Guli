<template>
<div id="app_con">
  <el-table
    :data="pagelist"
    border
    style="width: 100%">
    <el-table-column
      
      prop="date"
      label="日期"
      width="150">
    </el-table-column>
    <el-table-column
      prop="uname"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="省份"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="市区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址"
      width="300">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="邮编"
      width="120">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>

 <el-pagination
   
      :page-size="pagecnt"
      layout="total, prev, pager, next"
      :total="pagetotal" 
      :current-page="pageidx">

</el-pagination>

    <!-- <table>
        <tr :key="item.id" v-for="(item,idx) in list">
            <td>{{idx+1}}</td>
            <td>{{item.uname}}</td>
            <td>{{item.pawd}}</td>
            <td>{{item.age}}</td>
            <td>{{item.email}}</td>
            <td>{{item.isDisabled}}</td>
            <td>{{item.isDeleted}}</td>
            <td>{{item.gmtCreate}}</td>
            <td>{{item.gmtUpdate}}</td>
        </tr>
    </table>
     -->
</div>
</template>
<script>
import { getlist,getpagelist } from '@/api/user/index'

export default {
    filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      pagelist: null,
      pagetotal:0,
      pageidx:1,
      pagecnt:1,
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true

      getlist().then(response => {
        this.list = response.result
        this.listLoading = false
      }).catch(function(error){
          console.log(error);
      })

      getpagelist(2,2).then(response => {

        console.log(response.result);

        this.pagelist = response.result.records;
        this.listLoading = false
        this.pagetotal=response.result.total
        console.log(this.pagetotal)
        this.pageidx=response.result.current
        console.log(this.pageidx)
        this.pagecnt=response.result.size
        console.log(this.pagecnt)
      }).catch(function(error){
          console.log(error);
      })

    }
  }
}
</script>
<style scoped>

</style>