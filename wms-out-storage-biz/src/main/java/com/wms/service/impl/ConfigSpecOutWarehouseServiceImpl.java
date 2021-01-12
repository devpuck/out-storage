package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.ConfigSpecOutWarehouseEntity;
import com.wms.mapper.config.ConfigSpecOutWarehouseMapper;
import com.wms.service.ConfigSpecOutWarehouseService;
import com.wms.api.config.ConfigSpecOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSpecOutWarehouseBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 出库业务配置 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-01-11
 */
@Slf4j
@Service
public class ConfigSpecOutWarehouseServiceImpl extends BaseServiceImpl<ConfigSpecOutWarehouseMapper, ConfigSpecOutWarehouseEntity> implements ConfigSpecOutWarehouseService {

    @Autowired
    private ConfigSpecOutWarehouseMapper configSpecOutWarehouseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveConfigSpecOutWarehouse(ConfigSpecOutWarehouseBo configSpecOutWarehouse) {
        ConfigSpecOutWarehouseEntity entity = new ConfigSpecOutWarehouseEntity();
        BeanUtils.copyProperties(configSpecOutWarehouse , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateConfigSpecOutWarehouse(ConfigSpecOutWarehouseBo configSpecOutWarehouse) {
        ConfigSpecOutWarehouseEntity entity = new ConfigSpecOutWarehouseEntity();
        BeanUtils.copyProperties(configSpecOutWarehouse , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteConfigSpecOutWarehouse(Long id) {
        return super.removeById(id);
    }

    @Override
    public ConfigSpecOutWarehouseBo getConfigSpecOutWarehouseById(Serializable id) {
        return configSpecOutWarehouseMapper.getConfigSpecOutWarehouseById(id);
    }

    @Override
    public Paging<ConfigSpecOutWarehouseBo> getConfigSpecOutWarehousePageList(ConfigSpecOutWarehouseQueryParam configSpecOutWarehouseQueryParam) {
        Page page = setPageParam(configSpecOutWarehouseQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<ConfigSpecOutWarehouseBo> iPage = configSpecOutWarehouseMapper.getConfigSpecOutWarehousePageList(page, configSpecOutWarehouseQueryParam);
        return new Paging(iPage);
    }

}
