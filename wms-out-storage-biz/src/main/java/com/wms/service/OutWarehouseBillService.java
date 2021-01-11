package com.wms.service;

import com.wms.model.entity.OutWarehouseBillEntity;
import com.xac.core.service.BaseService;
import com.wms.api.outstorage.OutWarehouseBillQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 出库单据 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
public interface OutWarehouseBillService extends BaseService<OutWarehouseBillEntity> {

    /**
     * 保存
     *
     * @param outWarehouseBill
     * @return
     * @throws Exception
     */
    boolean saveOutWarehouseBill(OutWarehouseBillBo outWarehouseBill)   throws Exception;

    /**
     * 修改
     *
     * @param outWarehouseBill
     * @return
     * @throws Exception
     */
    boolean updateOutWarehouseBill(OutWarehouseBillBo outWarehouseBill);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteOutWarehouseBill(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    OutWarehouseBillBo getOutWarehouseBillById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param outWarehouseBillQueryParam
     * @return
     * @throws Exception
     */
    Paging<OutWarehouseBillBo> getOutWarehouseBillPageList(OutWarehouseBillQueryParam outWarehouseBillQueryParam);

    /**
     * 根据需求ID查询单据ID
     * @param requirementID
     * @return
     */
    String queryOutWarehouseBillIDByRequirementID(String requirementID);

    /**
     * 根据出库单编号查询出库单ID
     * @param billCode
     * @return
     */
    String queryOutWarehouseBillIDByBillCode(String billCode);

}
