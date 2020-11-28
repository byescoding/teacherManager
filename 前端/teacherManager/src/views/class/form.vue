<template>
  <div class="app-container">
    <!-- 输入表单 -->
    <el-form label-width="80px" >

      <el-form-item label="班级名称">
        <el-input v-model="classes.name" placeholder="请输入班级名称"/>
      </el-form-item>

      <el-form-item label="班级人数">
        <template>
          <el-input-number v-model="classes.number" :min="1" :max="100" />
        </template>
      </el-form-item>

      <el-form-item label="班主任">
        <template>
          <el-select v-model="classes.headmaster" placeholder="请选择">
            <el-option
              v-for="item in teacherList"
              :key="item.id"
              :label="item.name"
              :value="item.name"/>
          </el-select>
        </template>
      </el-form-item>

      <el-form-item label="是否为新增专业">
        <el-select v-model="classes.isNewMajor">
          <!--
            数据类型一定要和取出的json中的一致，否则没法回填
            因此，这里value使用动态绑定的值，保证其数据类型是number
            -->
          <el-option :value="0" label="是"/>
          <el-option :value="1" label="否"/>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </el-form></div>
</template>
<script>
import teacherApi from '@/api/teacher'
// import courseTypeApi from '@/api/courseType'
import classApi from '@/api/class'
export default {
  data() {
    return {
      // 初始化讲师默认数据
      classes: {
        isNewMajor: 0,
        number: 30
      },
      saveBtnDisabled: false, // 保存按钮是否禁用，防止表单重复提交
      teacherList: []
    }
  },
  // 页面渲染成功
  created() {
    if (this.$route.params.id) {
      this.fetchDataById(this.$route.params.id)
    }
    this.getTeacherList()
  },
  methods: {
    // 获取教师信息
    getTeacherList() {
      teacherApi.list().then(response => {
        this.teacherList = response.data.teachers
      })
    },

    saveOrUpdate() {
    // 禁用保存按钮
      this.saveBtnDisabled = true
      if (!this.classes.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },
    // 新增班级
    saveData() {
    // debugger
      classApi.save(this.classes).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/class' })
      })
    },
    // 根据id查询记录
    fetchDataById(id) {
      classApi.getById(id).then(response => {
        this.classes = response.data.item
      })
    },
    // 根据id更新记录
    updateData() {
      // teacher数据的获取
      classApi.updateById(this.classes).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push({ path: '/class' })
      })
    }
    // // 头像上传成功函数
    // handleAvatarSuccess(res) {
    //   if (res.success) {
    //     this.teacher.avatar = res.data.url
    //     // 重新渲染
    //     this.$forceUpdate()
    //   } else {
    //     this.$message.error('上传失败,请联系网站管理员')
    //   }
    // }
    // // 头像上传之前执行的函数
    // beforeAvatarUpload(file) {
    //   const isJPGorPNG = (file.type === 'image/jpeg') || (file.type === 'image/png')
    //   const isLt2M = file.size / 1024 / 1024 < 1

    //   if (!isJPGorPNG) {
    //     this.$message.error('上传头像图片只能是 JPG/PNG 格式！')
    //   }
    //   if (!isLt2M) {
    //     this.$message.error('上传头像图片大小不能超过 1MB!')
    //   }
    //   return isJPGorPNG && isLt2M
    // },
    // handleAvatarError(res) {
    //   this.$message.error('上传失败（http失败）')
    // }
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
