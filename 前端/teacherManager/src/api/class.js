import request from '@/utils/request'

export default{
  list() {
    return request({
      url: '/teachermanager/class/getclasses',
      method: 'get'
    })
  },
  pageList(page, limit, searchObj) {
    return request({
      url: `/teachermanager/class/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },
  removeById(id) {
    return request({
      url: `/teachermanager/class/remove/${id}`,
      method: 'delete'
    })
  },
  batchRemove(idList) {
    return request({
      url: `/teachermanager/class/batch-remove`,
      method: 'delete',
      data: idList
    })
  },
  save(classes) {
    return request({
      url: '/teachermanager/class/save',
      method: 'post',
      data: classes
    })
  },
  getById(id) {
    return request({
      url: `/teachermanager/class/get/${id}`,
      method: 'get'
    })
  },
  updateById(classes) {
    return request({
      url: '/teachermanager/class/update',
      method: 'put',
      data: classes
    })
  },
  selectNameListByKey(key) {
    return request({
      url: `/teachermanager/class/list/name/${key}`,
      method: 'get'
    })
  }
}
