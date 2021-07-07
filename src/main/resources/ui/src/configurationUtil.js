import axios from "axios";

const API_BASE = process.env.REACT_APP_API_BASE_URL;

var API_BASE_URL = 'API_BASE_URL';
export const LOCAL_STR_CONFIG_KEY = 'saita-config';
// Define consigs
let configs = {};

// Persist config values
export const persistConfig = (res) => {

    if (res) {
      configs[API_BASE_URL] = API_BASE;
      console.log("configus",configs)
      sessionStorage.setItem(LOCAL_STR_CONFIG_KEY, JSON.stringify(configs));
    }
  }

  export const properties = {
    API_BASE_URL: API_BASE_URL
  }
  
  // Get config values
  export const getConfig = (key) => {

    let localStrConfig = sessionStorage.getItem(LOCAL_STR_CONFIG_KEY);
    if (localStrConfig) {
      localStrConfig = JSON.parse(localStrConfig);
      if (localStrConfig[key]) {
        return localStrConfig[key];
      }
    }
    return configs[key];
  }
  
  export const setConfig = (key,val) => {
    let localStrConfig = sessionStorage.getItem(LOCAL_STR_CONFIG_KEY);
    if (localStrConfig) {
      localStrConfig = JSON.parse(localStrConfig);
      localStrConfig[key] = val;
      sessionStorage.setItem(LOCAL_STR_CONFIG_KEY, JSON.stringify(localStrConfig));
    }
  }

  // Initialize config values
  export const initConfig = async () => {
    if (!sessionStorage.getItem(LOCAL_STR_CONFIG_KEY)) {
      let urlParams = getUrlParams();
      let promises = [];
      urlParams.forEach((urlPath)=>{
        promises.push(axios.get(`${urlPath}`));
      });
      return await Promise.all(promises);
  
  
    }
  }
// set params
  const getUrlParams = () => {
    let params = [];
    //push base url
    params.push(API_BASE);
    return params;
  
  }