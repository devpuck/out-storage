package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.ConfigSpecOutWarehouseEntity;
import com.wms.service.ConfigSpecOutWarehouseService;
import com.wms.api.config.ConfigSpecOutWarehouseQueryParam;
import com.wms.api.config.ConfigSpecOutWarehouseVo;
import com.wms.model.bo.config.ConfigSpecOutWarehouseBo;
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
 * @since 2021-01-11
 */
@Slf4j
@RestController
@RequestMapping("/config")
@Api("出库业务配置 API")
public class ConfigSpecOutWarehouseController extends BaseController {

    @Autowired
    private ConfigSpecOutWarehouseService configSpecOutWarehouseService;

    /**
     * 添加出库业务配置
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ConfigSpecOutWarehouse对象", notes = "添加出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> addConfigSpecOutWarehouse(@Valid @RequestBody ConfigSpecOutWarehouseVo configSpecOutWarehouse) throws Exception {
         ConfigSpecOutWarehouseBo bo = new ConfigSpecOutWarehouseBo();
        BeanUtils.copyProperties(configSpecOutWarehouse,bo);

        boolean flag = configSpecOutWarehouseService.saveConfigSpecOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库业务配置
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ConfigSpecOutWarehouse对象", notes = "修改出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> updateConfigSpecOutWarehouse(@Valid @RequestBody ConfigSpecOutWarehouseVo configSpecOutWarehouse) throws Exception {
        ConfigSpecOutWarehouseBo bo = new ConfigSpecOutWarehouseBo();
        BeanUtils.copyProperties(configSpecOutWarehouse,bo);

        boolean flag = configSpecOutWarehouseService.updateConfigSpecOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库业务配置
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除ConfigSpecOutWarehouse对象", notes = "删除出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> deleteConfigSpecOutWarehouse(@PathVariable("id") Long id) throws Exception {
        boolean flag = configSpecOutWarehouseService.deleteConfigSpecOutWarehouse(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库业务配置
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取ConfigSpecOutWarehouse对象详情", notes = "查看出库业务配置", response = ConfigSpecOutWarehouseVo.class)
    public ApiResult<ConfigSpecOutWarehouseVo> getConfigSpecOutWarehouse(@PathVariable("id") Long id) throws Exception {
        ConfigSpecOutWarehouseBo configSpecOutWarehouseBo = configSpecOutWarehouseService.getConfigSpecOutWarehouseById(id);
        ConfigSpecOutWarehouseVo queryVo = null;
        if (configSpecOutWarehouseBo != null) {
            queryVo = new ConfigSpecOutWarehouseVo();
            BeanUtils.copyProperties(configSpecOutWarehouseBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库业务配置分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取ConfigSpecOutWarehouse分页列表", notes = "出库业务配置分页列表", response = ConfigSpecOutWarehouseVo.class)
    public ApiResult<Paging<ConfigSpecOutWarehouseVo>> getConfigSpecOutWarehousePageList(@Valid @RequestBody ConfigSpecOutWarehouseQueryParam configSpecOutWarehouseQueryParam) throws Exception {
        Paging<ConfigSpecOutWarehouseBo> paging = configSpecOutWarehouseService.getConfigSpecOutWarehousePageList(configSpecOutWarehouseQueryParam);
        Paging<ConfigSpecOutWarehouseVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), ConfigSpecOutWarehouseVo.class));
        return ApiResult.ok(resultPage);
    }

}

