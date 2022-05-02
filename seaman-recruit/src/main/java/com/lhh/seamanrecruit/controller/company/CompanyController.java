package com.lhh.seamanrecruit.controller.company;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.company.CompanyDto;
import com.lhh.seamanrecruit.enums.ShipTypeEnum;
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
    public Result<CompanyDto> add(@RequestBody CompanyDto company) {
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
    public Result<Company> updateById(@RequestBody Company company) {
        return Result.success(companyService.updateById(company));
    }

    /**通过用户id查询
     *
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询公司")
    public Result<Company> queryById(@PathVariable("id") Long id) {
        return Result.success(companyService.queryById(id));
    }

    /**通过主键查询单条数据
     *
     *
     * @param userId 用户id
     * @return 单条数据
     */
    @GetMapping("/queryByUserId/{userId}")
    @ApiOperation("通过用户id查询公司")
    public Result<List<Company>> queryByUserId(@PathVariable("userId") Long userId) {
        return Result.success(companyService.queryByUserId(userId));
    }

    /**
     * 分页查询
     *
     * @param companyDto 查询条件
     * @return 查询结果
     *
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询公司")
    public Result<Page<Company>> queryByPage(@RequestBody CompanyDto companyDto) {
        return Result.success(companyService.queryByPage(companyDto));
    }

    /**
     * 船舶类型下拉框
     *
     * @return 船舶类型集
     *
     */
    @GetMapping("/getShipTypeList")
    @ApiOperation("船舶类型下拉框")
    public Result<List<String>> getShipTypeList() {
        return Result.success(ShipTypeEnum.getShipTypeList());
    }

}
