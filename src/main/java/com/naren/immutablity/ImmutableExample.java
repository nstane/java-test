package com.naren.immutablity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableExample {

    public static void main(String ...a)
    {
        List<String> list = new ArrayList<>();//Arrays.asList("Dummy", "Dummy 2"); //By adding element in array.asList().add("f"); will give unsupported operation exception
        //Because it gives fixed size list and we can't add more to that
        list.add("Ox");
        System.out.println(list);
        change(list);
        System.out.println(list);
    }

    private static void change(final List<String> strings)
    {
        strings.add("break");
    }
}
