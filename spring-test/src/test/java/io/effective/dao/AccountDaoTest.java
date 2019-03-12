package io.effective.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.effective.model.AmsAccount;
import io.effective.model.Person;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountDaoTest {
    @Autowired
    private AmsAccountDao accountDao;

    @Test
    public void pageHelperTest() {
//        PageHelper.startPage(0, 1);
//        accountDao.findCustomersByOpsUserId("ba7ee581842a4a378f276ca605cd6a68");
        val page = PageHelper.startPage(0, 1)
                .doSelectPage(() -> accountDao.findCustomersByOpsUserId("ba7ee581842a4a378f276ca605cd6a68"));
        System.out.println(JSON.toJSONString(page, SerializerFeature.PrettyFormat));
    }

    @Test
    public void pageRequestTest() {
//        val p =new Person("a");
        val pr = PageRequest.of(1, 1, Sort.Direction.ASC, "a", "bc");
        System.out.println(JSON.toJSONString(pr, SerializerFeature.PrettyFormat));
    }
}
