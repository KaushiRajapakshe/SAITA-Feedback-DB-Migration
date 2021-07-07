import { put, all, takeLatest } from "redux-saga/effects";
import {
    SAITA_DETAILS_SUCCESS,
    SAITA_DETAILS_REQUEST_FAILED,
    SAITA_DETAILS_REQUESTED
} from "./index";

// Saita Details Value Action Fire
function* selectSaitaDetails(action) {
    if (action) {
        try {
            // Set saita details
            const response = {'Name': "Kaushalya Rajapakshe",
                      'ID': "IT16178700",
                      'Project': "SAITA",
                      'Version': "1.0"
                     }
            yield put({ type: SAITA_DETAILS_SUCCESS, payload: response });
        } catch (err) {
            yield put({ type: SAITA_DETAILS_REQUEST_FAILED, payload: err });
        }
    }
}

export function* rootSaga() {
    yield all([
        takeLatest(SAITA_DETAILS_REQUESTED, selectSaitaDetails)
    ])
}