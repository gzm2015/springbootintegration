package com.lmk.springboot;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuMengKe
 * @create 2018-06-13-14:39
 * ActiveProfiles 使用测试环境测试
 * webEnvironment 随机端口号测试
 * ignore 测试时忽略本类
 *
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class BaseTest {
}
