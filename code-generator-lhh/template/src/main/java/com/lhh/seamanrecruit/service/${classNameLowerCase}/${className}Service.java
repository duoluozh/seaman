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
package ${basepackage}.service.${classNameLowerCase};

import ${basepackage}.entity.${className};
import ${basepackage}.dto.${className}Dto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * ${tableDesc}服务接口
 *
 * @author ${rapidAuthor}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
public interface ${className}Service {

        /**
         * ${tableDesc}新增数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        ${className} add(${className} entity);

        /**
         * ${tableDesc}通过主键删除数据
         *
         * @param ids 主键
         * @return 是否成功
         */
        boolean deleteById(List<${table.idColumn.javaType}> ids);

        /**
         * ${tableDesc}根据id修改数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        ${className} updateById(${className}  entity);

        /**
         * ${tableDesc}通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        ${className} queryById(${table.idColumn.javaType} id);

        /**
         * ${tableDesc}分页查询
         *
         * @param dto 查询条件
         * @return 查询结果
         */
        Page<${className}> queryByPage(${className}Dto dto);

}