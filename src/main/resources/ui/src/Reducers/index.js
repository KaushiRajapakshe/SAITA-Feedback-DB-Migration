import { combineReducers } from "redux";

// all your reducers here...
import { saitaDetailReducer } from "./saitaDetailsReducer";

// combine all reducers....
export default combineReducers({
    saitaDetailsReducer: saitaDetailReducer
})
