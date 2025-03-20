package com.zyx.system.service.impl;

import com.zyx.common.core.text.Convert;
import com.zyx.common.core.domain.entity.SysMajor;
import com.zyx.common.exception.BusinessException;
import com.zyx.common.utils.StringUtils;
import com.zyx.system.mapper.SysMajorMapper;
import com.zyx.system.mapper.SysUserMapper;
import com.zyx.system.service.ISysConfigService;
import com.zyx.system.service.ISysMajorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业表Service业务层处理
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Service
public class SysMajorServiceImpl implements ISysMajorService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysMajorMapper sysMajorMapper;

    /**
     * 查询专业表
     *
     * @param majorId 专业表ID
     * @return 专业表
     */
    @Override
    public SysMajor selectSysMajorById(Long majorId)
    {
        return sysMajorMapper.selectSysMajorById(majorId);
    }

    /**
     * 查询专业表
     *
     * @param majorName 专业名称
     * @return 专业表
     */
    public SysMajor selectSysMajorByMajorName(String majorName){
        return sysMajorMapper.selectSysMajorByMajorName(majorName);
    }

    /**
     * 查询专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表
     */
    @Override
    public List<SysMajor> selectSysMajorList(SysMajor sysMajor)
    {
        return sysMajorMapper.selectSysMajorList(sysMajor);
    }

    /**
     * 查询全部专业表列表
     *
     * @return 专业表
     */
    @Override
    public List<SysMajor> selectSysMajorAll() {
        return sysMajorMapper.selectSysMajorAll();
    }

    /**
     * 查询本科专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表
     */
    @Override
    public List<SysMajor> selectUndergraduateMajorList(SysMajor sysMajor) {
        return sysMajorMapper.selectUndergraduateMajorList(sysMajor);
    }


    /**
     * 查询专科专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表
     */
    @Override
    public List<SysMajor> selectSpecialtyMajorList(SysMajor sysMajor) {
        return sysMajorMapper.selectSpecialtyMajorList(sysMajor);
    }

    /**
     * 新增专业表
     *
     * @param sysMajor 专业表
     * @return 结果
     */
    @Override
    public int insertSysMajor(SysMajor sysMajor)
    {
        return sysMajorMapper.insertSysMajor(sysMajor);
    }

    /**
     * 修改专业表
     *
     * @param sysMajor 专业表
     * @return 结果
     */
    @Override
    public int updateSysMajor(SysMajor sysMajor)
    {
        return sysMajorMapper.updateSysMajor(sysMajor);
    }

    /**
     * 删除专业表对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysMajorByIds(String ids)
    {
        return sysMajorMapper.deleteSysMajorByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专业表信息
     *
     * @param majorId 专业表ID
     * @return 结果
     */
    @Override
    public int deleteSysMajorById(Long majorId)
    {
        return sysMajorMapper.deleteSysMajorById(majorId);
    }

    /**
     * 导入专业数据
     *
     * @param majorList 专业列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importMajor(List<SysMajor> majorList, Boolean isUpdateSupport, String operName) {
        if(StringUtils.isNull(majorList) || majorList.size() == 0){
            throw new BusinessException("导入专业数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SysMajor sysMajor : majorList)
        {
            try
            {
                // 验证是否存在这个专业
                SysMajor m = sysMajorMapper.selectSysMajorById(sysMajor.getMajorId());
                if (StringUtils.isNull(m))
                {
                    sysMajor.setCreateBy(operName);
                    this.insertSysMajor(sysMajor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysMajor.getMajorId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    sysMajor.setUpdateBy(operName);
                    this.updateSysMajor(sysMajor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysMajor.getMajorId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sysMajor.getMajorId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sysMajor.getMajorId() + " 导入失败：";
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
