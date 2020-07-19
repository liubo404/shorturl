package ot.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ot.devops.DTO.ShortUrlDTO;
import ot.devops.service.ShortUrlService;

import javax.validation.Valid;

@RestController
@RequestMapping("/shortUrl")
public class ShortUrlController {

    @Autowired
    ShortUrlService shortUrlService;


    /**
     * 短域名读取
     *
     * @param urlDTO 短域名
     * @return 长域名
     */
    @GetMapping("/query")
    public ResponseEntity<String> query(@Valid ShortUrlDTO urlDTO) {
        return shortUrlService.query(urlDTO);
    }

    /**
     * 短域名存储
     *
     * @param urlDTO 长域名
     * @return 短域名
     */
    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid ShortUrlDTO urlDTO) {
        return shortUrlService.save(urlDTO);
    }


}
