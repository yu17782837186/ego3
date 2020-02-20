package com.ego.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbContentDubboService;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Reference
    private TbContentDubboService tbContentDubboServiceImpl;

    @Override
    public EasyUIDataGrid showContent(long categoryId, int page, int rows) {
        return tbContentDubboServiceImpl.selContentByPage(categoryId, page, rows);
    }
    @Override
    public int save(TbContent content) {
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);
        return tbContentDubboServiceImpl.insContent(content);
    }
}
