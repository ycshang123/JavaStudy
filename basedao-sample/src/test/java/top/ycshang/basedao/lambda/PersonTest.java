package top.ycshang.basedao.lambda;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PersonTest {
    @Test
    void test(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"Java"));
        list.add(new Person(2,"Python"));
        list.add(new Person(3,"JavaScript"));
        Map<Integer,String> map = list.stream().collect(Collectors.toMap(Person::getId,Person::getName));
        System.out.println(map);

    }

}