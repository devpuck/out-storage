package com.wms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.OutWarehouseBillSubEntity;
import com.wms.mapper.outstorage.OutWarehouseBillSubMapper;
import com.wms.service.OutWarehouseBillSubService;
import com.wms.api.outstorage.OutWarehouseBillSubQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
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
 * 出库单子表 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Slf4j
@Service
public class OutWarehouseBillSubServiceImpl extends BaseServiceImpl<OutWarehouseBillSubMapper, OutWarehouseBillSubEntity> implements OutWarehouseBillSubService {

    @Autowired
    private OutWarehouseBillSubMapper outWarehouseBillSubMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOutWarehouseBillSub(OutWarehouseBillSubBo outWarehouseBillSub) {
        OutWarehouseBillSubEntity entity = new OutWarehouseBillSubEntity();
        BeanUtils.copyProperties(outWarehouseBillSub , entity);
        return super.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOutWarehouseBillSub(OutWarehouseBillSubBo outWarehouseBillSub) {
        OutWarehouseBillSubEntity entity = new OutWarehouseBillSubEntity();
        BeanUtils.copyProperties(outWarehouseBillSub , entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOutWarehouseBillSub(Long id) {
        return super.removeById(id);
    }

    @Override
    public OutWarehouseBillSubBo getOutWarehouseBillSubById(Serializable id) {
        return outWarehouseBillSubMapper.getOutWarehouseBillSubById(id);
    }

    @Override
    public Paging<OutWarehouseBillSubBo> getOutWarehouseBillSubPageList(OutWarehouseBillSubQueryParam outWarehouseBillSubQueryParam) {
        Page page = setPageParam(outWarehouseBillSubQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<OutWarehouseBillSubBo> iPage = outWarehouseBillSubMapper.getOutWarehouseBillSubPageList(page, outWarehouseBillSubQueryParam);
        return new Paging(iPage);
    }

    @Override
    public List<OutWarehouseBillSubBo> queryOutWarehouseBillSubByBillCode(String billCode) throws Exception
    {
        List<OutWarehouseBillSubEntity> outWarehouseBillSubEntityList = outWarehouseBillSubMapper.selectList(new QueryWrapper<OutWarehouseBillSubEntity>().lambda()
                .eq(OutWarehouseBillSubEntity::getBillCode,billCode));
        if(null == outWarehouseBillSubEntityList)
        {
            outWarehouseBillSubEntityList = new ArrayList<OutWarehouseBillSubEntity>();
        }

        return BeanListUtil.copyListProperties(outWarehouseBillSubEntityList,OutWarehouseBillSubBo.class);
    }

}
