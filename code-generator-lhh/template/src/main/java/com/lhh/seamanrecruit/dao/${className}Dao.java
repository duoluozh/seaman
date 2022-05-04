<#assign className = table.className>
        <#assign classNameLower = className?uncap_first>
        <#assign delFlag=false>
        <#assign storeId=false>
        <#assign methodName="findBy"+table.idColumn.columnName>
        <#assign params="">
        <#list table.columns as column>
        <#if column.columnNameLower == "delFlag">
        <#assign delFlag=true>
        <#assign methodName=methodName+"AndDelFlag">
        <#assign params=params+", DeleteFlag delFlag">
        </#if>
        <#if column.columnNameLower == "storeId">
        <#assign storeId=true>
        <#assign methodName=methodName+"AndStoreId">
        <#assign params=params+", Long storeId">
        </#if>
</#list>
package ${basepackage}.dao;

import ${basepackage}.entity.${className};
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * ${tableDesc}Dao
 *
 * @author ${rapidAuthor}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Repository
public interface ${className}Dao extends BaseMapper<${className}> {

}
