package com.zyx.system.mapper;

import com.zyx.common.core.domain.entity.SysMajor;

import java.util.List;

/**
 * 专业表Mapper接口
 *
 * @author 张银祥
 * @date 2021-05-26
 */
public interface SysMajorMapper
{
    /**
     * 查询专业表
     *
     * @param majorId 专业表ID
     * @return 专业表
     */
    public SysMajor selectSysMajorById(Long majorId);

    /**
     * 查询专业表
     *
     * @param majorName 专业名称
     * @return 专业表
     */
    public SysMajor selectSysMajorByMajorName(String majorName);

    /**
     * 查询专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表集合
     */
    public List<SysMajor> selectSysMajorList(SysMajor sysMajor);

    /**
     * 查询全部专业
     *
     * @param
     * @return 专业表集合
     */
    public List<SysMajor> selectSysMajorAll();

    /**
     * 查询本科专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表集合
     */
    public List<SysMajor> selectUndergraduateMajorList(SysMajor sysMajor);

    /**
     * 查询专科专业表列表
     *
     * @param sysMajor 专业表
     * @return 专业表集合
     */
    public List<SysMajor> selectSpecialtyMajorList(SysMajor sysMajor);

    /**
     * 新增专业表
     *
     * @param sysMajor 专业表
     * @return 结果
     */
    public int insertSysMajor(SysMajor sysMajor);

    /**
     * 修改专业表
     *
     * @param sysMajor 专业表
     * @return 结果
     */
    public int updateSysMajor(SysMajor sysMajor);

    /**
     * 删除专业表
     *
     * @param majorId 专业表ID
     * @return 结果
     */
    public int deleteSysMajorById(Long majorId);

    /**
     * 批量删除专业表
     *
     * @param majorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysMajorByIds(String[] majorIds);
}
