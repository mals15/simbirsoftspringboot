package ru.mals.springboot.simbirsoftspringboot.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import ru.mals.springboot.simbirsoftspringboot.service.DownloadService;
import java.io.IOException;
import java.net.URL;

@Service
public class DownloadServiceImpl implements DownloadService {

    private String pageText;

    @Override
    public void downloadTextPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 3000);
        pageText = page.text();
    }

    public String getPageText() {
        return pageText;
    }
}
