package com.wms.service;

import com.wms.model.entity.ConfigSpecOutWarehouseEntity;
import com.xac.core.service.BaseService;
import com.wms.api.config.ConfigSpecOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSpecOutWarehouseBo;
import com.xac.core.api.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 出库业务配置 服务类
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
public interface ConfigSpecOutWarehouseService extends BaseService<ConfigSpecOutWarehouseEntity> {

    /**
     * 保存
     *
     * @param configSpecOutWarehouse
     * @return
     * @throws Exception
     */
    boolean saveConfigSpecOutWarehouse(ConfigSpecOutWarehouseBo configSpecOutWarehouse);

    /**
     * 修改
     *
     * @param configSpecOutWarehouse
     * @return
     * @throws Exception
     */
    boolean updateConfigSpecOutWarehouse(ConfigSpecOutWarehouseBo configSpecOutWarehouse);

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteConfigSpecOutWarehouse(Long id);

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ConfigSpecOutWarehouseBo getConfigSpecOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param configSpecOutWarehouseQueryParam
     * @return
     * @throws Exception
     */
    Paging<ConfigSpecOutWarehouseBo> getConfigSpecOutWarehousePageList(ConfigSpecOutWarehouseQueryParam configSpecOutWarehouseQueryParam);

}
