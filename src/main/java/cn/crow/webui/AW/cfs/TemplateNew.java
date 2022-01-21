package cn.crow.webui.AW.cfs;


import cn.crow.webui.AW.cfs.constantPageObj.MainPageObj;
import cn.crow.webui.AW.cfs.constantPageObj.TemplateNewObj;
import cn.crow.webui.AW.cfs.constantPageObj.TemplateObj;
import cn.crow.webui.control.baseComponent.BaseComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

@Log4j2
public class TemplateNew {
    private static final BaseComponent baseComponent = new BaseComponent();
    public static void newtemplate() throws Exception {
        try{//点击专业设置
            baseComponent.findElement(MainPageObj.zysz).click();
            //点击随访计划
            baseComponent.findElement(MainPageObj.sfjh).click();
            //点击新建
            baseComponent.findElement(TemplateObj.xinjian_xpath).click();
            //输入随访计划名称
            baseComponent.findElement(TemplateNewObj.sfmc).sendKeys("测试随访计划");
            //选择科室
            baseComponent.findElement(TemplateNewObj.ssks).click();
            baseComponent.findElement(TemplateNewObj.ksyjxx).click();
            baseComponent.findElement(TemplateNewObj.ksejxx).click();
            //病种选择
            baseComponent.findElement(TemplateNewObj.ssbz).click();
            baseComponent.findElement(TemplateNewObj.bzyjxx).click();
            //随访时间
            baseComponent.findElement(TemplateNewObj.sfsj).click();
            baseComponent.findElement(TemplateNewObj.sfsj).sendKeys("5");
            baseComponent.findElement(TemplateNewObj.sfsjdw).click();
            baseComponent.findElement(TemplateNewObj.t).click();
            //随访方式
            baseComponent.findElement(TemplateNewObj.wxsf).click();
            baseComponent.findElement(TemplateNewObj.dxsf).click();
            baseComponent.findElement(TemplateNewObj.dhsf).click();
            //复诊计划
            baseComponent.findElement(TemplateNewObj.fzjh_select).click();
            baseComponent.findElement(TemplateNewObj.fzjh_input).click();
            baseComponent.findElement(TemplateNewObj.fzjh_input).clear();
            baseComponent.findElement(TemplateNewObj.fzjh_input).sendKeys(Keys.CONTROL, "a");
            baseComponent.findElement(TemplateNewObj.fzjh_input).sendKeys("请于3天后来我院复诊");
            baseComponent.findElement(TemplateNewObj.tqyy_input).click();
            baseComponent.findElement(TemplateNewObj.tqyy_input).sendKeys(Keys.CONTROL, "a");
            baseComponent.findElement(TemplateNewObj.tqyy_input).sendKeys("3");
            //用药提醒
            baseComponent.findElement(TemplateNewObj.yytx_select).click();
            baseComponent.findElement(TemplateNewObj.yytx_input).sendKeys(Keys.CONTROL, "a");
            baseComponent.findElement(TemplateNewObj.yytx_input).sendKeys("请及时吃药");
            //患教资料
            baseComponent.findElement(TemplateNewObj.hjzl_select).click();
            baseComponent.findElement(TemplateNewObj.hjzl_add).click();
            baseComponent.findElement(TemplateNewObj.hjzlbd_add).click();
            //问诊表
            baseComponent.findElement(TemplateNewObj.wzb_select).click();
            baseComponent.findElement(TemplateNewObj.wzb_add).click();
            baseComponent.findElement(TemplateNewObj.wzbbd_add).click();
            //保存
            baseComponent.findElement(TemplateNewObj.bc).click();
            baseComponent.findElement(TemplateNewObj.BC).click();
        }catch (Exception e){
            baseComponent.screenShot();
            log.error(e);
        }

    }
}
