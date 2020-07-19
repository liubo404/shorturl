package ot.devops.DAO;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ot.devops.DO.ShortUrlDO;
import ot.devops.utils.ShortUrlUtil;

import static org.junit.Assert.assertEquals;
import static ot.devops.utils.UrlConstants.EXIST_CODE;
import static ot.devops.utils.UrlConstants.LONG_URL;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShortUrlDAOTest {


    @Autowired(required = false)
    ShortUrlDAO shortUrlDAO;


    @After
    public void tearDown() {
        shortUrlDAO.deleteById(1001);
    }

    @Test
    public void getByIdTest() {
        //When get by id
        ShortUrlDO urlDO = shortUrlDAO.getById(10001);

        //Then it should the specified one
        assertEquals(EXIST_CODE, urlDO.getCode());
    }

    @Test
    public void getByCodeTest() {
        //When get by code
        ShortUrlDO urlDO = shortUrlDAO.getByCode(EXIST_CODE);

        //Then it should be the specified one
        assertEquals(EXIST_CODE, urlDO.getCode());

    }


    @Test(expected = DuplicateKeyException.class)
    public void duplicateCodeTest() {
        //Given a new object with exist code
        ShortUrlDO urlDO = new ShortUrlDO();
        urlDO.setId(3001L);
        urlDO.setCode(EXIST_CODE);
        urlDO.setUrl(LONG_URL);

        //When insert the duplicated code in DB
        shortUrlDAO.insert(urlDO);

        //Then throw exception
    }


    @Test
    public void insertTest() {
        //Given new object with  manually specified  id
        Long id = 1001L;
        String testCode = "A74r";
        ShortUrlDO urlDO = new ShortUrlDO();
        urlDO.setId(id);
        urlDO.setCode(testCode);
        urlDO.setUrl(LONG_URL);

        //When insert it to DB
        shortUrlDAO.insert(urlDO);

        //Then get it back, it should be the same one
        ShortUrlDO result = shortUrlDAO.getById(id.intValue());
        assertEquals(testCode, result.getCode());

    }

    @Test
    public void saveTest() {
        //Given  create a new urlDO
        ShortUrlDO urlDO = new ShortUrlDO();
        String code = ShortUrlUtil.convertShortUrl(LONG_URL);
        urlDO.setCode(code);
        urlDO.setUrl(LONG_URL);

        //When save to DB
        shortUrlDAO.save(urlDO);

        //And git it back
        ShortUrlDO savedDO = shortUrlDAO.getByCode(code);

        //Then it should  the  saved urlDO
        assertEquals(LONG_URL, savedDO.getUrl());

    }


}
