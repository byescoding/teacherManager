import request from '@/utils/request'

export default {
  getCourseTypeList() {
    return request({
      url: '/teachermanager/course-type/getcoursetypes',
      method: 'get'
    })
  }
}
