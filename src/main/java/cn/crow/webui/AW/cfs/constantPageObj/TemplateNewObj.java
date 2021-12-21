package cn.crow.webui.AW.cfs.constantPageObj;

public class TemplateNewObj {
    //随访计划名称
    public static final String sfmc = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"title\"]/input[@placeholder=\"请输入随访计划名称\"]";

    //所属科室
    public static final String ssks = "//*[@id=\"root\"]//span[contains(text(),\"所属科室：\")]/following::div[1]";

    //所属科室一级选项
    public static final String ksyjxx = "/html/body//div[@class=\"ant-cascader-menus\"]//ul[1]/li[1]";

    //所属科室二级选项
    public static final String ksejxx = "/html/body//div[@class=\"ant-cascader-menus\"]//ul[2]/li[1]";

    //所属病种
    public static final String ssbz = "//*[@id=\"root\"]//span[contains(text(),\"所属病种：\")]/following::div[1]";

    //所属病种一级选项
    public static final String bzyjxx = "/html/body//div[@role=\"listbox\"]/following::div[5]";

    //随访时间间隔
    public static final String sfsj = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[1]//input";

    //随访时间间隔单位
    public static final String sfsjdw = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[2]";

    //随访时间间隔单位:天
    public static final String t = "/html/body//div[@role=\"listbox\"]/following::div[contains(text(),\"天\")]";

    //随访时间间隔单位:周
    public static final String z = "/html/body//div[@role=\"listbox\"]/following::div[contains(text(),\"周\")]";

    //随访时间间隔单位:月
    public static final String y = "/html/body//div[@role=\"listbox\"]/following::div[contains(text(),\"月\")]";

    //随访时间间隔单位:年
    public static final String n = "/html/body//div[@role=\"listbox\"]/following::div[contains(text(),\"年\")]";

    //随访方式【微信随访】
    public static final String wxsf = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[@class=\"flex\"]/label[1]//input[@type=\"checkbox\"]";

    //随访方式【短信随访】
    public static final String dxsf = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[@class=\"flex\"]/label[2]//input[@type=\"checkbox\"]";

    //随访方式【电话随访】
    public static final String dhsf = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[@class=\"flex\"]/label[3]//input[@type=\"checkbox\"]";

    //保存
    public static final String bc = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[@class=\"action-box\"]/a[contains(text(),\"保存\")]";

    //取消
    public static final String qx = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//div[contains(text(),\"随访时间：计划启动后 第\")]/div[@class=\"action-box\"]/a[contains(text(),\"取消\")]";

    //复诊计划勾选框
    public static final String fzjh_select = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"复诊计划\")]/preceding::input[@type=\"checkbox\"][1]";

    //复诊计划输入框
    public static final String fzjh_input = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"复诊计划\")]/following::input[@type=\"text\"][1]";

    //提前预约提醒勾选
    public static final String tqyy_select = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"提前\")]/preceding::span[@class=\"ant-radio-inner\"]";

    //提前预约提醒输入框
    public static final String tqyy_input = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"提前\")]/following::input[1]";

    //用药提醒勾选框
    public static final String yytx_select = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"用药提醒\")]/preceding::input[@type=\"checkbox\"][1]";

    //用药提醒输入框
    public static final String yytx_input = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"用药提醒\")]/following::input[@type=\"text\"][1]";

    //患教资料勾选框
    public static final String hjzl_select = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"患教资料\")]/preceding::input[@type=\"checkbox\"][1]";

    //添加患教资料
    public static final String hjzl_add = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"+添加患教资料\")]";

    //患教资料表单【选择】
    public static final String hjzlbd_add = "html//div[@class=\"ant-modal-body\"]//tbody[@class=\"ant-table-tbody\"]/tr[1]/td[4]/a";

    //问诊表勾选框
    public static final String wzb_select = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"问诊表\")]/preceding::input[@type=\"checkbox\"][1]";

    //添加问诊表
    public static final String wzb_add = "//*[@id=\"root\"]//div[@class=\"container\"]/div[@class=\"follow-box\"]//span[contains(text(),\"+添加问诊表\")]";

    //问诊表表单【选择】
    public static final String wzbbd_add = "//*[@id=\"root\"]//following::div[@class=\"ant-modal-body\"][2]//table/tbody/tr[1]/td[4]/a";

    //保存随访计划
    public static final String BC = "//*[@id=\"root\"]//span[contains(text(),\"保 存\")]";
}
