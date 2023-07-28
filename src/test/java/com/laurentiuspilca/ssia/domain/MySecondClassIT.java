package com.laurentiuspilca.ssia.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MySecondClassIT {
    @Test
    void mySecondTest(){
        MySecondClass mySecondClass = new MySecondClass(3);
        assertThat(mySecondClass.qubed(3)).isEqualTo(27);

    }

}