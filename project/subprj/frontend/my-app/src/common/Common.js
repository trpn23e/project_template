import axios from 'axios'

const commonInfo = {
  backEndSrvTarget: 'local', // local, dev, prod
  backEndSrvAddr: 'http://127.0.0.1',
  backEndSrvPort: '50000'
}

function initialize() {
  Object.freeze(commonInfo)
}

function setCommonInfo () {
  let backEndSrvInfo = {
    startMode: commonInfo.backEndSrvTarget, 
    srvAddr: commonInfo.backEndSrvAddr,
    srvPort: commonInfo.backEndSrvPort
  }

  if (backEndSrvInfo.startMode.toLowerCase() === 'dev') {
    commonInfo.backEndSrvPort = '8081'
  } else {
    commonInfo.backEndSrvPort = '50000'
  }
}

setCommonInfo()
initialize()

export default {
  reqAjax: function (object) {
    if (object !== undefined && object != null) {
      let axiosReqParam = {
        method: object.method,
        url: commonInfo.backEndSrvAddr + ':' + commonInfo.backEndSrvPort + object.url,
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
      }

      for (let key in object) {
        if (key === 'data') {
          axiosReqParam.data = {}
          axiosReqParam.data = object.data
        } else if (key === 'params') {
          axiosReqParam.params = {}
          axiosReqParam.params = object.params
        } else {
          continue
        }
      }
      return axios(axiosReqParam)
    } else {
      alert('파라미터 오류')
    }
  }
}