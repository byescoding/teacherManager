<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form :inline="true" label-width="150px">

      <el-form-item label="单班课合班系数">
        <template>
          <el-input-number v-model="parameter.singleClass" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="双班课合班系数">
        <template>
          <el-input-number v-model="parameter.doubleClass" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="三班课合班系数">
        <template>
          <el-input-number v-model="parameter.threeClass" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="四班及以上合班系数">
        <template>
          <el-input-number v-model="parameter.fourClass" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="重复班合班系数">
        <template>
          <el-input-number v-model="parameter.repeatCourse" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="理论课单班标准人数">
        <template>
          <el-input-number v-model="parameter.theoryStandardNumber" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="理论课超额学生合班累加系数">
        <template>
          <el-input-number v-model="parameter.theoryExcessStudent" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="实验课重复班课合班系数">
        <template>
          <el-input-number v-model="parameter.experimentRepeatCourse" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="实验课单班分批进行的合班系数">
        <template>
          <el-input-number v-model="parameter.experimentClassBatch" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="实验课多班分批进行的合班系数">
        <template>
          <el-input-number v-model="parameter.experimentClassesBatch" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="上机课重复课双班合班系数">
        <template>
          <el-input-number v-model="parameter.operationRepeatDoubleClass" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="开新课/新开课">
        <template>
          <el-input-number v-model="parameter.newCourse" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="在西城校区开设的课程">
        <template>
          <el-input-number v-model="parameter.xichengCourse" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="13级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade13" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="12级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade12" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="11级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade11" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="10级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade10" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="9级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade9" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="8级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade8" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="7级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade7" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="6级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade6" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="5级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade5" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="4级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade4" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="3级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade3" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="2级教师岗位系数">
        <template>
          <el-input-number v-model="parameter.grade2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校内指导学时">
        <template>
          <el-input-number v-model="parameter.practiceGuidance1Time" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校内指导课程系数1(指导至少5次)">
        <template>
          <el-input-number v-model="parameter.practiceCuidance1Course1" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校内指导课程系数2(每周2次（含2次）以下)">
        <template>
          <el-input-number v-model="parameter.practiceGuidance1Course2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校外指导实习学时">
        <template>
          <el-input-number v-model="parameter.practiceGuidance2Time" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校外指导实习课程系数">
        <template>
          <el-input-number v-model="parameter.practiceGuidance2Course" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校外实习联系学时">
        <template>
          <el-input-number v-model="parameter.externalPracticeContactTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校外实习联系课程系数1(考察2次/个以上)">
        <template>
          <el-input-number v-model="parameter.externalPracticeContactCourse1" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="校外实习联系课程系数2(考察少于2次/个)">
        <template>
          <el-input-number v-model="parameter.externalPracticeContactCourse2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="学生毕业论文（设计）学时">
        <template>
          <el-input-number v-model="parameter.dissertationTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="评阅论文学时/学生">
        <template>
          <el-input-number v-model="parameter.reviewTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="开题答辩学时/学生">
        <template>
          <el-input-number v-model="parameter.capstonePresentationTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="中期答辩学时/学生">
        <template>
          <el-input-number v-model="parameter.interimDefenseTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="小组答辩学时/学生">
        <template>
          <el-input-number v-model="parameter.groupDenfenseTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="公开答辩学时/学生">
        <template>
          <el-input-number v-model="parameter.publicDenfenseTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="答辩秘书学时/学生">
        <template>
          <el-input-number v-model="parameter.denfenseSecretaryTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="Capstone课程学时/学生">
        <template>
          <el-input-number v-model="parameter.capstoneCourseTime" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="首次建立试题库">
        <template>
          <el-input-number v-model="parameter.establishTestBanks" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="补充完善试题库">
        <template>
          <el-input-number v-model="parameter.perfectTestBanks" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="笔试命题">
        <template>
          <el-input-number v-model="parameter.writtenTestProposition" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="机考命题">
        <template>
          <el-input-number v-model="parameter.computerTestProposition" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="期末考试、各种补考阅卷">
        <template>
          <el-input-number v-model="parameter.readingVolumes" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="监考（正常上班期间）">
        <template>
          <el-input-number v-model="parameter.invigilator1" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="监考（下午4：20～6：20）">
        <template>
          <el-input-number v-model="parameter.invigilator2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="监考（晚上、双休日、寒暑假）">
        <template>
          <el-input-number v-model="parameter.invigilator3" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="考试值班（下午4：20～6：20）">
        <template>
          <el-input-number v-model="parameter.examination1" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="考试值班（晚上、双休日、寒暑假">
        <template>
          <el-input-number v-model="parameter.examination2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="制订新专业人才培养方案">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments1" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="修订专业人才培养方案">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments2" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>
      <el-form-item label="按照专业认证标准要求编写课程教学大纲、考试大纲">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments3" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="按照专业认证标准要求修订课程教学大纲、考试大纲">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments4" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="按常规编写课程教学大纲、考试大纲">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments5" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="按常规修订课程教学大纲、考试大纲">
        <template>
          <el-input-number v-model="parameter.writingTeachingDocuments6" :precision="1" :min="0.0" :step="0.1" :max="100"/>
        </template>
      </el-form-item>

      <el-form-item label="采用双语编写教学文件">
        <template>
          <el-input-number v-model="parameter.compilingBilingualTeachingDocuments" :precision="1" :min="0.0" :step="100" :max="10"/>
        </template>
      </el-form-item>

      <el-form-item label="新增专业工作量（当年）">
        <template>
          <el-input-number v-model="parameter.newProfessionalWorkload1" :precision="1" :min="0.0" :step="0.1" :max="1000"/>
        </template>
      </el-form-item>

      <el-form-item label="新增专业工作量（第四年）">
        <template>
          <el-input-number v-model="parameter.newProfessionalWorkload2" :precision="1" :min="0.0" :step="0.1" :max="1000"/>
        </template>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </el-form></div>
</template>
<script>

import paramApi from '@/api/param'
export default {
  data() {
    return {
      // 初始化讲师默认数据
      parameter: {

      },
      saveBtnDisabled: false // 保存按钮是否禁用，防止表单重复提交
    }
  },
  // 页面渲染成功
  created() {
    if (this.$route.params.id) {
      this.fetchDataById(this.$route.params.id)
    }
  },
  methods: {

    saveOrUpdate() {
    // 禁用保存按钮
      this.saveBtnDisabled = true
      if (!this.parameter.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },
    // 新增班级
    saveData() {
    // debugger
      paramApi.save(this.parameter).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/param' })
      })
    },
    // 根据id查询记录
    fetchDataById(id) {
      paramApi.getById(id).then(response => {
        this.parameter = response.data.item
      })
    },
    // 根据id更新记录
    updateData() {
      // teacher数据的获取
      paramApi.updateById(this.parameter).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/param' })
      })
    }

  }
}
</script>
<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
