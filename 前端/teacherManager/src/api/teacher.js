import request from '@/utils/request'

export default{
  list() {
    return request({
      url: '/teachermanager/teacher/getteachers',
      method: 'get'
    })
  },
  pageList(page, limit, searchObj) {
    return request({
      url: `/teachermanager/teacher/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },
  removeById(id) {
    return request({
      url: `/teachermanager/teacher/remove/${id}`,
      method: 'delete'
    })
  },
  batchRemove(idList) {
    return request({
      url: `/teachermanager/teacher/batch-remove`,
      method: 'delete',
      data: idList
    })
  },
  save(teacher) {
    return request({
      url: '/teachermanager/teacher/save',
      method: 'post',
      data: teacher
    })
  },
  getById(id) {
    return request({
      url: `/teachermanager/teacher/get/${id}`,
      method: 'get'
    })
  },
  updateById(teacher) {
    return request({
      url: '/teachermanager/teacher/update',
      method: 'put',
      data: teacher
    })
  },
  selectNameListByKey(key) {
    return request({
      url: `/teachermanager/teacher/list/name/${key}`,
      method: 'get'
    })
  }
}
