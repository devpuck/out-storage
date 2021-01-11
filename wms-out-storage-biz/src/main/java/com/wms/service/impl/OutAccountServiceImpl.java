package com.wms.service.impl;

import com.wms.api.account.AccountVo;
import com.wms.api.account.OutWarehouseAccountVo;
import com.wms.errorcode.ErrorCode;
import com.wms.sdk.account.QueryAccountManager;
import com.wms.service.OutAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author puck
 * @date 2021/1/10 6:00 下午
 */
@Slf4j
@Service
public class OutAccountServiceImpl implements OutAccountService
{

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int createOutAccount(OutWarehouseAccountVo outWarehouseAccountVo) throws Exception
    {
        String accountCode = outWarehouseAccountVo.getAccountCode();
        QueryAccountManager queryAccountManager = new QueryAccountManager();
        AccountVo accountVo = queryAccountManager.queryAccountByAccountCode(accountCode);
        if(null == accountVo)
        {
            return ErrorCode.ERROR;
        }

        BigDecimal accountQuantity = accountVo.getQuantity();
        BigDecimal outQuantity = outWarehouseAccountVo.getQuantity();
        BigDecimal tryQuantity = outWarehouseAccountVo.getTryQuantity();
        if(null != tryQuantity)
        {
            outQuantity = outQuantity.add(tryQuantity);
        }

        //库存数量不足，不允许出库
        if(0 < (accountQuantity.compareTo(outQuantity)))
        {
            return ErrorCode.ERROR;
        }

        if(!checkStatusCanOutWarehouse(outWarehouseAccountVo))
        {
            return ErrorCode.ERROR;
        }

        return ErrorCode.ERROR;
    }

    /**
     * 判断当前库存状态是否允许出库
     * @param outWarehouseAccountVo
     * @return
     */
    boolean checkStatusCanOutWarehouse(OutWarehouseAccountVo outWarehouseAccountVo)
    {
        return true;
    }
}
