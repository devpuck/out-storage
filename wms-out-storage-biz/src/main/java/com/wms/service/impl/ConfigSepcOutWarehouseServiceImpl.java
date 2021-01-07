package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.ConfigSepcOutWarehouseEntity;
import com.wms.mapper.config.ConfigSepcOutWarehouseMapper;
import com.wms.service.ConfigSepcOutWarehouseService;
import com.wms.api.config.ConfigSepcOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigSepcOutWarehouseBo;
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
 * @since 2020-12-22
 */
@Slf4j
@Service
public class ConfigSepcOutWarehouseServiceImpl extends BaseServiceImpl<ConfigSepcOutWarehouseMapper, ConfigSepcOutWarehouseEntity> implements ConfigSepcOutWarehouseService {

    @Autowired
    private ConfigSepcOutWarehouseMapper configSepcOutWarehouseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveConfigSepcOutWarehouse(ConfigSepcOutWarehouseBo configSepcOutWarehouse) {
        ConfigSepcOutWarehouseEntity entity = new ConfigSepcOutWarehouseEntity();
        BeanUtils.copyProperties(configSepcOutWarehouse , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateConfigSepcOutWarehouse(ConfigSepcOutWarehouseBo configSepcOutWarehouse) {
        ConfigSepcOutWarehouseEntity entity = new ConfigSepcOutWarehouseEntity();
        BeanUtils.copyProperties(configSepcOutWarehouse , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteConfigSepcOutWarehouse(Long id) {
        return super.removeById(id);
    }

    @Override
    public ConfigSepcOutWarehouseBo getConfigSepcOutWarehouseById(Serializable id) {
        return configSepcOutWarehouseMapper.getConfigSepcOutWarehouseById(id);
    }

    @Override
    public Paging<ConfigSepcOutWarehouseBo> getConfigSepcOutWarehousePageList(ConfigSepcOutWarehouseQueryParam configSepcOutWarehouseQueryParam) {
        Page page = setPageParam(configSepcOutWarehouseQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<ConfigSepcOutWarehouseBo> iPage = configSepcOutWarehouseMapper.getConfigSepcOutWarehousePageList(page, configSepcOutWarehouseQueryParam);
        return new Paging(iPage);
    }

}
