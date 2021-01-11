package com.wms.service;

import com.wms.api.account.OutWarehouseAccountVo;

/**
 * @author puck
 * @date 2021/1/10 5:56 下午
 */
public interface OutAccountService
{
    /**
     * 出库过账
     * @param outWarehouseAccountVo
     * @return
     */
    public int createOutAccount(OutWarehouseAccountVo outWarehouseAccountVo) throws Exception;
}
