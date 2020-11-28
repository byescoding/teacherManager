import request from '@/utils/request'

export default{
  list() {
    return request({
      url: '/teachermanager/course/getcourses',
      method: 'get'
    })
  },
  pageList(page, limit, searchObj) {
    return request({
      url: `/teachermanager/course/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },
  removeById(id) {
    return request({
      url: `/teachermanager/course/remove/${id}`,
      method: 'delete'
    })
  },
  batchRemove(idList) {
    return request({
      url: `/teachermanager/course/batch-remove`,
      method: 'delete',
      data: idList
    })
  },
  save(course) {
    return request({
      url: '/teachermanager/course/save',
      method: 'post',
      data: course
    })
  },
  getById(id) {
    return request({
      url: `/teachermanager/course/get/${id}`,
      method: 'get'
    })
  },
  updateById(course) {
    return request({
      url: '/teachermanager/course/update',
      method: 'put',
      data: course
    })
  },
  selectNameListByKey(key) {
    return request({
      url: `/teachermanager/course/list/name/${key}`,
      method: 'get'
    })
  }
}
