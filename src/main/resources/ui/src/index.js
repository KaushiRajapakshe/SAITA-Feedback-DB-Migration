import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import { store } from "./store";
import { Provider } from "react-redux";
import reportWebVitals from './reportWebVitals';
import * as serviceWorker from './serviceWorker';
// import { initConfig, persistConfig } from './configurationUtil.js';

// initConfig().then((response) => {
//   let configVals = response.reduce((acc, curr) => {
//     if (curr && curr.data) {
//       acc = curr.data;
//       return curr.data;
//     }
//     else {
//       return acc;
//     }
//   });
//   if (configVals && configVals.data) {
//     configVals = configVals.data;
//   }
//   persistConfig(configVals);

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>,
  document.getElementById('root')
);
// });
serviceWorker.unregister();
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
