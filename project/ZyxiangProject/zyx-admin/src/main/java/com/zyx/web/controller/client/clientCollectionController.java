package com.zyx.web.controller.client;

import com.zyx.common.core.domain.AjaxResult;
import com.zyx.common.core.domain.entity.SysCollection;
import com.zyx.common.core.domain.entity.SysStudent;
import com.zyx.system.domain.ResponseData;
import com.zyx.system.service.ISysCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * 用户收藏记录Controller
 *
 * @author zyx
 * @date 2022-03-30
 */
@Controller
@RequestMapping("/client/collection")
public class clientCollectionController {

    @Autowired
    private ISysCollectionService sysCollectionService;
    /**
     * 新增保存用户收藏记录
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseData addSave(SysCollection sysCollection, HttpSession session)
    {
        //判断用户是否登录
        SysStudent sysStudent = (SysStudent) session.getAttribute("SysStudent");
        if(Objects.nonNull(sysStudent)){
            //校验用户是否已收藏过
            sysCollection.setStuId(sysStudent.getStuId());
            List<SysCollection> sysCollections = sysCollectionService.selectSysCollectionList(sysCollection);
            if (sysCollections.size() == 0){
                int i = sysCollectionService.insertSysCollection(sysCollection);
                if(i != 0){
                    return ResponseData.ok(sysCollection.getCollectionName()+"收藏成功！");
                }
                return ResponseData.fail(sysCollection.getCollectionName()+"收藏失败！");
            }
            return ResponseData.fail(sysCollection.getCollectionName()+"：已被收藏过了，不能重复收藏！");
        }else{
            return ResponseData.fail("收藏失败，请用普通用户登录进行收藏！");
        }
    }
}
