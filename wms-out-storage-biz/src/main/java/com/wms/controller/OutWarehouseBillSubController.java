package com.wms.controller;

import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.OutWarehouseBillSubEntity;
import com.wms.service.OutWarehouseBillSubService;
import com.wms.api.outstorage.OutWarehouseBillSubQueryParam;
import com.wms.api.outstorage.OutWarehouseBillSubVo;
import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
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
 * 出库单子表 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Slf4j
@RestController
@RequestMapping("/outstorage")
@Api("出库单子表 API")
public class OutWarehouseBillSubController extends BaseController {

    @Autowired
    private OutWarehouseBillSubService outWarehouseBillSubService;

    /**
     * 添加出库单子表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OutWarehouseBillSub对象", notes = "添加出库单子表", response = ApiResult.class)
    public ApiResult<Boolean> addOutWarehouseBillSub(@Valid @RequestBody OutWarehouseBillSubVo outWarehouseBillSub) throws Exception {
         OutWarehouseBillSubBo bo = new OutWarehouseBillSubBo();
        BeanUtils.copyProperties(outWarehouseBillSub,bo);

        boolean flag = outWarehouseBillSubService.saveOutWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库单子表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OutWarehouseBillSub对象", notes = "修改出库单子表", response = ApiResult.class)
    public ApiResult<Boolean> updateOutWarehouseBillSub(@Valid @RequestBody OutWarehouseBillSubVo outWarehouseBillSub) throws Exception {
        OutWarehouseBillSubBo bo = new OutWarehouseBillSubBo();
        BeanUtils.copyProperties(outWarehouseBillSub,bo);

        boolean flag = outWarehouseBillSubService.updateOutWarehouseBillSub(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库单子表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除OutWarehouseBillSub对象", notes = "删除出库单子表", response = ApiResult.class)
    public ApiResult<Boolean> deleteOutWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        boolean flag = outWarehouseBillSubService.deleteOutWarehouseBillSub(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库单子表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取OutWarehouseBillSub对象详情", notes = "查看出库单子表", response = OutWarehouseBillSubVo.class)
    public ApiResult<OutWarehouseBillSubVo> getOutWarehouseBillSub(@PathVariable("id") Long id) throws Exception {
        OutWarehouseBillSubBo outWarehouseBillSubBo = outWarehouseBillSubService.getOutWarehouseBillSubById(id);
        OutWarehouseBillSubVo queryVo = null;
        if (outWarehouseBillSubBo != null) {
            queryVo = new OutWarehouseBillSubVo();
            BeanUtils.copyProperties(outWarehouseBillSubBo , queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库单子表分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取OutWarehouseBillSub分页列表", notes = "出库单子表分页列表", response = OutWarehouseBillSubVo.class)
    public ApiResult<Paging<OutWarehouseBillSubVo>> getOutWarehouseBillSubPageList(@Valid @RequestBody OutWarehouseBillSubQueryParam outWarehouseBillSubQueryParam) throws Exception {
        Paging<OutWarehouseBillSubBo> paging = outWarehouseBillSubService.getOutWarehouseBillSubPageList(outWarehouseBillSubQueryParam);
        Paging<OutWarehouseBillSubVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), OutWarehouseBillSubVo.class));
        return ApiResult.ok(resultPage);
    }

}

