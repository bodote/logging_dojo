package com.laurentiuspilca.ssia.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MySecondClassIT {
    @Test
    void mySecondTest() {
        log.info(" mySecondTest");
        MySecondClass mySecondClass = new MySecondClass(3);
        assertThat(mySecondClass.qubed(3)).isEqualTo(27);
    }
}