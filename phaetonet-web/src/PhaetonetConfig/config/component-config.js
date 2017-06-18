/**
 * Created by Administrator on 2017/6/7.
 */
var config =  {
    DEFAULT_DATETIME_FORMATER: 'YYYY/MM/DD',
    DEFAULT_DATETIME_SUBMIT_FORMATER: 'YYYY-MM-DD[T]HH:mm:ss',

    //DEFAULT_SHOW_DATE_FORMATTER: true,
    //DEFAULT_DISPLAY_FULL_MONTH: true,
    //DEFAULT_ERROR_DISPLAY_MODE: 'mode1',

    // Number
    DEFAULT_NUMBER_FORMAT: '###,###,###,###.##',
    //DEFAULT_NUMBER_GROUP_PATTERN: '###,###,###,###',
    //DEFAULT_NUMBER_DECIMAL_PRECISION: 2,
    //DEFAULT_NUMBER_ROUND: true,
    //DEFAULT_NUMBER_DECIMAL_SEPARATOR: '.',

    // Currency
    DEFAULT_CURRENCY_UNIT: "$",
    DEFAULT_CURRENCY_FORMAT: '###,###,###.##',
    //DEFAULT_CURRENCY_SYMBOL: null,
    //DEFAULT_CURRENCY_GROUP_PATTERN: '###,###,###,###',
    //DEFAULT_CURRENCY_DECIMAL_PRECISION: 2,
    //DEFAULT_CURRENCY_ROUND: true,
    //DEFAULT_CURRENCY_DECIMAL_SEPARATOR: '.',
    DEFAULT_CODETABLE_KEYVALUE: {KEY: "id", VALUE: "text"},
    DEFAULT_BOOLEAN_VALUE: {"TRUE": "Y", "FALSE": "N"},

    //DEFAULT_PHONE_PATTERN: '(###)-#####',

    //DEFAULT_CODE_TABLE_DESC_STYLE: 'DESC',
    //DEFAULT_CODE_TABLE_SHOW_BLANK_OPTION: true,
    //DEFAULT_CODE_TABLE_CODE_TO_UPPERCASE: false,

    //DEFAULT_PREMIUM_DECIMAL_PRECISION: 0,
    //DEFAULT_SA_DECIMAL_PRECISION: 2,
    //DEFAULT_CLIENT_SIDE_VALIDATION: true,
    //DEFAULT_DISABLE_HELP_TEXT: false,
    //DEFAULT_VALUE_OF_BLANK_OPTION: -1,
    //DEFAULT_TIP_TARGET: 'icon',
    //DEFAULT_MSG_TARGET: 'popup',
    //DEFAULT_POPUP_STYLE: 'window',
    //DEFAULT_LABEL_SEPARATOR: false,
    DEFAULT_VALIDATOR_CONTAINER: "popover",// tooltip / popover
    DEFAULT_STYLE_CLASS: "default",
    DEFAULT_ECHARTS_THEME: "default",
    DEFAULT_LOCALSTORAGE_I18NKEY: "system_i18nKey",
    DEFAULT_SYSTEM_I18N: "en_US",
    ZH_CN_I18N: "zh_CN",
    DEFAULT_SYSTEM_THEME: "fwd",
    DEFAULT_DATATABLE_DROPDOWNLIST: [10, 20, 30, 40, 50],
    //DEFAULT_SKIN: 'ace_3',
    //DEVELOP_MODE: true,
    //DEFAULT_POPUP_STYLE: 'dialog',
    //DEFAULT_CODE_TABLE_SHOW_BLANK_OPTION_AS_BLANK: false,
    //PROTOTYPE_MODE: false,
    //SPECIAL_CHARACTERS=<>\"'%&|}+
    //PRODUCTION_JAVASCRIPT: '/web/js/resource/facesOne-ui.js',
    DEFAULT_MESSAGE_POSITION: {
        DEFAULT_POSITION: "toast-top-right",
        SUCCESS_POSITION: "toast-top-right",
        INFO_POSITION: "toast-top-right",
        WARNING_POSITION: "toast-top-right",
        ERROR_POSITION: "toast-top-right",
    },
/*    DEFAULT_CLASS: {
        LOGIN: require("./util/LoginUtil"),
        PAGE_HEADER: require("./common/PageHeader"),
        PAGE_FOOTER: require("./common/PageFooter")
    },*/

   /* DEFAULT_DYNAMIC_PAGE_URL: '/WebApi/GetUserData.dynamicPage',
    DEFAULT_DYNAMIC_SECTION_URL: '/WebApi/GetUserData.dynamicSection',
    DEFAULT_SCHEMA_URL: 'http://172.30.3.31:8080/pub/restlet/v1/public/dictionary/resource/schema/full',
    DEFAULT_SAMPLE_URL: 'http://172.30.3.31:8080/pub/restlet/v1/public/dictionary/resource/sample/full',
    DEFAULT_FIELD_URL: 'http://172.30.3.31:8080/pub/restlet/v1/ui/configField/getUIFieldBySectionParam',
    DEFAULT_INPUT_LAYOUT: "horizontal",
    DEFAULT_DATATABLE_IS_INDEX: "false",
    DEFAULT_LOGOUT_IS_WORKING: "false",
    DEFAULT_LOGOUT_TIME_MINUTES: 30,
    DEFAULT_COUNTDOWN_IS_WORKING: "false",
    SMART_PANELGRID_COLUMN:2,
    CACHE_FLAG: false,*/
};


/**
 * if uiconfig is undefined, It will import the framework of his own configuration file.
 */

    module.exports = config;
