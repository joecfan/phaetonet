/**
 * Created by Administrator on 2017/6/7.
 */

/*require('es6-promise').polyfill();
require('isomorphic-fetch');*/
var URLConfig = require('../../URLConfig');

var LoginService = {
     doLogin (content) {
        var url = URLConfig.login;

         let params = content;

        return fetch(url,{
             method: 'POST',
             mode: 'cors',
             headers: {
                 'Accept': 'application/json',
                 'Content-Type': 'application/json',
             },
             body: JSON.stringify(params),

         }).then(res=>{
          return res.json();
         }).catch(err=>console.log(err));
    },
};

export default LoginService;