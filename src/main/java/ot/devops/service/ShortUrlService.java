package ot.devops.service;

import org.springframework.http.ResponseEntity;
import ot.devops.DTO.ShortUrlDTO;

public interface ShortUrlService {

    /**
     * 短域名查询，接受短域名信息，返回长域名信息
     *
     * @param urlDTO 短域名信息
     * @return
     */
    ResponseEntity<String> query(ShortUrlDTO urlDTO);

    /**
     * 短域名存储，接受长域名信息，返回短域名信息
     *
     * @param urlDTO 长域名信息
     * @return
     */
    ResponseEntity<String> save(ShortUrlDTO urlDTO);

}
