import request from '@/utils/request'

export function getlist() {
  return request({
    url: '/edu/user',
    method: 'get',
    data: {
    }
  })
}

export function getpagelist(pgidx,pgcnt) {
    return request({
      url: `/edu/user/${pgidx}/${pgcnt}`,
      method: 'get',
      data: {
          isDisabled:false
      }
    })
  }