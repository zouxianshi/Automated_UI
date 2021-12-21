package cn.crow.webui.AW.cfs;


import cn.crow.webui.AW.cfs.constantPageObj.MainPageObj;
import cn.crow.webui.AW.cfs.constantPageObj.TemplateNewObj;
import cn.crow.webui.AW.cfs.constantPageObj.TemplateObj;
import cn.crow.webui.control.baseComponent.BaseComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

@Log4j2
public class TemplateNew {

    public static void newtemplate() throws Exception {
        try{//点击专业设置
            BaseComponent.findElement(MainPageObj.zysz).click();
            //点击随访计划
            BaseComponent.findElement(MainPageObj.sfjh).click();
            //点击新建
            BaseComponent.findElement(TemplateObj.xinjian_xpath).click();
            //输入随访计划名称
            BaseComponent.findElement(TemplateNewObj.sfmc).sendKeys("测试随访计划");
            //选择科室
            BaseComponent.findElement(TemplateNewObj.ssks).click();
            BaseComponent.findElement(TemplateNewObj.ksyjxx).click();
            BaseComponent.findElement(TemplateNewObj.ksejxx).click();
            //病种选择
            BaseComponent.findElement(TemplateNewObj.ssbz).click();
            BaseComponent.findElement(TemplateNewObj.bzyjxx).click();
            //随访时间
            BaseComponent.findElement(TemplateNewObj.sfsj).click();
            BaseComponent.findElement(TemplateNewObj.sfsj).sendKeys("5");
            BaseComponent.findElement(TemplateNewObj.sfsjdw).click();
            BaseComponent.findElement(TemplateNewObj.t).click();
            //随访方式
            BaseComponent.findElement(TemplateNewObj.wxsf).click();
            BaseComponent.findElement(TemplateNewObj.dxsf).click();
            BaseComponent.findElement(TemplateNewObj.dhsf).click();
            //复诊计划
            BaseComponent.findElement(TemplateNewObj.fzjh_select).click();
            BaseComponent.findElement(TemplateNewObj.fzjh_input).click();
            BaseComponent.findElement(TemplateNewObj.fzjh_input).clear();
            BaseComponent.findElement(TemplateNewObj.fzjh_input).sendKeys(Keys.CONTROL, "a");
            BaseComponent.findElement(TemplateNewObj.fzjh_input).sendKeys("请于3天后来我院复诊");
            BaseComponent.findElement(TemplateNewObj.tqyy_input).click();
            BaseComponent.findElement(TemplateNewObj.tqyy_input).sendKeys(Keys.CONTROL, "a");
            BaseComponent.findElement(TemplateNewObj.tqyy_input).sendKeys("3");
            //用药提醒
            BaseComponent.findElement(TemplateNewObj.yytx_select).click();
            BaseComponent.findElement(TemplateNewObj.yytx_input).sendKeys(Keys.CONTROL, "a");
            BaseComponent.findElement(TemplateNewObj.yytx_input).sendKeys("请及时吃药");
            //患教资料
            BaseComponent.findElement(TemplateNewObj.hjzl_select).click();
            BaseComponent.findElement(TemplateNewObj.hjzl_add).click();
            BaseComponent.findElement(TemplateNewObj.hjzlbd_add).click();
            //问诊表
            BaseComponent.findElement(TemplateNewObj.wzb_select).click();
            BaseComponent.findElement(TemplateNewObj.wzb_add).click();
            BaseComponent.findElement(TemplateNewObj.wzbbd_add).click();
            //保存
            BaseComponent.findElement(TemplateNewObj.bc).click();
            BaseComponent.findElement(TemplateNewObj.BC).click();
        }catch (Exception e){
            BaseComponent.screenShot();
            log.error(e);
        }

    }
}
