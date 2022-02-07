package ru.mals.springboot.simbirsoftspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mals.springboot.simbirsoftspringboot.entity.RequestUrlAddress;
import ru.mals.springboot.simbirsoftspringboot.service.DownloadService;
import ru.mals.springboot.simbirsoftspringboot.service.WordService;
import ru.mals.springboot.simbirsoftspringboot.statistics.Stat;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class MainController {

    private final Stat stat;
    private final WordService wordService;
    private final DownloadService downloadService;

    public MainController(Stat stat, WordService wordService, DownloadService downloadService) {
        this.stat = stat;
        this.wordService = wordService;
        this.downloadService = downloadService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getIndex(Model model) throws IOException {
        model.addAttribute("requestUrlAddress", new RequestUrlAddress());
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postIndex(@ModelAttribute ("requestUrlAddress") @Valid RequestUrlAddress requestUrlAddress,
                            BindingResult bindingResult, Model model) throws IOException {
        if (bindingResult.hasErrors()){
            return "index";
        }
        stat.newSeance(requestUrlAddress);
        downloadService.downloadTextPage(requestUrlAddress.getAddress());
        model.addAttribute("countMap", wordService.parseText(downloadService.getPageText()));
        model.addAttribute("stat", stat.getLastSeance());
        return "result";
    }
}
