package com.wms.service;

import com.wms.model.entity.ConfigSepcOutWarehouseEntity;
import com.xac.core.service.BaseService;
import com.wms.api.config.ConfigSepcOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSepcOutWarehouseBo;
import com.xac.core.api.Paging;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 出库业务配置 服务类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
public interface ConfigSepcOutWarehouseService extends BaseService<ConfigSepcOutWarehouseEntity> {

    /**
     * 保存
     *
     * @param configSepcOutWarehouse
     * @return
     * @throws Exception
     */
    boolean saveConfigSepcOutWarehouse(ConfigSepcOutWarehouseBo configSepcOutWarehouse);

    /**
     * 修改
     *
     * @param configSepcOutWarehouse
     * @return
     * @throws Exception
     */
    boolean updateConfigSepcOutWarehouse(ConfigSepcOutWarehouseBo configSepcOutWarehouse);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteConfigSepcOutWarehouse(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ConfigSepcOutWarehouseBo getConfigSepcOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param configSepcOutWarehouseQueryParam
     * @return
     * @throws Exception
     */
    Paging<ConfigSepcOutWarehouseBo> getConfigSepcOutWarehousePageList(ConfigSepcOutWarehouseQueryParam configSepcOutWarehouseQueryParam);

    /**
     * 查询仓库特殊配置
     * @param warehouseCode
     * @return
     */
    List<ConfigSepcOutWarehouseBo> queryWarehouseSpecConfig(String warehouseCode) throws Exception;

}
