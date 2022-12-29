package com.vesska;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JsonFileTest {

    @Test
    void jacksonTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/me.json");
        Me me = mapper.readValue(file, Me.class);

        assertThat(me.getName()).isEqualTo("Sergei");
        assertThat(me.getAge()).isEqualTo(27);
        assertThat(me.getCitizenship().contains("UK")).isFalse();
        assertThat(me.getProfession()).isEqualTo("QA");


    }
}
