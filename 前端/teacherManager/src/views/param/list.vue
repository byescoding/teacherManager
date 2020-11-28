<template>
  <div class="app-container">
    <!--查询表单-->
    <el-form :inline="true">
      <el-form-item>
        <el-autocomplete
          v-model="searchObj.name"
          :fetch-suggestions="querySearch"
          :trigger-on-focus="false"
          class="inline-input"
          placeholder="课程名"
          value-key="name" />
          <!-- 注意  这里element 默认的key  是  value 如果要修改为其他的话需要   value-key-->
      </el-form-item>

      <!-- <el-form-item>
        <el-select v-model="searchObj.level" clearable placeholder="头衔">
          <el-option value=" " label=" "/>
          <el-option value="1" label="高级讲师"/>
          <el-option value="2" label="首席讲师"/>
        </el-select>
      </el-form-item> -->

      <el-form-item label="入驻时间">
        <el-date-picker
          v-model="searchObj.joinDateBegin"
          placeholder="开始时间"
          value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="-">
        <el-date-picker
          v-model="searchObj.joinDateEnd"
          placeholder="结束时间"
          value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form-item>

    </el-form>
    <!-- 工具按钮 -->
    <div style="margin-bottom: 10px">
      <el-button type="danger" size="mini" @click="batchRemove()">批量删除</el-button>
    </div>
    <!-- 表格 -->
    <el-table :data="list" border stripe @selection-change="handleSelectionChange" >
      <el-table-column type="selection" />
      <el-table-column width="70" align="center" label="#" >
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="单班课合班系数" prop="singleClass" width="250" />

      <el-table-column prop="doubleClass" label="双班课合班系数" width="250" />

      <el-table-column label="三班课合班系数" prop="threeClass" width="250" />

      <el-table-column prop="fourClass" label="四班课及以上合班系数" width="250" />

      <el-table-column label="重复班课合班系数" prop="repeatCourse" width="250" />

      <el-table-column prop="term" label="theoryStandardNumber" width="250" />

      <el-table-column label="理论课超额学生合班累加系数" prop="theoryExcessStudent" width="250" />

      <el-table-column prop="experimentRepeatCourse" label="实验课重复班课合班系数" width="250" />

      <el-table-column label="实验课单班分批进行的合班系数" prop="experimentClassBatch" width="250" />

      <el-table-column prop="experimentClassesBatch" label="实验课多班分批进行的合班系数" width="250" />

      <el-table-column label="上机课重复课双班合班系数" prop="operationRepeatDoubleClass" width="250" />

      <el-table-column prop="newCourse" label="开新课/新开课" width="250" />

      <el-table-column label="在西城校区开设的课程" prop="xichengCourse" width="250" />

      <el-table-column prop="grade13" label="13级教师岗位系数" width="250" />

      <el-table-column label="12级教师岗位系数" prop="grade12" width="250" />

      <el-table-column prop="grade11" label="11级教师岗位系数" width="250" />

      <el-table-column label="10级教师岗位系数" prop="grade10" width="250" />

      <el-table-column prop="grade9" label="9级教师岗位系数" width="250" />

      <el-table-column label="8级教师岗位系数" prop="grade8" width="250" />

      <el-table-column prop="grade7" label="7级教师岗位系数" width="250" />

      <el-table-column label="6级教师岗位系数" prop="grade6" width="250" />

      <el-table-column prop="grade5" label="5级教师岗位系数" width="250" />

      <el-table-column label="4级教师岗位系数" prop="grade4" width="250" />

      <el-table-column prop="grade3" label="3级教师岗位系数" width="250" />

      <el-table-column label="2级教师岗位系数" prop="grade2" width="250" />

      <el-table-column prop="practiceGuidance1Time" label="校内指导学时" width="250" />

      <el-table-column label="校内指导课程系数1（每周集体指导至少5次）" prop="practiceGuidance1Course1" width="250" />

      <el-table-column prop="practiceGuidance1Course2" label="校内指导课程系数2(2次以下)" width="250" />

      <el-table-column label="校外指导实习学时" prop="practiceGuidance2Time" width="250" />

      <el-table-column prop="practiceGuidance2Course" label="校外指导实习课程系数" width="250" />
      <el-table-column label="校外实习联系学时" prop="externalPracticeContactTime" width="250" />

      <el-table-column prop="externalPracticeContactCourse1" label="校外实习联系课程系数(2次以上)" width="250" />

      <el-table-column label="校外实习联系课程系数(少于2次)" prop="external_practice_contact_course2" width="250" />

      <el-table-column prop="dissertationTime" label="学生毕业论文（设计）学时/学生" width="250" />

      <el-table-column label="评阅论文学时/学生" prop="reviewTime" width="250" />

      <el-table-column prop="capstonePresentationTime" label="开题答辩学时/学生" width="250" />

      <el-table-column label="中期答辩学时/学生" prop="interimDefenseTime" width="250" />

      <el-table-column prop="groupDenfenseTime" label="小组答辩学时/学生" width="250" />

      <el-table-column prop="publicDenfenseTime" label="公开答辩学时/学生" width="250" />

      <el-table-column prop="denfenseSecretaryTime" label="答辩秘书学时/学生" width="250" />

      <el-table-column prop="capstoneCourseTime" label="Capstone课程学时/学生" width="250" />

      <el-table-column prop="establishTestBanks" label="首次建立试题库" width="250" />

      <el-table-column prop="perfectTestBanks" label="补充完善试题库" width="250" />

      <el-table-column prop="writtenTestProposition" label="笔试命题" width="250" />

      <el-table-column prop="computerTestProposition" label="机考命题" width="250" />

      <el-table-column prop="readingVolumes" label="期末考试、各种补考阅卷" width="250" />

      <el-table-column prop="invigilator1" label="监考（正常上班期间）" width="250" />

      <el-table-column prop="invigilator2" label="监考（下午4：20～6：20））" width="250" />

      <el-table-column prop="invigilator3" label="监考（晚上、双休日、寒暑假）" width="250" />

      <el-table-column prop="examination1" label="考试值班（下午4：20～6：20）" width="250" />

      <el-table-column prop="examination2" label="考试值班（晚上、双休日、寒暑假)" width="250" />

      <el-table-column prop="writingTeachingDocuments1" label="制订新专业人才培养方案）" width="250" />

      <el-table-column prop="writingTeachingDocuments2" label="修订专业人才培养方案" width="250" />

      <el-table-column prop="writingTeachingDocuments3" label="专业编写课程教学大纲、考试大纲" width="250" />

      <el-table-column prop="writingTeachingDocuments4" label="专业修订课程教学大纲、考试大纲" width="250" />

      <el-table-column prop="writingTeachingDocuments5" label="按常规编写课程教学大纲、考试大纲" width="250" />

      <el-table-column prop="writingTeachingDocuments6" label="按常规编写课程教学大纲、考试大纲" width="250" />

      <el-table-column prop="compilingBilingualTeachingDocuments" label="采用双语编写教学文件" width="250" />

      <el-table-column prop="newProfessionalWorkload1" label="新增专业工作量（当年）" width="250" />

      <el-table-column prop="newProfessionalWorkload2" label="新增专业工作量（第四年）" width="250" />

      <el-table-column label="操作" width="220" align="center">
        <template slot-scope="scope">
          <router-link :to="'/param/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">修改</el-button>
          </router-link>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeById(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center;"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage"
    />
  </div>
</template>
<script>
import paramApi from '@/api/param'
export default {
  data() {
    return {
      list: null, // 数据列表
      total: 0, // 总记录数
      page: 1, // 页码
      limit: 5, // 每页记录数
      searchObj: {}, // 查询条件
      multipleSelection: []// 批量删除选中的记录列表ID
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      // 调用api
      paramApi.pageList(this.page, this.limit, this.searchObj)
        .then(response => {
          this.list = response.data.records
          this.total = response.data.total
        })
    },
    // 每页记录数改变，size：回调参数，表示当前选中的“每页条数”
    changePageSize(size) {
      this.limit = size
      this.fetchData()
    },
    // 改变页码，page：回调参数，表示当前选中的“页码”
    changeCurrentPage(page) {
      this.page = page
      this.fetchData()
    },
    // 重置表单
    resetData() {
      this.searchObj = {}
      this.fetchData()
    },
    // 根据id删除数据
    removeById(id) {
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        paramApi.removeById(id).then((response) => {
          this.fetchData()
          this.$message.success(response.message)
        }).catch(error => {
          console.log('error', error)
        })
      }).catch(error => {
        // 当取消时会进入catch语句:error = 'cancel'
        // 当后端服务抛出异常时：error = 'error'
        if (error === 'cancel') {
          this.$message.info('取消删除 ')
        }
      })
    },
    // 当多选选项发生变化的时候调用
    handleSelectionChange(selection) {
      console.log(selection)
      selection.forEach(item => {
        this.multipleSelection.push(item.id)
      })
    },
    // 批量删除课程
    batchRemove() {
      if (this.multipleSelection.length === 0) {
        this.$message.warning('请选择要删除的记录！')
        return
      }
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        paramApi.batchRemove(this.multipleSelection).then(response => {
          this.fetchData()
          this.$message.success(response.message)
        }).catch(error => {
          console.log('error', error)
        })
      }).catch(error => {
        // 当取消时会进入catch语句:error = 'cancel'
        // 当后端服务抛出异常时：error = 'error'
        if (error === 'cancel') {
          this.$message.info('取消删除 ')
        }
      })
    },
    querySearch(queryString, cb) {
      paramApi.selectNameListByKey(queryString).then(response => {
        cb(response.data.nameList)
      })
    }
  }
}
</script>
