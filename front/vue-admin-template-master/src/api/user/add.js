import request from '@/utils/request'

export function add(uname) {
  return request({
    url: '/edu/user',
    method: 'post',
    data: {
        uname:uname
    }
  })
}