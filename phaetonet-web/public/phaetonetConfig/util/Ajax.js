/**
 * Created by Administrator on 2017/6/8.
 */
import AjaxStatus from "./AjaxStatus";
import Exception from "../component/misc/Exception";

//-----------------------------------------------------------------------------------------------
//	date: 2015/08/15
//
//	author: yonglu.xie tony.zhang
//
//	description: Ajax Class
//-----------------------------------------------------------------------------------------------
var Ajax = {
    /**
     * Ajax.ajax() to server
     * @param options
     * @returns {jqXHR}
     */
    ajax: function (options) {
        $.ajax($.extend({}, options, {
            beforeSend: function (jqXHR) {
                var projectConfigJSON = sessionStorage.getItem("project_config");
                var projectConfigObject = null;
                var loginFlag = true;
                if (projectConfigJSON) {
                    projectConfigObject = JSON.parse(projectConfigJSON);
                }
                if (projectConfigObject) {
                    loginFlag = projectConfigObject["login"];
                }
                if (loginFlag) {
                    var configKey = projectConfigObject["key"];
                    if (!configKey) {
                        configKey = "Authorization";
                    }
                    var setionToken = sessionStorage.getItem(configKey);
                    if (setionToken == null) {
                        jqXHR.abort();
                        logout();
                    } else {
                        jqXHR.setRequestHeader(configKey, 'Bearer ' + setionToken.substr(13).split("&")[0]);
                    }
                }
                if (options["block"]) {
                    AjaxStatus.show();
                }
            },
            complete: function (jqXHR, textStatus) {
            },
            success: function (data) {
            }.bind(this),
            error: function (jqXHR, status, error) {
                if (jqXHR.status == "440") {
                    logout();
                }
            }.bind(this)
        }))
            .done(function (data, textStatus, jqXHR) {
                let done = options.done;
                if (done !== undefined && done !== null) {
                    done(data, textStatus, jqXHR);
                }
            })
            .fail(function (jqXHR, textStatus, errorThrown) {
                console.log("======ajax fail=====", jqXHR);

                // If status is 200, is do nothing
                if (jqXHR.status == "200" || jqXHR.status == "440") {
                    return;
                }

                if (textStatus == "canceled") {
                    return;
                }
                // If need, it re login again
                if (jqXHR.status == "401" || jqXHR.status == "403") {
                    //let LoginUtil = new config.DEFAULT_CLASS.LOGIN;
                    logout();
                }

                let fail = options.fail;
                if (fail !== undefined && fail !== null) {
                    let callback = null;
                    if (typeof fail === "function") {
                        callback = fail;
                    } else {
                        callback = fail["" + jqXHR.status];
                    }

                    if (callback != null) {
                        callback(jqXHR, textStatus, errorThrown);
                    } else {
                        Exception.throw(jqXHR.status, jqXHR.responseText);
                    }
                } else {
                    Exception.throw(jqXHR.status, jqXHR.responseText);
                }
            })
            .always(function () {
                setTimeout(function () {
                    AjaxStatus.hide();
                }, 0);
            });
    }
}

module.exports = Ajax;