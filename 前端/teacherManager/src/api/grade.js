import request from '@/utils/request'

export default {
  getGradeList() {
    return request({
      url: '/teachermanager/post-grade/getgrades',
      method: 'get'
    })
  }
}
