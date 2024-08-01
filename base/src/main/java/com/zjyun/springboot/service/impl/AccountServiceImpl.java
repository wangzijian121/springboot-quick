package com.zjyun.springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjyun.springboot.entity.Account;
import com.zjyun.springboot.enums.Status;
import com.zjyun.springboot.mapper.AccountMapper;
import com.zjyun.springboot.service.IAccountService;
import com.zjyun.springboot.utils.PageInfo;
import com.zjyun.springboot.utils.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangzijian
 * @since 2024-07-30
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    @Transactional
    public Result queryAccountListPaging(Integer pageNo, Integer pageSize) {

        Result result = new Result();
        PageInfo<Account> pageInfo = new PageInfo<>(pageNo, pageSize);
        Page<Account> page = new Page<>(pageNo, pageSize);
        IPage<Account> accountPage = baseMapper.selectPage(page, null);
        IPage<Account> accountPage2 = baseMapper.selectPage(page, null);
        System.out.println(accountPage2);
        List<Account> accountList = accountPage.getRecords();
        pageInfo.setTotal((int) accountPage.getTotal());
        pageInfo.setTotalList(accountList);
        result.setData(pageInfo);
        putMsg(result, Status.SUCCESS);
        return result;
    }

    @Override
    @Transactional
    public Result deleteAccount(Integer id) {
        Result result = new Result();
        baseMapper.deleteById(id);
        putMsg(result, Status.SUCCESS);
        result.setData(Boolean.TRUE);
        return result;
    }

}
