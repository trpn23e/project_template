import React from 'react';
import ReactDOM from 'react-dom';
import "babel-polyfill";
import './resources/css/reset.css';
import './resources/css/common.css';
import App from './component/app/App';
// import registerServiceWorker from './registerServiceWorker';
// registerServiceWorker();
console.log('===================== index.js ======================')
ReactDOM.render(<App/>, document.getElementById('root'));