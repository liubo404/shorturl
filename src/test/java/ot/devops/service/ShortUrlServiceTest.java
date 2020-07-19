package ot.devops.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ot.devops.DTO.ShortUrlDTO;
import ot.devops.utils.UrlConstants;

import java.security.InvalidParameterException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ot.devops.utils.UrlConstants.EXIST_CODE;
import static ot.devops.utils.UrlConstants.SHORT_DOMAIN;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShortUrlServiceTest {

    @Autowired
    ShortUrlService shortUrlService;

    @Test
    public void queryByExistCode() {
        //Given
        ShortUrlDTO urlDTO = new ShortUrlDTO();
        urlDTO.setUrl(SHORT_DOMAIN + EXIST_CODE);

        //When query by exist code
        ResponseEntity<String> result = shortUrlService.query(urlDTO);

        //Then it should be the get it back
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test(expected = AssertionError.class)
    public void queryNullTest() {
        //When query by null,breaking the assertion
        ResponseEntity<String> result = shortUrlService.query(null);

        //Then  assertion error should occurs
    }

    @Test(expected = AssertionError.class)
    public void queryCodeNullTest() {
        //Given the query param null
        ShortUrlDTO urlDTO = new ShortUrlDTO();

        //When  breaking the assertion
        ResponseEntity<String> result = shortUrlService.query(urlDTO);

        //Then  assertion error should occurs
    }

    @Test(expected = InvalidParameterException.class)
    public void invalidUrlQueryTest() {
        //Given the query param without short url code, just the domain string
        ShortUrlDTO urlDTO = new ShortUrlDTO();
        urlDTO.setUrl(SHORT_DOMAIN);

        //When  breaking the assertion
        ResponseEntity<String> result = shortUrlService.query(urlDTO);

        //Then invalid parameter exception should occurs
    }


    @Test
    public void save() {
        //Given a long url
        ShortUrlDTO urlDTO = new ShortUrlDTO();
        urlDTO.setUrl(UrlConstants.LONG_URL+ UUID.randomUUID().toString());

        //When save it to DB
        ResponseEntity<String> result = shortUrlService.save(urlDTO);

        //Then it should be  return the short url code
        assertTrue(result.getBody().length() > 0);
    }
}
