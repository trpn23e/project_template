import React, {
  Component
  // Fragment
} from 'react';
// import Common from './../common/Common'
import DTI from './../dti/DTI'
class App extends Component {
  constructor(props, context) {
    super(props, context)
    // this.state = {
    //   startMode: 'dev', // local, dev, prod
    //   srvAddr: 'http://127.0.0.1',
    //   srvPort: '50000'
    // }
  }

  // render() 호출전 실행
  // componentWillMount = (nextProps) => {
  //   this._setBackEndServer()
  // }

  // render() 후 실행
  // componentDidMount = (nextProps) => {
  //   this._setBackEndServer()
  // }

  // _setBackEndServer = () => {
  //   if (this.state.startMode.toLowerCase() === 'dev') {
  //     this.setState({
  //       srvPort: '8081'
  //     })
  //   } else {
  //     this.setState({
  //       srvPort: '50000'
  //     })
  //   }
  // }

  render () {
    return (
      <div>
        {/* <Common commonProp={this.state} /> */}
        <DTI cpmName="DTI" />
      </div>
    )
  }
}

export default App;
