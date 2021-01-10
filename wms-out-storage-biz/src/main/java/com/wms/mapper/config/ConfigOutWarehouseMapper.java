package com.wms.mapper.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.ConfigOutWarehouseEntity;
import com.wms.api.config.ConfigOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigOutWarehouseBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库业务配置 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2021-01-09
 */
@Repository
public interface ConfigOutWarehouseMapper extends BaseMapper<ConfigOutWarehouseEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ConfigOutWarehouseBo getConfigOutWarehouseById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param configOutWarehouseQueryParam
     * @return
     */
    IPage<ConfigOutWarehouseBo> getConfigOutWarehousePageList(@Param("page") Page page, @Param("param") ConfigOutWarehouseQueryParam configOutWarehouseQueryParam);


}
