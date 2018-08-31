import Common from './../common/Common'

export function getQueryDslList (param) {
  let jsonStrParam = JSON.stringify(param)
  return Common.reqAjax({
    method: 'post',
    url: '/restdemo1',
    data: jsonStrParam
  })
}

export function goH2DbConsole () {
  window.open("http://localhost:50000/console/", "_blank");
}

export function goBackEndIndex () {
  window.open("http://localhost:50000", "_blank");
}

export function getJpaList (param) {
  let jsonStrParam = JSON.stringify(param)
  return Common.reqAjax({
    method: 'post',
    url: '/restdemo2',
    data: jsonStrParam
  })
}

export function getMybatisList (param) {
  let jsonStrParam = JSON.stringify(param)
  return Common.reqAjax({
    method: 'post',
    url: '/restmybatis1',
    data: jsonStrParam
  })
}

export function getListToTestDtiJMS (param) {
  let jsonStrParam = JSON.stringify(param)
  return Common.reqAjax({
    method: 'post',
    url: '/getListToTestJMS',
    data: jsonStrParam
  })
}

export function sendMsgInbound (param) {
  let jsonStrParam = JSON.stringify(param)
  return Common.reqAjax({
    method: 'post',
    url: '/sendMsgInbound',
    data: jsonStrParam
  })
}