package com.laurentiuspilca.ssia.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyFirstClassTest {
    @Test
    void myTest() {
        MyFirstClass firstClass = new MyFirstClass(2);
        assertThat(firstClass.timesTwo(4)).isEqualTo(16);
    }
}
