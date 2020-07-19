package ot.devops.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ot.devops.DAO.ShortUrlDAO;
import ot.devops.DO.ShortUrlDO;
import ot.devops.DTO.ShortUrlDTO;
import ot.devops.utils.ShortUrlUtil;

import java.security.InvalidParameterException;

import static ot.devops.utils.UrlConstants.SHORT_DOMAIN;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    @Autowired(required = false)
    private ShortUrlDAO shortUrlDAO;

    @Override
    public ResponseEntity<String> query(ShortUrlDTO urlDTO) {
        assert urlDTO != null : " 短链查询参数不能为空";
        assert StringUtils.isNoneBlank(urlDTO.getUrl()) : " 短链码不能为空";

        String code = urlDTO.getUrl().replace(SHORT_DOMAIN, "");
        if (StringUtils.isBlank(code)) {
            throw new InvalidParameterException("短域名信息中没有短链码");
        }

        ShortUrlDO shortUrlDO = shortUrlDAO.getByCode(code);
        if (shortUrlDO == null) {
            return ResponseEntity.accepted().body("无此短链码的网址");
        }
        return ResponseEntity.ok().body(shortUrlDO.getUrl());
    }

    @Override
    public ResponseEntity<String> save(ShortUrlDTO urlDTO) {
        assert urlDTO != null : " 长链查询参数不能为空";
        assert StringUtils.isNoneBlank(urlDTO.getUrl()) : " 长域名地址不能为空";

        ShortUrlDO urlDO = new ShortUrlDO();
        String code = ShortUrlUtil.convertShortUrl(urlDTO.getUrl());
        urlDO.setCode(code);
        urlDO.setUrl(urlDTO.getUrl());
        shortUrlDAO.save(urlDO);
        return ResponseEntity.ok().body(SHORT_DOMAIN + code);
    }

}
