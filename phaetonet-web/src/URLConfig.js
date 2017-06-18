/**
 * Created by Administrator on 2017/6/8.
 */

var URLConfig = {common:{},output:{}};

(function () {
    var setURL = function (shiro_config) {
        URLConfig.login = shiro_config.casURL + "login";

    }

    let shiro_config = {};
    shiro_config.casURL = "http://localhost:8080/shiro/";

    setURL(shiro_config);

})();

module.exports = URLConfig;