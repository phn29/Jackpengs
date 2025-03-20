package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysUniversity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 院校管理Mapper接口
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public interface SysUniversityMapper
{
    /**
     * 查询院校管理
     *
     * @param universityId 院校管理ID
     * @return 院校管理
     */
    public SysUniversity selectSysUniversityById(Long universityId);

    /**
     * 查询院校管理列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    public List<SysUniversity> selectSysUniversityList(SysUniversity sysUniversity);

    /**
     * 查询所有院校
     *
     * @param
     * @return 院校管理集合
     */
    public List<SysUniversity> selectSysUniversityAll();

    /**
     * 查询野鸡大学列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    public List<SysUniversity> selectUniversityYj(SysUniversity sysUniversity);

    /**
     * 查询正规大学列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    public List<SysUniversity> selectUniversityZg(SysUniversity sysUniversity);

    /**
     * 查询本科院校列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    public List<SysUniversity> selectUndergraduateList(SysUniversity sysUniversity);

    /**
     * 查询专科院校列表
     *
     * @param sysUniversity 院校管理
     * @return 院校管理集合
     */
    public List<SysUniversity> selectSpecialtyList(SysUniversity sysUniversity);

    /**
     * 查询学校所在省份
     *
     * @param sysUniversity 院校管理
     * @return 学校所在省份
     */
    public List<SysUniversity> selectGroupByProvinceName(SysUniversity sysUniversity);

    /**
     * 新增院校管理
     *
     * @param sysUniversity 院校管理
     * @return 结果
     */
    public int insertSysUniversity(SysUniversity sysUniversity);

    /**
     * 修改院校管理
     *
     * @param sysUniversity 院校管理
     * @return 结果
     */
    public int updateSysUniversity(SysUniversity sysUniversity);

    /**
     * 删除院校管理
     *
     * @param universityId 院校管理ID
     * @return 结果
     */
    public int deleteSysUniversityById(Long universityId);

    /**
     * 批量删除院校管理
     *
     * @param universityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUniversityByIds(String[] universityIds);

    //搜索大学列表
    List<SysUniversity> getSearchUniversity(String query);

    /**
     * 查询山东本科院校列表
     *
     * @param page,row 院校管理
     * @return 山东本科院校集合
     */
    public List<SysUniversity> sdBkUniversity(@Param("page")int page, @Param("rows") int rows);

    /**
     * 查询山东专科院校列表
     *
     * @param page,row 院校管理
     * @return 山东专科院校集合
     */
    public List<SysUniversity> sdZkUniversity(@Param("page")int page, @Param("rows") int rows);


}
