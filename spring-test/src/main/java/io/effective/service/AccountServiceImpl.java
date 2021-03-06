package io.effective.service;

import io.effective.dao.AmsAccountDao;
import io.effective.dto.Customer;
import io.effective.mapper.AmsAccountMapper;
import io.effective.model.AmsAccount;
import io.effective.model.AmsAccountExample;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    private final AmsAccountMapper accountMapper;
    private final AmsAccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AmsAccountMapper accountMapper, AmsAccountDao accountDao) {
        this.accountMapper = accountMapper;
        this.accountDao = accountDao;
    }

    @Override
    public AmsAccount create(AmsAccount account) {
        account.setId(1000L);
        account.setCreatedAt(new Date());
        accountMapper.insertSelective(account);
        return account;
    }

    @Override
    public AmsAccount getAmsAccountById(long accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    @Override
    public List<AmsAccount> list(long[] ids) {
        val example = new AmsAccountExample();
        val criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        val idList = new ArrayList<Long>();
        if (ids != null && ids.length > 0) {
            Arrays.stream(ids).forEach(idList::add);
            criteria.andIdIn(idList);
        }
        return accountMapper.selectByExample(example);
    }

    @Override
    public List<Customer> getCustomers(String opsUserId) {
        var list = accountDao.findCustomersByOpsUserId(opsUserId);
        list = accountDao.findCustomersByOpsUserId(opsUserId);
        list(new long[]{});
        return null;
    }
}