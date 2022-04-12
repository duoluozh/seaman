package com.lhh.seamanrecruit.controller.company;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.Company;
import com.lhh.seamanrecruit.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 公司控制层
 *
 * @author  yslong
 * @date 2022-04-12 14:10:00
 */
@Api(tags = "公司")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 新增数据
     *
     * @param company 公司实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增公司")
    public Result add(@RequestBody Company company) {
        return Result.success(companyService.insert(company));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除公司")
    public Result deleteById(@RequestBody List<Long> ids) {
        return Result.success(companyService.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param company 公司实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改公司")
    public Result updateById(@RequestBody Company company) {
        return Result.success(companyService.updateById(company));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询公司")
    public Result queryById(@PathVariable("id") Long id) {
        return Result.success(companyService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询公司")
    public Result queryByPage(Company company, BaseQueryDto pageRequest) {
        return Result.success(companyService.queryByPage(company, pageRequest));
    }

}
