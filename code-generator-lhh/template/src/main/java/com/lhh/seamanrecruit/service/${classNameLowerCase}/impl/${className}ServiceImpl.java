<#assign className = table.className>
		<#assign classNameLower = className?uncap_first>
		<#assign classNameLowerCase = className?lower_case>
		<#assign delFlag=false>
		<#assign storeId=false>
		<#assign methodName="findBy"+table.idColumn.columnName>
		<#assign params="">
		<#list table.columns as column>
		<#if column.columnNameLower == "delFlag">
		<#assign delFlag=true>
		<#assign methodName=methodName+"AndDelFlag">
		<#assign params=params+", DeleteFlag.NO">
		</#if>
		<#if column.columnNameLower == "storeId">
		<#assign storeId=true>
		<#assign methodName=methodName+"AndStoreId">
		<#assign params=params+", storeId">
		</#if>
		</#list>
package ${basepackage}.service.${classNameLowerCase}.impl;


import ${basepackage}.entity.${className};
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.dto.${className}Dto;
import ${basepackage}.service.${classNameLowerCase}.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;

/**
 * ${tableDesc}服务实现类
 *
 * @author ${rapidAuthor}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Slf4j
@Service
public class ${className}ServiceImpl implements ${className}Service {

	@Autowired
	private ${className}Dao ${classNameLower}Dao;

	/**
	 * ${tableDesc}新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ${className} add(${className} entity) {
		${classNameLower}Dao.insert(entity);
		return entity;
	}

	/**
	 * ${tableDesc}通过主键删除数据
	 *
	 * @param ids 主键
	 * @return 是否成功
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteById(List<${table.idColumn.javaType}> ids) {
		return ${classNameLower}Dao.deleteBatchIds(ids) > 0;
	}

	/**
	 * ${tableDesc}修改数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public ${className} updateById(${className} entity) {
		${classNameLower}Dao.updateById(entity);
		return queryById(entity.get${table.idColumn.columnName}());
	}

	/**
	 * ${tableDesc}通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ${className} queryById(${table.idColumn.javaType} id) {
		return ${classNameLower}Dao.selectById(${table.idColumn.columnNameLower});
	}

	/**
	 * ${tableDesc}分页查询
	 *
	 * @param dto 查询条件
	 * @return 查询结果
	 */
	@Override
	public Page<${className}> queryByPage(${className}Dto dto) {
		QueryWrapper<${className}> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("${table.idColumn.columnNameLower}");
		Page<${className}> page = new Page<>(dto.getPageNum(),dto.getPageSize());
		return (Page)${classNameLower}Dao.selectPage(page, queryWrapper);
	}

}