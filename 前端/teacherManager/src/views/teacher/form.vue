<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="80px" >
      <el-form-item label="教师名称">
        <el-input v-model="teacher.name" placeholder="请输入教师名称"/>
      </el-form-item>

      <el-form label-width="80px" >
        <el-form-item label="登录密码">
          <el-input v-model="teacher.password" placeholder="请输入登录密码"/>
        </el-form-item>

        <el-form-item label="教师等级">
          <template>
            <el-select v-model="teacher.grade" placeholder="请选择">
              <el-option
                v-for="item in gradeList"
                :key="item.id"
                :label="item.name"
                :value="item.name"/>
            </el-select>
          </template>
        </el-form-item>

        <el-form-item label="性别">
          <el-select v-model="teacher.sex">
            <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
            <el-option :value="0" label="女"/>
            <el-option :value="1" label="男"/>
          </el-select>
        </el-form-item>

        <el-form-item label="身份证号">
          <el-input v-model="teacher.idCard" placeholder="请输入身份证号"/>
        </el-form-item>

        <el-form-item label="联系电话">
          <el-input v-model="teacher.telephone" placeholder="请输入联系电话"/>
        </el-form-item>

        <el-form-item label="毕业院校">
          <el-input v-model="teacher.university" placeholder="请输入毕业院校"/>
        </el-form-item>

        <el-form-item label="邮件">
          <el-input v-model="teacher.email" placeholder="请输入邮件"/>
        </el-form-item>

        <el-form-item label="家庭住址">
          <el-input v-model="teacher.address" placeholder="请输入家庭住址"/>
        </el-form-item>

        <el-form-item label="学历">
          <el-input v-model="teacher.education" placeholder="请输入学历"/>
        </el-form-item>

        <el-form-item>
          <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
        </el-form-item>
      </el-form>
  </el-form></div>
</template>
<script>
import teacherApi from '@/api/teacher'
import gradeApi from '@/api/grade'
export default {
  data() {
    return {
      BASE_API: process.env.BASE_API,
      // 初始化讲师默认数据
      teacher: {
        grade: '一级',
        sex: 1
      },
      saveBtnDisabled: false, // 保存按钮是否禁用，防止表单重复提交
      gradeList: []
    }
  },
  // 页面渲染成功
  created() {
    if (this.$route.params.id) {
      this.fetchDataById(this.$route.params.id)
    }
    this.getGradeList()
  },
  methods: {

    getGradeList() {
      gradeApi.getGradeList().then(response => {
        this.gradeList = response.data.grades
      })
    },
    saveOrUpdate() {
    // 禁用保存按钮
      this.saveBtnDisabled = true
      if (!this.teacher.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },
    // 新增讲师
    saveData() {
    // debugger
      teacherApi.save(this.teacher).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/teacher' })
      })
    },
    // 根据id查询记录
    fetchDataById(id) {
      teacherApi.getById(id).then(response => {
        this.teacher = response.data.item
      })
    },
    // 根据id更新记录
    updateData() {
      // teacher数据的获取
      teacherApi.updateById(this.teacher).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/teacher' })
      })
    },
    // 头像上传成功函数
    handleAvatarSuccess(res) {
      if (res.success) {
        this.teacher.avatar = res.data.url
        // 重新渲染
        this.$forceUpdate()
      } else {
        this.$message.error('上传失败,请联系网站管理员')
      }
    },
    // 头像上传之前执行的函数
    beforeAvatarUpload(file) {
      const isJPGorPNG = (file.type === 'image/jpeg') || (file.type === 'image/png')
      const isLt2M = file.size / 1024 / 1024 < 1

      if (!isJPGorPNG) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式！')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 1MB!')
      }
      return isJPGorPNG && isLt2M
    },
    handleAvatarError(res) {
      this.$message.error('上传失败（http失败）')
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
