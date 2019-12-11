package main.java.com.glp;

import com.glp.Application;
import com.glp.utils.lamdaUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.function.Consumer;

/**
 * @author zmm
 * @date 2019/11/12
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class Test2 {
    @Autowired
    lamdaUtils<String> lamdaUtils;

    @Test

    public void print1() {
        lamdaUtils.Action(new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info(s);
            }
        }, "admin");

    }

}
