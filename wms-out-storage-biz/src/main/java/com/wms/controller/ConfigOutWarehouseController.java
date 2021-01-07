package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.ConfigOutWarehouseEntity;
import com.wms.service.ConfigOutWarehouseService;
import com.wms.api.config.ConfigOutWarehouseQueryParam;
import com.wms.api.config.ConfigOutWarehouseVo;
import com.wms.model.bo.config.ConfigOutWarehouseBo;
import com.xac.core.api.ApiResult;
import com.xac.core.api.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;


import javax.validation.Valid;

import com.xac.core.api.Paging;

/**
 * <pre>
 * 出库业务配置 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@RestController
@RequestMapping("/config")
@Api("出库业务配置 API")
public class ConfigOutWarehouseController extends BaseController {

    @Autowired
    private ConfigOutWarehouseService configOutWarehouseService;

    /**
     * 添加出库业务配置
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ConfigOutWarehouse对象", notes = "添加出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> addConfigOutWarehouse(@Valid @RequestBody ConfigOutWarehouseVo configOutWarehouse) throws Exception {
         ConfigOutWarehouseBo bo = new ConfigOutWarehouseBo();
        BeanUtils.copyProperties(configOutWarehouse,bo);

        boolean flag = configOutWarehouseService.saveConfigOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库业务配置
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ConfigOutWarehouse对象", notes = "修改出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> updateConfigOutWarehouse(@Valid @RequestBody ConfigOutWarehouseVo configOutWarehouse) throws Exception {
        ConfigOutWarehouseBo bo = new ConfigOutWarehouseBo();
        BeanUtils.copyProperties(configOutWarehouse,bo);

        boolean flag = configOutWarehouseService.updateConfigOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库业务配置
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除ConfigOutWarehouse对象", notes = "删除出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> deleteConfigOutWarehouse(@PathVariable("id") Long id) throws Exception {
        boolean flag = configOutWarehouseService.deleteConfigOutWarehouse(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库业务配置
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取ConfigOutWarehouse对象详情", notes = "查看出库业务配置", response = ConfigOutWarehouseVo.class)
    public ApiResult<ConfigOutWarehouseVo> getConfigOutWarehouse(@PathVariable("id") Long id) throws Exception {
        ConfigOutWarehouseBo configOutWarehouseBo = configOutWarehouseService.getConfigOutWarehouseById(id);
        ConfigOutWarehouseVo queryVo = null;
        if (configOutWarehouseBo != null) {
            queryVo = new ConfigOutWarehouseVo();
            BeanUtils.copyProperties(configOutWarehouseBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库业务配置分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取ConfigOutWarehouse分页列表", notes = "出库业务配置分页列表", response = ConfigOutWarehouseVo.class)
    public ApiResult<Paging<ConfigOutWarehouseVo>> getConfigOutWarehousePageList(@Valid @RequestBody ConfigOutWarehouseQueryParam configOutWarehouseQueryParam) throws Exception {
        Paging<ConfigOutWarehouseBo> paging = configOutWarehouseService.getConfigOutWarehousePageList(configOutWarehouseQueryParam);
        Paging<ConfigOutWarehouseVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), ConfigOutWarehouseVo.class));
        return ApiResult.ok(resultPage);
    }

}

