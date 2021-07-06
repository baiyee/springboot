package com.zx.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Closeable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
		Runnable r = () -> {};
		Closeable c = () -> {};

		Consumer<String> c2 = (a) -> {};
		Consumer<String> c3 = a -> {};
		Consumer<String> c4 = (String a) -> {};

		Supplier<String> s1 = () -> "hello";
		Supplier<String>  s2 = () -> {
			//具体的业务逻辑
			return "hello";
		};

		Function<String,Integer> f1 = (str) -> Integer.valueOf(str);
		Function<String, Integer> f2 = (String str) -> Integer.valueOf(str);
		Function<String, Integer> f3 = (String str) -> {
			//具体实现逻辑
			return Integer.valueOf(str);
		};
	}

}
