import request from '@/utils/request'

export default{
  list() {
    return request({
      url: '/teachermanager/parameter/getparameters',
      method: 'get'
    })
  },
  pageList(page, limit, searchObj) {
    return request({
      url: `/teachermanager/parameter/list/${page}/${limit}`,
      method: 'get',
      params: searchObj
    })
  },
  removeById(id) {
    return request({
      url: `/teachermanager/parameter/remove/${id}`,
      method: 'delete'
    })
  },
  batchRemove(idList) {
    return request({
      url: `/teachermanager/parameter/batch-remove`,
      method: 'delete',
      data: idList
    })
  },
  save(parameter) {
    return request({
      url: '/teachermanager/parameter/save',
      method: 'post',
      data: parameter
    })
  },
  getById(id) {
    return request({
      url: `/teachermanager/parameter/get/${id}`,
      method: 'get'
    })
  },
  updateById(parameter) {
    return request({
      url: '/teachermanager/parameter/update',
      method: 'put',
      data: parameter
    })
  },
  selectNameListByKey(key) {
    return request({
      url: `/teachermanager/parameter/list/name/${key}`,
      method: 'get'
    })
  }
}
