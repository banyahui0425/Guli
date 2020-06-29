import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/edu/auth/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/edu/auth/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/edu/auth/logout',
    method: 'post'
  })
}
