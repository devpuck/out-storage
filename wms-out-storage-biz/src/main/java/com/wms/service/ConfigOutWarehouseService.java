package com.wms.service;

import com.wms.model.entity.ConfigOutWarehouseEntity;
import com.xac.core.service.BaseService;
import com.wms.api.config.ConfigOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigOutWarehouseBo;
import com.xac.core.api.Paging;
import sun.security.krb5.Config;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 出库业务配置 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-01-09
 */
public interface ConfigOutWarehouseService extends BaseService<ConfigOutWarehouseEntity> {

    /**
     * 保存
     *
     * @param configOutWarehouse
     * @return
     * @throws Exception
     */
    boolean saveConfigOutWarehouse(ConfigOutWarehouseBo configOutWarehouse);

    /**
     * 修改
     *
     * @param configOutWarehouse
     * @return
     * @throws Exception
     */
    boolean updateConfigOutWarehouse(ConfigOutWarehouseBo configOutWarehouse);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteConfigOutWarehouse(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ConfigOutWarehouseBo getConfigOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param configOutWarehouseQueryParam
     * @return
     * @throws Exception
     */
    Paging<ConfigOutWarehouseBo> getConfigOutWarehousePageList(ConfigOutWarehouseQueryParam configOutWarehouseQueryParam);

    /**
     *
     * @param warehouseCode
     * @param workCode
     * @param dealCode
     * @return
     */
    ConfigOutWarehouseBo queryOutWarehouseConfig(String warehouseCode, String workCode, String dealCode, String needProductionStatus);

    /**
     * 查询可以出库的列表
     * @param warehouseCode
     * @return
     */
    List<ConfigOutWarehouseBo> queryWarehouseConfig(String warehouseCode)  throws Exception;

    /**
     * 判断当前状态是否可以出库
     * @param warehouseCode
     * @param workCode
     * @param dealCode
     * @param status
     * @return
     */
    boolean checkCanOutWarehouse(String warehouseCode,String workCode,String dealCode,String status);

}
