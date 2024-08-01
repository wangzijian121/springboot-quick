package com.zjyun.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjyun.springboot.entity.Account;
import com.zjyun.springboot.utils.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangzijian
 * @since 2024-07-30
 */
public interface IAccountService extends IService<Account> {

    Result queryAccountListPaging(Integer pageNo, Integer pageSize);

    Result deleteAccount(Integer id);
}
