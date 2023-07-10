package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  // ElementType.TYPE 은 클레스레벨에 붙는다
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
