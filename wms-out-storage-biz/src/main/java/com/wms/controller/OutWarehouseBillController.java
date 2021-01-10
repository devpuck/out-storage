package com.wms.controller;

import com.wms.api.outstorage.OutWarehouseBillSubVo;
import com.wms.errorcode.ErrorCode;
import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
import com.xac.core.util.BeanListUtil;
import com.wms.model.entity.OutWarehouseBillEntity;
import com.wms.service.OutWarehouseBillService;
import com.wms.api.outstorage.OutWarehouseBillQueryParam;
import com.wms.api.outstorage.OutWarehouseBillVo;
import com.wms.model.bo.outstorage.OutWarehouseBillBo;
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

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 出库单据 前端控制器
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@RestController
@RequestMapping("/outstorage")
@Api("出库单据 API")
public class OutWarehouseBillController extends BaseController
{

    @Autowired
    private OutWarehouseBillService outWarehouseBillService;

    /**
     * 添加出库单据
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加OutWarehouseBill对象", notes = "添加出库单据", response = ApiResult.class)
    public ApiResult<Boolean> addOutWarehouseBill(@Valid @RequestBody OutWarehouseBillVo outWarehouseBill) throws Exception
    {
        String requirementID = outWarehouseBill.getRequirementId();
        if(null != requirementID && (!"".equals(requirementID)))
        {
            String billID = outWarehouseBillService.queryOutWarehouseBillIDByRequirementID(requirementID);
            if(null != billID)
            {
                ApiResult apiResult = new ApiResult();
                apiResult.setCode(ErrorCode.WAREHOUSE_REQUIREMENT_CODE_REPEAT);
                apiResult.setMsg(ErrorCode.WAREHOUSE_REQUIREMENT_CODE_REPEAT_MESSAGE);
                apiResult.setSuccess(false);
                return apiResult;
            }
        }

        OutWarehouseBillBo bo = new OutWarehouseBillBo();
        BeanUtils.copyProperties(outWarehouseBill, bo);

        List<OutWarehouseBillSubVo> outWarehouseBillSubVoList = outWarehouseBill.getOutWarehouseBillSubVoList();
        if(null != outWarehouseBillSubVoList)
        {
            List<OutWarehouseBillSubBo> outWarehouseBillSubBoList  = new ArrayList<OutWarehouseBillSubBo>();
            outWarehouseBillSubBoList = BeanListUtil.copyListProperties(outWarehouseBillSubVoList,OutWarehouseBillSubBo.class);
            bo.setOutWarehouseBillSubBoList(outWarehouseBillSubBoList);
        }

        boolean flag = outWarehouseBillService.saveOutWarehouseBill(bo);
        return ApiResult.result(flag);
    }

    /**
     * 修改出库单据
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改OutWarehouseBill对象", notes = "修改出库单据", response = ApiResult.class)
    public ApiResult<Boolean> updateOutWarehouseBill(@Valid @RequestBody OutWarehouseBillVo outWarehouseBill) throws Exception
    {
        OutWarehouseBillBo bo = new OutWarehouseBillBo();
        BeanUtils.copyProperties(outWarehouseBill, bo);

        boolean flag = outWarehouseBillService.updateOutWarehouseBill(bo);
        return ApiResult.result(flag);
    }

    /**
     * 删除出库单据
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除OutWarehouseBill对象", notes = "删除出库单据", response = ApiResult.class)
    public ApiResult<Boolean> deleteOutWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        boolean flag = outWarehouseBillService.deleteOutWarehouseBill(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取出库单据
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取OutWarehouseBill对象详情", notes = "查看出库单据", response = OutWarehouseBillVo.class)
    public ApiResult<OutWarehouseBillVo> getOutWarehouseBill(@PathVariable("id") Long id) throws Exception
    {
        OutWarehouseBillBo outWarehouseBillBo = outWarehouseBillService.getOutWarehouseBillById(id);
        OutWarehouseBillVo queryVo = null;
        if (outWarehouseBillBo != null)
        {
            queryVo = new OutWarehouseBillVo();
            BeanUtils.copyProperties(outWarehouseBillBo, queryVo);
        }
        return ApiResult.ok(queryVo);
    }

    /**
     * 出库单据分页列表
     */
    @PostMapping("/pagelist")
    @ApiOperation(value = "获取OutWarehouseBill分页列表", notes = "出库单据分页列表", response = OutWarehouseBillVo.class)
    public ApiResult<Paging<OutWarehouseBillVo>> getOutWarehouseBillPageList(@Valid @RequestBody OutWarehouseBillQueryParam outWarehouseBillQueryParam) throws Exception
    {
        Paging<OutWarehouseBillBo> paging = outWarehouseBillService.getOutWarehouseBillPageList(outWarehouseBillQueryParam);
        Paging<OutWarehouseBillVo> resultPage = new Paging<>();
        resultPage.setTotal(paging.getTotal());
        resultPage.setRecords(BeanListUtil.copyListProperties(paging.getRecords(), OutWarehouseBillVo.class));
        return ApiResult.ok(resultPage);
    }

}

