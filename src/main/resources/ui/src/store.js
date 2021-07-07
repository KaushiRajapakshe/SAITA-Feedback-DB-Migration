import { createStore, applyMiddleware, compose } from "redux";
import rootReducer from "./Reducers";
import createSagaMiddleware from "redux-saga";
import { createBrowserHistory } from 'history'

import { rootSaga } from "./Actions/saitaDefs";

const sageMiddleware = createSagaMiddleware();
export const history = createBrowserHistory();

const middleware = process.env.NODE_ENV !== 'production' ?
  [sageMiddleware] :
  [sageMiddleware];

// create REDUX //

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
export const store = createStore(rootReducer, composeEnhancers(applyMiddleware(...middleware)))

sageMiddleware.run(rootSaga);