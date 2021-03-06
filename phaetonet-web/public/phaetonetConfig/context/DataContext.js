/**
 * Created by Administrator on 2017/6/7.
 */
import MessageHelper from "../util/MessageHelper";
import i18n from "../i18n/reactjs-tag.i18n";

//-----------------------------------------------------------------------------------------------
//	description: DataContext Class
//-----------------------------------------------------------------------------------------------
var DataContext = {

    data: Object.create(null),

    /*** Put data */
    put: function(key, value) {
        if (this.get(key)) {
            console.log(key + i18n.MSG_DATACONTEXT_KEY_DUPLICATE);
        }
        this.data[key] = value;

    },

    /*** Get data */
    get: function(key) {
        return this.data[key];
    },

    /*** Remove data */
    remove: function(key){
        delete this.data[key];
    },

    /*** Clear data */
    clear: function(){
        this.data = Object.create(null);
    },

    /*** List data */
    list: function(){
        return this.data;
    }

};

module.exports = DataContext;