package com.wms.service;

import com.wms.model.entity.OutWarehouseBillSubEntity;
import com.xac.core.service.BaseService;
import com.wms.api.outstorage.OutWarehouseBillSubQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 出库单子表 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
public interface OutWarehouseBillSubService extends BaseService<OutWarehouseBillSubEntity> {

    /**
     * 保存
     *
     * @param outWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean saveOutWarehouseBillSub(OutWarehouseBillSubBo outWarehouseBillSub);

    /**
     * 修改
     *
     * @param outWarehouseBillSub
     * @return
     * @throws Exception
     */
    boolean updateOutWarehouseBillSub(OutWarehouseBillSubBo outWarehouseBillSub);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteOutWarehouseBillSub(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    OutWarehouseBillSubBo getOutWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param outWarehouseBillSubQueryParam
     * @return
     * @throws Exception
     */
    Paging<OutWarehouseBillSubBo> getOutWarehouseBillSubPageList(OutWarehouseBillSubQueryParam outWarehouseBillSubQueryParam);

    /**
     *
     * @param billCode
     * @return
     */
    List<OutWarehouseBillSubBo> queryOutWarehouseBillSubByBillCode(String billCode)  throws Exception;

}
