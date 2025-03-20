package com.zyx.system.service.impl;

import java.util.List;

import com.zyx.common.core.domain.entity.SysPlan;
import com.zyx.common.exception.BusinessException;
import com.zyx.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysPlanMapper;
import com.zyx.system.service.ISysPlanService;
import com.zyx.common.core.text.Convert;

/**
 * 计划招生表Service业务层处理
 *
 * @author 张银祥
 * @date 2021-06-15
 */
@Service
public class SysPlanServiceImpl implements ISysPlanService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysPlanMapper sysPlanMapper;

    /**
     * 查询计划招生表
     *
     * @param planId 计划招生表ID
     * @return 计划招生表
     */
    @Override
    public SysPlan selectSysPlanById(Long planId)
    {
        return sysPlanMapper.selectSysPlanById(planId);
    }

    /**
     * 查询录取分数表
     *
     * @param universityId 学校ID
     * @return 录取分数表
     */
    @Override
    public List<SysPlan> selectSysPlanByUniversityId(Long universityId) {
        return sysPlanMapper.selectSysPlanByUniversityId(universityId);
    }

    /**
     * 查询计划招生表列表
     *
     * @param sysPlan 计划招生表
     * @return 计划招生表
     */
    @Override
    public List<SysPlan> selectSysPlanList(SysPlan sysPlan)
    {
        return sysPlanMapper.selectSysPlanList(sysPlan);
    }

    @Override
    public List<SysPlan> selectSysPlanListShock(SysPlan sysPlan) {
        return sysPlanMapper.selectSysPlanListShock(sysPlan);
    }

    @Override
    public List<SysPlan> selectSysPlanListSafe(SysPlan sysPlan) {
        return sysPlanMapper.selectSysPlanListSafe(sysPlan);
    }

    @Override
    public List<SysPlan> selectSysPlanListGuaranteed(SysPlan sysPlan) {
        return sysPlanMapper.selectSysPlanListGuaranteed(sysPlan);
    }

    /**
     * 通过院校类型查询招生计划
     *
     * @param universityTypes 院校类型
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByUniversityTypes(String[] universityTypes){
        return sysPlanMapper.selectSysPlanByUniversityTypes(universityTypes);
    }

    /**
     * 通过院校所在省份和专业名称查询招生计划
     *
     * @param purposeAddress 所在省份 purposeMajor 专业名称
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByMajorNameAndProvinceName(String[] purposeAddress, String[] purposeMajor){
        return sysPlanMapper.selectSysPlanByMajorNameAndProvinceName(purposeAddress, purposeMajor);
    }

    /**
     * 通过专业名和院校名称查询招生计划
     *
     * @param majorArray 专业名称 universityArray 院校名称
     * @return 计划招生表集合
     */
    public List<SysPlan> selectSysPlanByMajorsAndUniversitys(String[] majorArray, String[] universityArray){
        return sysPlanMapper.selectSysPlanByMajorsAndUniversitys(majorArray, universityArray);
    }


    /**
     * 新增计划招生表
     *
     * @param sysPlan 计划招生表
     * @return 结果
     */
    @Override
    public int insertSysPlan(SysPlan sysPlan)
    {
        return sysPlanMapper.insertSysPlan(sysPlan);
    }

    /**
     * 修改计划招生表
     *
     * @param sysPlan 计划招生表
     * @return 结果
     */
    @Override
    public int updateSysPlan(SysPlan sysPlan)
    {
        return sysPlanMapper.updateSysPlan(sysPlan);
    }

    /**
     * 删除计划招生表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysPlanByIds(String ids)
    {
        return sysPlanMapper.deleteSysPlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除计划招生表信息
     *
     * @param planId 计划招生表ID
     * @return 结果
     */
    @Override
    public int deleteSysPlanById(Long planId)
    {
        return sysPlanMapper.deleteSysPlanById(planId);
    }

    @Override
    public String importPlan(List<SysPlan> planList, Boolean isUpdateSupport, String operName) {
        if(StringUtils.isNull(planList) || planList.size() == 0){
            throw new BusinessException("导入专业数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SysPlan sysPlan : planList)
        {
            try
            {
                // 验证是否相同的数据
                SysPlan p = sysPlanMapper.selectSysPlanById(sysPlan.getPlanId());
                if (StringUtils.isNull(p))
                {
                    sysPlan.setCreateBy(operName);
                    this.insertSysPlan(sysPlan);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysPlan.getPlanId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    sysPlan.setUpdateBy(operName);
                    this.updateSysPlan(sysPlan);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysPlan.getPlanId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sysPlan.getPlanId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sysPlan.getPlanId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}