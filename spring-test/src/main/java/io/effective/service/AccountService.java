package io.effective.service;

import io.effective.mapper.AmsAccountMapper;
import io.effective.model.AmsAccount;
import io.effective.model.AmsAccountExample;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private AmsAccountMapper accountMapper;

    @Transactional
    public void create(AmsAccount account) {
        account.setId(1000L);
        account.setCreatedAt(new Date());
        accountMapper.insertSelective(account);
    }

    public AmsAccount get(Long accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    public List<AmsAccount> list(Long[] ids) {
        val example = new AmsAccountExample();
        val criteria = example.createCriteria();
        criteria.andDeletedEqualTo(false);
        if (ids != null && ids.length > 0)
            criteria.andIdIn(Arrays.asList(ids));
        return accountMapper.selectByExample(example);
    }
}
