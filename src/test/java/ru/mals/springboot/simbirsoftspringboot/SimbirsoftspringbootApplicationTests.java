package ru.mals.springboot.simbirsoftspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mals.springboot.simbirsoftspringboot.service.DownloadService;
import ru.mals.springboot.simbirsoftspringboot.service.WordService;
import ru.mals.springboot.simbirsoftspringboot.service.impl.DownloadServiceImpl;
import ru.mals.springboot.simbirsoftspringboot.service.impl.WordServiceImpl;

import java.io.IOException;
import java.util.Map;

@SpringBootTest
class SimbirsoftspringbootApplicationTests {

    String page;
    Map<String, Integer> countMap;

    @Test
    void contextLoads() {
    }

    @Test
    void downservimpl() throws IOException {
        DownloadService downloadService = new DownloadServiceImpl();


    }

}
