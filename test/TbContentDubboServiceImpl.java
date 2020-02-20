package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbContentDubboService;
import com.ego.mapper.TbContentMapper;
import com.ego.pojo.TbContent;
import com.ego.pojo.TbContentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

public class TbContentDubboServiceImpl implements TbContentDubboService {
    @Resource
    private TbContentMapper tbContentMapper;
    @Override
    public EasyUIDataGrid selContentByPage(long categoryId, int page, int rows) {
        PageHelper.startPage(page, rows);
        TbContentExample example = new TbContentExample();
        if(categoryId!=0){
            example.createCriteria().andCategoryIdEqualTo(categoryId);
        }
        List<TbContent> list = tbContentMapper.selectByExampleWithBLOBs(example);

        PageInfo<TbContent> pi = new PageInfo<>(list);

        EasyUIDataGrid datagrid = new EasyUIDataGrid();
        datagrid.setRows(pi.getList());
        datagrid.setTotal(pi.getTotal());
        return datagrid;
    }
    @Override
    public int insContent(TbContent content) {
        return tbContentMapper.insertSelective(content);
    }
}
