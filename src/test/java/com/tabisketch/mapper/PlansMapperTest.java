package com.tabisketch.mapper;

import com.tabisketch.bean.Plan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlansMapperTest {
    @Autowired
    private IPlansMapper plansMapper;

    @ParameterizedTest
    // NOTE: 存在するテストデータに合わせて以下を書き換える
    @ValueSource(ints = {1})
    public void SELECTできるか(final int userId) throws Exception {
        final List<Plan> planList = plansMapper.selectByUserId(userId);
        assert planList != null;
        assert !planList.isEmpty();
    }
}