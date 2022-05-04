<#include "/macro.include"/>
		<#assign className = table.className>
		<#assign classNameLower = className?uncap_first>
		<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.entity;

		<#assign dateColumnFlag=false dateTimeFlag=false dateFlag=false timeFlag=false decimalFlag=false>
		<#list table.columns as column>
		<#if column.isDateTimeColumn && !dateColumnFlag && column.columnNameLower != "createTime" && column.columnNameLower != "updateTime">
		<#assign dateColumnFlag=true>
				</#if>
				<#if column.javaType == "LocalDateTime" && !dateTimeFlag && column.columnNameLower != "createTime" && column.columnNameLower != "updateTime" >
import java.time.LocalDateTime;
		<#assign dateTimeFlag=true>
				<#elseif column.javaType == "LocalDate" && !dateFlag>
import java.time.LocalDate;
		<#assign dateFlag=true>
				<#elseif column.javaType == "LocalTime" && !timeFlag>
import java.time.LocalTime;
		<#assign timeFlag=true>
				<#elseif column.javaType == "BigDecimal" && !decimalFlag>
import java.math.BigDecimal;
		<#assign decimalFlag=true>
				</#if>
			</#list>

import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;
<#if table.idColumn.isStringColumn>
import org.hibernate.annotations.GenericGenerator;
</#if>

/**
 * <p>${tableDesc}实体类</p>
 * @author ${rapidAuthor}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("${tableDesc}")
@TableName(value = "${table.sqlName}")
public class ${className} implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ${table.idColumn.columnAlias}
	 */

	@Id
	@ApiModelProperty(value = "${table.idColumn.columnAlias}")
	private ${table.idColumn.javaType} ${table.idColumn.columnNameLower};

	<#list table.notPkColumns as column>
	<#if column.javaType == "LocalDateTime">
	<#if  column.columnNameLower != "createTime" && column.columnNameLower !=  "updateTime">
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}")
	private ${column.javaType} ${column.columnNameLower};

	</#if>
	<#elseif column.javaType == "LocalDate">
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}")
	private ${column.javaType} ${column.columnNameLower};

	<#elseif column.javaType == "LocalTime">
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}")
	private ${column.javaType} ${column.columnNameLower};

	<#else>
	<#if column.columnNameLower == "delFlag">
	/**
	 * ${column.columnAlias}
	 */
	@Enumerated
	@ApiModelProperty(value = "${column.columnAlias}")
	private DeleteFlag delFlag;

	<#else>
	<#if column.columnNameLower != "createPerson" && column.columnNameLower != "updatePerson">
	/**
	 * ${column.columnAlias}
	 */
	@ApiModelProperty(value = "${column.columnAlias}")
	private ${column.javaType} ${column.columnNameLower};

	</#if>
	</#if>
	</#if>
	</#list>
}
