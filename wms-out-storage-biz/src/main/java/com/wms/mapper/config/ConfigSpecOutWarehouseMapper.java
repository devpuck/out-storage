package com.wms.mapper.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.ConfigSpecOutWarehouseEntity;
import com.wms.api.config.ConfigSpecOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSpecOutWarehouseBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库业务配置 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Repository
public interface ConfigSpecOutWarehouseMapper extends BaseMapper<ConfigSpecOutWarehouseEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ConfigSpecOutWarehouseBo getConfigSpecOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param configSpecOutWarehouseQueryParam
     * @return
     */
    IPage<ConfigSpecOutWarehouseBo> getConfigSpecOutWarehousePageList(@Param("page") Page page, @Param("param") ConfigSpecOutWarehouseQueryParam configSpecOutWarehouseQueryParam);

}
