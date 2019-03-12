package io.effective.mapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageHelper;
import io.effective.dao.AmsAccountDao;
import io.effective.model.AmsAccount;
import io.effective.model.AmsAccountExample;
import io.effective.model.Person;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;
import tk.mybatis.mapper.weekend.WeekendSqls;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountMapperTest {

    @Autowired
    SqlSessionFactory sf;
    @Autowired
    AmsAccountMapper accountMapper;

    @Test
    public void l1_cache_test() {
        val id = 100000933270L;
        val session1 = sf.openSession(true);
        val session2 = sf.openSession(true);
        val accMapper1 = session1.getMapper(AmsAccountDao.class);
        val accMapper2 = session2.getMapper(AmsAccountDao.class);

        var acc1 = accMapper1.getAccountByName(id);
        var acc2 = accMapper2.getAccountByName(id);
        accMapper1.updateAccountName(id, "hello");
        acc1 = accMapper1.getAccountByName(id);
        session1.commit();
        acc2 = accMapper2.getAccountByName(id);
        System.out.println("====== Account acc1 id: " + acc1.getId() + ", name: " + acc1.getName());
        System.out.println("====== Account acc2 id: " + acc2.getId() + ", name: " + acc2.getName());
    }

    @Test
    public void mapperTest() {
        val id = 100000933270L;
//        val account = accountMapper.selectByPrimaryKey(id);
//        val example = new AmsAccountExample();
        val query = new AmsAccount();
        query.setName("JJJJgongsi");
        query.setDeleted(false);
        System.out.println("\n\n\n");
        System.out.println(accountMapper.selectOne(query));
        System.out.println("\n\n\n");
    }

    @Test
    public void mapperPageHelperTest() {
        val id = 100000933270L;
//        val example = Example.builder(AmsAccount.class)
//                .where(WeekendSqls.<AmsAccount>custom().andEqualTo(AmsAccount::getId, id))
//                .build();
        val example = Example.builder(AmsAccount.class)
                .where(Sqls.custom().andNotEqualTo(AmsAccount.ID, 1L)
                        .andEqualTo(AmsAccount.DELETED, false)).build();
        val page = PageHelper.startPage(-1, 1).doSelectPage(
                () -> accountMapper.selectByExample(example)
        );
        System.out.println(JSON.toJSONString(page, SerializerFeature.PrettyFormat));
    }

    @Test
    public void lombokToStringTest() {
        val example = Example.builder(AmsAccount.class)
                .select(AmsAccount.ID)
                .orderByDesc(AmsAccount.CREATED_AT)
                .build();
        val page = PageHelper.startPage(1, 1).doSelectPage(() -> accountMapper.selectOneByExample(example));
        System.out.println("lastId=" + page.getEndRow() + "," + page.getStartRow());
    }
}
