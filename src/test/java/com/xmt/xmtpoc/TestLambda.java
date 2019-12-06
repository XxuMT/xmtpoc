package com.xmt.xmtpoc;

import com.xmt.xmtpoc.dto.domain.UserInfo;
import com.xmt.xmtpoc.lambda.LambdaInterface;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author mengting.xu
 * @version 1.0
 * @Description: 测试Lambda
 * @date 2019/8/22
 */
@SpringBootTest
public class TestLambda {

    @Test
    public void testLambda() {
    func(
        x -> {
          System.out.println("lambda");
          return true;
        });
    }

    @Test
    public void lambdaNumberList() {
        List<Integer> numbers = Arrays.asList(100, 200, 300, 400, 100);
        //lambda表达式传送map()方法进行对象转换，应用到所有stream中，forEach()循环打出集合元素
        numbers.stream().map((count)-> count*10).forEach(System.out::println);

        //reduce() 将集合中的所有值结合起来
        Double sumDouble = numbers.stream().map((number) -> number * .12).reduce((sum, number) -> sum + number).get();
        Double sumDouble2 = numbers.stream().mapToDouble((count) -> count * .12).summaryStatistics().getSum();
        System.out.println("Total:" + sumDouble);
        System.out.println("Total2:" + sumDouble2);

        //使用distinct进行去重
        List<Integer> distinct = numbers.stream().map((x) -> x*12).distinct().collect(Collectors.toList());
        System.out.println("distinct numbers: " + distinct);

        //利用summaryStatistics 计算平均值最大最小值总和
        IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("The Max numbers: " + summaryStatistics.getMax());
        System.out.println("The Min numbers: " + summaryStatistics.getMin());
        System.out.println("The Sum of numbers: " + summaryStatistics.getSum());
        System.out.println("The Count of numbers: " + summaryStatistics.getCount());
        System.out.println("The average of numbers: " + summaryStatistics.getAverage());
    }

    @Test
    public void LambdaStringList() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "C", "C#", "JavaScript");
        System.out.println("Print the start with J:");
        // 默认获取的参数类型是Object,需强制转换为所需类型
        filter(languages, (str) -> ((String) str).startsWith("J"));

        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourthLength = (n) -> n.length() == 4;

        // Predicate and，or，negate 逻辑判断
        // 以J开头且长度为四
        System.out.println("Print the start with J and length is 4:");
        languages.stream().filter(startWithJ.and(fourthLength)).forEach(System.out::println);

        //通过过滤创建一个新的list，String
        List<String> newLanguages = languages.stream().filter((str) -> str.length() > 4).collect(Collectors.toList());
        System.out.printf("Origin List: %s, filter List: %s", languages, newLanguages);
        System.out.println();

        //对列表的每个元素都使用函数
        String upperCaseLanguage = languages.stream().map((str) -> str.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("Print UpperCase Language: " + upperCaseLanguage);

        //使用方法引用 ClassName::instanceMethod
        Comparator<UserInfo> comparator = Comparator.comparing(UserInfo::getUserName);

        call(() -> "call");

        //Optional 判断值过滤值
        String str = "callable";
        Optional.ofNullable(str).filter(s -> s.contains("call")).orElse("call");
    }

    /*public void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name);
            }
        }
    }*/

    //用lambda表达式简化上述方法
    public void filter(List<String> names, Predicate condition) {
        names.stream()
            .filter((name) -> (condition.test(name)))
            .forEach((name) -> System.out.println(name));
    }

    private void func(LambdaInterface lambdaInterface) {
        Integer x = 1;
        lambdaInterface.testLambda(x);
    }

    public void call(Supplier supplier) {
        supplier.get();
    }

}
