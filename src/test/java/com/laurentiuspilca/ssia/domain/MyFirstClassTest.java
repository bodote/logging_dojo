package com.laurentiuspilca.ssia.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MyFirstClassTest {
    @BeforeAll
    public static void setup() {
        log.info("before all MyFirstClassTest");
        //        System.getProperties().forEach((key, value) -> log.info(key + ": " + value));
    }

    @Test
    void myTest() {

        MyFirstClass firstClass = new MyFirstClass(2);
        assertThat(firstClass.timesTwo(4)).isEqualTo(16);
    }
}
