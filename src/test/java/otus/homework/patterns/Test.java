package otus.homework.patterns;

import org.springframework.util.Assert;

public class Test {

    boolean m = true;
    @org.junit.jupiter.api.Test
    public void test(){
       Assert.isTrue(m,"это верно");
    }

}
