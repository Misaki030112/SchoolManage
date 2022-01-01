package center.misaki.schoolgrade.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5UtilTest {

    @Test
    void string2MD5() {
        String s = MD5Util.string2MD5("12345678");
        System.out.println(s);
    }

    @Test
    void passwordIsTrue() {
        System.out.println(MD5Util.passwordIsTrue("12345678","25d55ad283aa400af464c76d713c07ad"));
    }
}