import React, {
  Component,
  Fragment
} from 'react';
import {
  goH2DbConsole,
  goBackEndIndex,
  getQueryDslList,
  getJpaList,
  getMybatisList,
  getListToTestDtiJMS,
  sendMsgInbound
} from './../../action/dtiAction'
// import { withStyles } from '@material-ui/core/styles'
// import Paper from '@material-ui/core/Paper'
// import Grid from '@material-ui/core/Grid'
// import PropTypes from 'prop-types'
import {
  Pagination,
  Dialog,
  Autocomplete,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Menu,
  Submenu,
  MenuItem,
  MenuItemGroup,
  Input,
  InputNumber,
  Radio,
  RadioGroup,
  RadioButton,
  Checkbox,
  CheckboxButton,
  CheckboxGroup,
  Switch,
  Select,
  Option,
  OptionGroup,
  Button,
  ButtonGroup,
  Table,
  TableColumn,
  DatePicker,
  TimeSelect,
  TimePicker,
  Popover,
  Tooltip,
  Breadcrumb,
  BreadcrumbItem,
  Form,
  FormItem,
  Tabs,
  TabPane,
  Tag,
  Tree,
  Alert,
  Slider,
  Icon,
  Row,
  Col,
  Upload,
  Progress,
  Badge,
  Card,
  Rate,
  Steps,
  Step,
  Carousel,
  CarouselItem,
  Collapse,
  CollapseItem,
  Cascader,
  ColorPicker,
  Transfer,
  Container,
  Header,
  Aside,
  Main,
  Footer,
  Loading,
  MessageBox,
  Message,
  Notification
// } from 'element-react';
} from 'element-react-ui-components'
import 'element-theme-default';
import { loadProgressBar } from 'axios-progress-bar'
import 'axios-progress-bar/dist/nprogress.css'
import JSONPretty from 'react-json-pretty'

class DTI extends Component {
  constructor (props, context) {
    super(props, context);
    this.state = {
      viewList: null,
      viewData: null,
      inputValue: ''
    }
    loadProgressBar()
  };

  _initState () {
    this.setState({
      viewList: null,
      viewData: null
      // inputValue: ''
    })
  }

  _setList(list) {
    if (list != null && list.length > 0) {
      this.setState({
        viewList: list
      })
    } else {
      this.setState({
        viewList: null
      })
    }
  }

  _setViewData(data) {
    if (data !== undefined) {
      this.setState({
        viewData: data
      })
    } else {
      this.setState({
        viewData: null
      })
    }
  }

  _goBackEndIndex = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    goBackEndIndex();
  }

  _goH2DbConsole = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    goH2DbConsole();
  }

  _getQueryDslList = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    this._initState()
    getQueryDslList({testParam: this.state.inputValue}).then(response => {
      let data = response.data
      if (data.list !==undefined && data.list instanceof Array) {
        this._setList(data.list)
      } else {
        this._setViewData(data)
      }
    }).catch(err => {
      alert(err)
    })
  }

  _getJpaList = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    this._initState()
    getJpaList({testParam: this.state.inputValue}).then(response => {
      let data = response.data
      if (data.list !==undefined && data.list instanceof Array) {
        this._setList(data.list)
      } else {
        this._setViewData(data)
      }
    }).catch(err => {
      alert(err)
    })
  }

  _getMybatisList = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    this._initState()
    getMybatisList({testParam: this.state.inputValue}).then(response =>{
      let data = response.data
      if (data.list !==undefined && data.list instanceof Array) {
        this._setList(data.list)
      } else {
        this._setViewData(data)
      }
    }).catch(err => {
      alert(err)
    })
  }

  _getListToTestDtiJMS = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    this._initState()
    getListToTestDtiJMS({testParam: this.state.inputValue}).then(response =>{
      alert("JMS 전송상태는 서버 콘솔을 확인해보자~여기까지 찍혔으면 일단 관련 기능 호출자체는 성공");
      let data = response.data
      if (data.list !==undefined && data.list instanceof Array) {
        this._setList(data.list)
      } else {
        this._setViewData(data)
      }
    }).catch(err => {
      alert(err)
    })
  }

  _sendMsgInbound = (ev) => {
    ev.nativeEvent.stopImmediatePropagation();
    this._initState()
    sendMsgInbound({testParam: this.state.inputValue}).then(response =>{
      alert("JMS 전송상태는 서버 콘솔을 확인해보자~여기까지 찍혔으면 일단 관련 기능 호출자체는 성공");
      let data = response.data
      if (data.list !==undefined && data.list instanceof Array) {
        this._setList(data.list)
      } else {
        this._setViewData(data)
      }
    }).catch(err => {
      alert(err)
    })
  }

  updateInputValue = (ev) => {
    this.setState({
      inputValue: ev
    });

    // this.setState({
    //   inputValue: ev.target.value
    // });
  }

  _initHtml () {
    const styles = {
      divDefault: {
        'float': 'left',
        'margin': '10px 5% 10px 5%',
        'width': '90%'
      },
      btnLeftPad: {
        'marginLeft': '5px'
      },
      debugConsole: {
        'float': 'left',
        'margin': '10px 5% 10px 5%',
        'width': '90%',
        'minHeight': '200px',
        'padding': '3px',
        'outline': '2px solid red'
      },
      viewUlDefault: {
        'float': 'left',
        'listStyle': 'none',
        'width': '100%',
        'minHeight': '180px'
      },
      viewLiDefault: {
        'float': 'left',
        'width': '95%',
        'text-overflow': 'ellipsis',
        'white-space': 'nowrap',
        'overflow': 'hidden'
      },
      lineFeed: {
        'float': 'left',
        'width': '93%',
        'textOverflow': 'ellipsis',
        'wordBreak': 'break-all'
      }
    };
    
    return (
      <Card className="box-card" style={styles.divDefault}>
        <div>
          {/* 
            require로 안읽으면 webpack으로 읽을때랑 경로가 차이가 생겨서 읽을수 없다
            그냥 npm start했을때는 public폴더를 root로 보고 webpack빌드하면 build폴더를 root로
            보기때문에 동일 폴더구조상의 상대경로로 자원을 바라보도록 해야한다
          */}
          <img src={require('./../../resources/img/2037.png')} style={{width:30,height:30,paddingBottom:5}} />
          <img src={require('./../../resources/img/2037.jpg')} style={{width:30,height:30,paddingBottom:5}} />
          <Card className="box-card" style={{marginBottom:20}}>
            <div style={styles.divDefault}>
              <span>
                Component Name : {this.props.cpmName}
              </span>
            </div>
            <div style={styles.divDefault}>
              <span>파라미터 &nbsp;&nbsp; : &nbsp;&nbsp;</span>
              {/* <span><input type="text" value={this.state.inputValue} onChange={this.updateInputValue} /></span> */}
              <span>
                <Input 
                  onChange={this.updateInputValue} 
                  value={this.state.inputValue} 
                  style={{width:'46%'}} 
                  placeholder="파라미터 입력"
                />
              </span>
            </div>
            <div style={styles.divDefault}>
              <Button type="primary" onClick={this._goBackEndIndex}>BackEnd 서버 페이지 이동</Button>
              <Button type="primary" onClick={this._goH2DbConsole}>H2 DB Console 이동(BackEnd)</Button>
              <Button type="primary" onClick={this._getQueryDslList}>Query DSL</Button>
              <Button type="primary" onClick={this._getJpaList} style={styles.btnLeftPad}>JPA</Button>
              <Button type="primary" onClick={this._getMybatisList} style={styles.btnLeftPad}>Mybatis</Button>
            </div>
            <div style={styles.divDefault}>
              <Fragment>JMS 호출 테스트(Ountbound(Adaptor - Router - Connector) : </Fragment>
              <Button type="primary" onClick={this._getListToTestDtiJMS}>호출</Button><br></br><br></br>
              <Fragment>JMS 호출 테스트(Inbound Router -> Inbound Adaptor) : </Fragment>
              <Button type="primary" onClick={this._sendMsgInbound}>호출</Button><br></br>
            </div>
          </Card>
          <Card className="box-card">
            <div style={styles.viewUlDefault}>
              <ul style={styles.viewUlDefault}>
                {
                  (
                    (this.state.viewList != null && this.state.viewList.length > 0) &&
                    (this.state.viewData === undefined || this.state.viewData == null)
                  ) ?
                  ( this.state.viewList.map((item, idx) => {
                    return (
                      <li style={styles.lineFeed} key={idx}> <JSONPretty id="json-pretty" json={item} /></li>
                    )
                  })) : (
                    (this.state.viewData !== undefined && this.state.viewData != null) ?
                    <JSONPretty id="json-pretty" json={this.state.viewData} /> : ''
                  )
                }
              </ul>
            </div>
          </Card>
        </div>
      </Card>
    );
  }

  render () {
    return (
      <Fragment>
        {this._initHtml()}
      </Fragment>
    );
  }
}

export default DTI;