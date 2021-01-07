package com.wms.mapper.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.ConfigSepcOutWarehouseEntity;
import com.wms.api.config.ConfigSepcOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSepcOutWarehouseBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库业务配置 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Repository
public interface ConfigSepcOutWarehouseMapper extends BaseMapper<ConfigSepcOutWarehouseEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ConfigSepcOutWarehouseBo getConfigSepcOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param configSepcOutWarehouseQueryParam
     * @return
     */
    IPage<ConfigSepcOutWarehouseBo> getConfigSepcOutWarehousePageList(@Param("page") Page page, @Param("param") ConfigSepcOutWarehouseQueryParam configSepcOutWarehouseQueryParam);

}
