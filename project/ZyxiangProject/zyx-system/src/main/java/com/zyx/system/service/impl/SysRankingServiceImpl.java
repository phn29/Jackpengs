package com.zyx.system.service.impl;
import java.util.List;
import com.zyx.common.core.domain.entity.SysRanking;
import com.zyx.common.exception.BusinessException;
import com.zyx.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zyx.system.mapper.SysRankingMapper;
import com.zyx.system.service.ISysRankingService;
import com.zyx.common.core.text.Convert;

/**
 * 一分一段表（位次表）Service业务层处理
 *
 * @author 张银祥
 * @date 2021-08-10
 */
@Service
public class SysRankingServiceImpl implements ISysRankingService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
    
    @Autowired
    private SysRankingMapper sysRankingMapper;

    /**
     * 查询一分一段表（位次表）
     *
     * @param rankingId 一分一段表（位次表）ID
     * @return 一分一段表（位次表）
     */
    @Override
    public SysRanking selectSysRankingById(Long rankingId)
    {
        return sysRankingMapper.selectSysRankingById(rankingId);
    }

    /**
     * 查询一分一段表（位次表）列表
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 一分一段表（位次表）
     */
    @Override
    public List<SysRanking> selectSysRankingList(SysRanking sysRanking)
    {
        return sysRankingMapper.selectSysRankingList(sysRanking);
    }

    /**
     * 根据排名获取分数
     *
     * @param sysRanking 一分一段表（位次表）
     * @return SysRanking
     */
    @Override
    public List<SysRanking> selectSysRankingByGrade(SysRanking sysRanking) {
        return sysRankingMapper.selectSysRankingList(sysRanking);
    }

    /**
     * 新增一分一段表（位次表）
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 结果
     */
    @Override
    public int insertSysRanking(SysRanking sysRanking)
    {
        return sysRankingMapper.insertSysRanking(sysRanking);
    }

    /**
     * 修改一分一段表（位次表）
     *
     * @param sysRanking 一分一段表（位次表）
     * @return 结果
     */
    @Override
    public int updateSysRanking(SysRanking sysRanking)
    {
        return sysRankingMapper.updateSysRanking(sysRanking);
    }

    /**
     * 删除一分一段表（位次表）对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRankingByIds(String ids)
    {
        return sysRankingMapper.deleteSysRankingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除一分一段表（位次表）信息
     *
     * @param rankingId 一分一段表（位次表）ID
     * @return 结果
     */
    @Override
    public int deleteSysRankingById(Long rankingId)
    {
        return sysRankingMapper.deleteSysRankingById(rankingId);
    }

    /**
     * 导入一分一段表（位次表）信息
     *
     * @param rankingList 一分一段表（位次表）列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importRanking(List<SysRanking> rankingList, Boolean isUpdateSupport, String operName) {
        if(StringUtils.isNull(rankingList) || rankingList.size() == 0){
            throw new BusinessException("导入一分一段表（位次表）数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (SysRanking sysRanking : rankingList)
        {
            try
            {
                // 验证是否存在这个一分一段表（位次表）
                SysRanking m = sysRankingMapper.selectSysRankingById(sysRanking.getRankingId());
                if (StringUtils.isNull(m))
                {
                    sysRanking.setCreateBy(operName);
                    this.insertSysRanking(sysRanking);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysRanking.getRankingId() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    sysRanking.setUpdateBy(operName);
                    this.updateSysRanking(sysRanking);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + sysRanking.getRankingId() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + sysRanking.getRankingId() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + sysRanking.getRankingId() + " 导入失败：";
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