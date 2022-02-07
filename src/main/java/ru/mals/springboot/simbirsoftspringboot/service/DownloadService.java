package ru.mals.springboot.simbirsoftspringboot.service;

import java.io.IOException;

public interface DownloadService {

    void downloadTextPage (String url) throws IOException;
    String getPageText();
}
