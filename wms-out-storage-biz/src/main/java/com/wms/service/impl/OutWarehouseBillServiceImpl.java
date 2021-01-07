package com.wms.service.impl;

import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.OutWarehouseBillEntity;
import com.wms.mapper.outstorage.OutWarehouseBillMapper;
import com.wms.service.OutWarehouseBillService;
import com.wms.api.outstorage.OutWarehouseBillQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillBo;
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
 * 出库单据 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@Service
public class OutWarehouseBillServiceImpl extends BaseServiceImpl<OutWarehouseBillMapper, OutWarehouseBillEntity> implements OutWarehouseBillService {

    @Autowired
    private OutWarehouseBillMapper outWarehouseBillMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOutWarehouseBill(OutWarehouseBillBo outWarehouseBill) {
        OutWarehouseBillEntity entity = new OutWarehouseBillEntity();
        BeanUtils.copyProperties(outWarehouseBill , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOutWarehouseBill(OutWarehouseBillBo outWarehouseBill) {
        OutWarehouseBillEntity entity = new OutWarehouseBillEntity();
        BeanUtils.copyProperties(outWarehouseBill , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOutWarehouseBill(Long id) {
        return super.removeById(id);
    }

    @Override
    public OutWarehouseBillBo getOutWarehouseBillById(Serializable id) {
        return outWarehouseBillMapper.getOutWarehouseBillById(id);
    }

    @Override
    public Paging<OutWarehouseBillBo> getOutWarehouseBillPageList(OutWarehouseBillQueryParam outWarehouseBillQueryParam) {
        Page page = setPageParam(outWarehouseBillQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<OutWarehouseBillBo> iPage = outWarehouseBillMapper.getOutWarehouseBillPageList(page, outWarehouseBillQueryParam);
        return new Paging(iPage);
    }

}
