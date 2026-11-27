package com.rv.practice;

import java.util.List;

public final class ImmutableClass {

    private final String str;

    private final List<Integer> list;

    public ImmutableClass(String str, List<Integer> list) {
        this.str = str;
        this.list = List.copyOf(list);
    }

    public String getStr() {
        return this.str;
    }

    public List<Integer> getList() {
        return List.copyOf(this.list);
    }
}
