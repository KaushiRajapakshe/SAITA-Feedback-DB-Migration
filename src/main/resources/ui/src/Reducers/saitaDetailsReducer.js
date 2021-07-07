import { STATE } from "../stateDefault";
import { SAITA_DETAILS_SUCCESS, SAITA_DETAILS_REQUEST_FAILED } from '../Actions';

// Saita Details Reducer
export function saitaDetailReducer(state = STATE.saitaDetailsReducer, action) {
    switch (action.type) {
        case SAITA_DETAILS_SUCCESS:
            return {
                ...state,
                failed: false,
                loading: false,
                data: action.payload
            }
        case SAITA_DETAILS_REQUEST_FAILED:
            return {
                ...state,
                failed: true,
                loading: false,
                data: []
            }
        default:
            return state;
    }
}