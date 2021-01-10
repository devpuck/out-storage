package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.ConfigOutWarehouseEntity;
import com.wms.mapper.config.ConfigOutWarehouseMapper;
import com.wms.service.ConfigOutWarehouseService;
import com.wms.api.config.ConfigOutWarehouseQueryParam;
import com.wms.model.bo.config.ConfigOutWarehouseBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 * 出库业务配置 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2021-01-09
 */
@Slf4j
@Service
public class ConfigOutWarehouseServiceImpl extends BaseServiceImpl<ConfigOutWarehouseMapper, ConfigOutWarehouseEntity> implements ConfigOutWarehouseService
{

    @Autowired
    private ConfigOutWarehouseMapper configOutWarehouseMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveConfigOutWarehouse(ConfigOutWarehouseBo configOutWarehouse)
    {
        ConfigOutWarehouseEntity entity = new ConfigOutWarehouseEntity();
        BeanUtils.copyProperties(configOutWarehouse, entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateConfigOutWarehouse(ConfigOutWarehouseBo configOutWarehouse)
    {
        ConfigOutWarehouseEntity entity = new ConfigOutWarehouseEntity();
        BeanUtils.copyProperties(configOutWarehouse, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteConfigOutWarehouse(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public ConfigOutWarehouseBo getConfigOutWarehouseById(Serializable id)
    {
        return configOutWarehouseMapper.getConfigOutWarehouseById(id);
    }

    @Override
    public Paging<ConfigOutWarehouseBo> getConfigOutWarehousePageList(ConfigOutWarehouseQueryParam configOutWarehouseQueryParam)
    {
        Page page = setPageParam(configOutWarehouseQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<ConfigOutWarehouseBo> iPage = configOutWarehouseMapper.getConfigOutWarehousePageList(page, configOutWarehouseQueryParam);
        return new Paging(iPage);
    }

    @Override
    public ConfigOutWarehouseBo queryOutWarehouseConfig(String warehouseCode, String workCode, String dealCode, String needProductionStatus)
    {
        ConfigOutWarehouseEntity configOutWarehouseEntity = configOutWarehouseMapper.selectOne(new QueryWrapper<ConfigOutWarehouseEntity>().lambda()
                .eq(ConfigOutWarehouseEntity::getWarehouseCode,warehouseCode)
                .eq(ConfigOutWarehouseEntity::getWarehouseWorkCode,workCode)
                .eq(ConfigOutWarehouseEntity::getWarehouseDealCode,dealCode)
                .eq(ConfigOutWarehouseEntity::getNeedProductionStatus,needProductionStatus));
        if(null != configOutWarehouseEntity)
        {
            ConfigOutWarehouseBo configOutWarehouseBo = new ConfigOutWarehouseBo();
            BeanUtils.copyProperties(configOutWarehouseEntity,configOutWarehouseBo);
            return configOutWarehouseBo;
        }

        return null;
    }

    @Override
    public List<ConfigOutWarehouseBo> queryWarehouseConfig(String warehouseCode)  throws Exception
    {
        List<ConfigOutWarehouseEntity> configOutWarehouseEntityList = configOutWarehouseMapper.selectList(new QueryWrapper<ConfigOutWarehouseEntity>().lambda()
                .eq(ConfigOutWarehouseEntity::getWarehouseCode,warehouseCode));
        if(null != configOutWarehouseEntityList)
        {
            List<ConfigOutWarehouseBo> configOutWarehouseBoList = new ArrayList<ConfigOutWarehouseBo>();
            configOutWarehouseBoList = BeanListUtil.copyListProperties(configOutWarehouseEntityList,ConfigOutWarehouseBo.class);
            return configOutWarehouseBoList;
        }
        return null;
    }

    @Override
    public boolean checkCanOutWarehouse(String warehouseCode, String workCode, String dealCode,String status)
    {
        if(null == dealCode || "".equals(dealCode))
        {
            dealCode = workCode;
        }


        return false;
    }

}
