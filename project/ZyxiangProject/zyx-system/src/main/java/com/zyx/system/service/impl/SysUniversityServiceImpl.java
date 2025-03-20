package com.zyx.system.service.impl;

import com.zyx.common.core.domain.entity.SysUniversity;
import com.zyx.common.core.text.Convert;
import com.zyx.common.exception.BusinessException;
import com.zyx.common.utils.StringUtils;
import com.zyx.system.mapper.SysUniversityMapper;
import com.zyx.system.service.ISysUniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 院校管理Service业务层处理
 *
 * @author 张银祥
 * @date 2021-05-26
 */
@Service
public class SysUniversityServiceImpl implements ISysUniversityService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private SysUniversityMapper sysUniversityMapper;

    /**
     * 查询院校管理
     *
     * @param universityId 院校管理ID
     * @return 院校管理
     */
    @Override
    public SysUniversity selectSysUniversityById(Long universityId)
    {
        return sysUniversityMapper.selectSysUniversityById(universityId);
    }

    /**
     * 查询院校管理列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理
     */
    @Override
    public List<SysUniversity> selectSysUniversityList(SysUniversity sysUniversity)
    {
        return sysUniversityMapper.selectSysUniversityList(sysUniversity);
    }

    /**
     * 查询所有院校
     *
     * @param
     * @return 院校管理
     */
    @Override
    public List<SysUniversity> selectSysUniversityAll() {
        return sysUniversityMapper.selectSysUniversityAll();
    }

    /**
     * 查询野鸡院校
     *
     * @param
     * @return 院校管理
     */
    @Override
    public List<SysUniversity> selectUniversityYj(SysUniversity sysUniversity) {
        return sysUniversityMapper.selectUniversityYj(sysUniversity);
    }

    /**
     * 查询正规院校
     *
     * @param
     * @return 院校管理
     */
    @Override
    public List<SysUniversity> selectUniversityZg(SysUniversity sysUniversity) {
        return sysUniversityMapper.selectUniversityZg(sysUniversity);
    }

    /**
     * 查询本科院校列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    @Override
    public List<SysUniversity> selectUndergraduateList(SysUniversity sysUniversity) {
        return sysUniversityMapper.selectUndergraduateList(sysUniversity);
    }

    /**
     * 查询专科院校列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    @Override
    public List<SysUniversity> selectSpecialtyList(SysUniversity sysUniversity) {
        return sysUniversityMapper.selectSpecialtyList(sysUniversity);
    }

    /**
     * 查询学校所在省份
     *
     * @param sysUniversity 院校管理
     * @return 学校所在神风
     */
    @Override
    public List<SysUniversity> selectGroupByProvinceName(SysUniversity sysUniversity) {
        return sysUniversityMapper.selectGroupByProvinceName(sysUniversity);
    }

    /**
     * 新增院校管理
     *
     * @param sysUniversity 院校管理
     * @return 结果
     */
    @Override
    public int insertSysUniversity(SysUniversity sysUniversity)
    {
        return sysUniversityMapper.insertSysUniversity(sysUniversity);
    }

    /**
     * 修改院校管理
     *
     * @param sysUniversity 院校管理
     * @return 结果
     */
    @Override
    public int updateSysUniversity(SysUniversity sysUniversity)
    {
        return sysUniversityMapper.updateSysUniversity(sysUniversity);
    }

    /**
     * 删除院校管理对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUniversityByIds(String ids)
    {
        return sysUniversityMapper.deleteSysUniversityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除院校管理信息
     *
     * @param universityId 院校管理ID
     * @return 结果
     */
    @Override
    public int deleteSysUniversityById(Long universityId)
    {
        return sysUniversityMapper.deleteSysUniversityById(universityId);
    }

    /**
     * 导入院校数据
     *
     * @param universityList 院校列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUniversity(List<SysUniversity> universityList, Boolean isUpdateSupport, String operName) {
        if(StringUtils.isNull(universityList) || universityList.size() == 0){
            throw new BusinessException("导入专业数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SysUniversity sysUniversity : universityList)
        {
            try
            {
                // 验证是否存在这个专业
                SysUniversity u = sysUniversityMapper.selectSysUniversityById(sysUniversity.getUniversityId());
                if (StringUtils.isNull(u))
                {
                    sysUniversity.setCreateBy(operName);
                    this.insertSysUniversity(sysUniversity);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysUniversity.getUniversityId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    sysUniversity.setUpdateBy(operName);
                    this.updateSysUniversity(sysUniversity);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysUniversity.getUniversityId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sysUniversity.getUniversityId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sysUniversity.getUniversityId() + " 导入失败：";
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

    @Override
    public List<SysUniversity> sdBkUniversity(int page, int row) {
        return sysUniversityMapper.sdBkUniversity(page, row);
    }

    @Override
    public List<SysUniversity> sdZkUniversity(int page, int rows) {
        return sysUniversityMapper.sdZkUniversity(page, rows);
    }
}
