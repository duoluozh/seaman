<#assign className = table.className>
        <#assign classNameFirstLower = className?uncap_first>
        <#assign classNameLowerCase = className?lower_case>
        <#assign pkJavaType = table.idColumn.javaType>
        <#assign delFlag=false notBlankFlag=false>
        <#list table.columns as column>
        <#if column.columnNameLower == "delFlag">
        <#assign delFlag=true>

        <#break>
        </#if>
        </#list>
package ${basepackage}.controller.${serviceModule};

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ${basepackage}.entity.${className};
import ${basepackage}.dto.${className}Dto;
import ${basepackage}.service.${classNameLowerCase}.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * ${tableDesc}控制层
 *
 * @author  ${rapidAuthor}
 * @date <#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Api(tags = "${tableDesc}")
@RestController
@RequestMapping("/${classNameFirstLower}")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${classNameFirstLower}Service;

    /**
     * 新增数据
     *
     * @param ${classNameFirstLower} ${tableDesc}实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增${tableDesc}")
    public Result<${className}> add(@RequestBody ${className} ${classNameFirstLower}) {
        return Result.success(${classNameFirstLower}Service.add(${classNameFirstLower}));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除${tableDesc}")
    public Result deleteById(@RequestBody List<${table.idColumn.javaType}> ids) {
        return Result.success(${classNameFirstLower}Service.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param ${classNameFirstLower} ${tableDesc}实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改${tableDesc}")
    public Result<${className}> updateById(@RequestBody ${className} ${classNameFirstLower}) {
        return Result.success(${classNameFirstLower}Service.updateById(${classNameFirstLower}));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询${tableDesc}")
    public Result<${className}> queryById(@PathVariable("id") ${table.idColumn.javaType} id) {
        return Result.success(${classNameFirstLower}Service.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param ${classNameFirstLower}Dto 查询条件
     * @return 查询结果
     *
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询${tableDesc}")
    public Result<Page<${className}>> queryByPage(${className}Dto ${classNameFirstLower}Dto) {
        return Result.success(${classNameFirstLower}Service.queryByPage(${classNameFirstLower}Dto));
    }

}
