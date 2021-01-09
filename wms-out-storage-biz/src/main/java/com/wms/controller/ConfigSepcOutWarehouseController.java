package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.ConfigSepcOutWarehouseEntity;
import com.wms.service.ConfigSepcOutWarehouseService;
import com.wms.api.config.ConfigSepcOutWarehouseQueryParam;
import com.wms.api.config.ConfigSepcOutWarehouseVo;
import com.wms.model.bo.config.ConfigSepcOutWarehouseBo;
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
public class ConfigSepcOutWarehouseController extends BaseController
{

    @Autowired
    private ConfigSepcOutWarehouseService configSepcOutWarehouseService;

    /**
     * 添加出库业务配置
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ConfigSepcOutWarehouse对象", notes = "添加出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> addConfigSepcOutWarehouse(@Valid @RequestBody ConfigSepcOutWarehouseVo configSepcOutWarehouse) throws Exception
    {
        ConfigSepcOutWarehouseBo bo = new ConfigSepcOutWarehouseBo();
        BeanUtils.copyProperties(configSepcOutWarehouse, bo);

        boolean flag = configSepcOutWarehouseService.saveConfigSepcOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库业务配置
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ConfigSepcOutWarehouse对象", notes = "修改出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> updateConfigSepcOutWarehouse(@Valid @RequestBody ConfigSepcOutWarehouseVo configSepcOutWarehouse) throws Exception
    {
        ConfigSepcOutWarehouseBo bo = new ConfigSepcOutWarehouseBo();
        BeanUtils.copyProperties(configSepcOutWarehouse, bo);

        boolean flag = configSepcOutWarehouseService.updateConfigSepcOutWarehouse(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库业务配置
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除ConfigSepcOutWarehouse对象", notes = "删除出库业务配置", response = ApiResult.class)
    public ApiResult<Boolean> deleteConfigSepcOutWarehouse(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = configSepcOutWarehouseService.deleteConfigSepcOutWarehouse(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库业务配置
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取ConfigSepcOutWarehouse对象详情", notes = "查看出库业务配置", response = ConfigSepcOutWarehouseVo.class)
    public ApiResult<ConfigSepcOutWarehouseVo> getConfigSepcOutWarehouse(@PathVariable("id") Long id) throws Exception
    {
        ConfigSepcOutWarehouseBo configSepcOutWarehouseBo = configSepcOutWarehouseService.getConfigSepcOutWarehouseById(id);
        ConfigSepcOutWarehouseVo queryVo = null;
        if (configSepcOutWarehouseBo != null)
        {
            queryVo = new ConfigSepcOutWarehouseVo();
            BeanUtils.copyProperties(configSepcOutWarehouseBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库业务配置分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取ConfigSepcOutWarehouse分页列表", notes = "出库业务配置分页列表", response = ConfigSepcOutWarehouseVo.class)
    public ApiResult<Paging<ConfigSepcOutWarehouseVo>> getConfigSepcOutWarehousePageList(@Valid @RequestBody ConfigSepcOutWarehouseQueryParam configSepcOutWarehouseQueryParam) throws Exception
    {
        Paging<ConfigSepcOutWarehouseBo> paging = configSepcOutWarehouseService.getConfigSepcOutWarehousePageList(configSepcOutWarehouseQueryParam);
        Paging<ConfigSepcOutWarehouseVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), ConfigSepcOutWarehouseVo.class));
        return ApiResult.ok(resultPage);
    }

}

