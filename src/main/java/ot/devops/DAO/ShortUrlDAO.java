package ot.devops.DAO;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ot.devops.DO.ShortUrlDO;

@Mapper
public interface ShortUrlDAO {

    /**
     * insert data, by manually id
     *
     * @param shortUrlDO
     */
    @Insert("insert into short_url(id,code,url) values( #{id}, #{code},#{url}) ")
    void insert(ShortUrlDO shortUrlDO);


    /**
     * insert data, use the auto increment id
     *
     * @param shortUrlDO
     * @return
     */
    @Insert("insert into short_url( code,url) values(  #{code},#{url}) ")
    Integer save(ShortUrlDO shortUrlDO);


    @Select("SELECT * FROM short_url WHERE id = #{id}")
    ShortUrlDO getById(int id);

    @Select("SELECT * FROM short_url WHERE code = #{code}")
    ShortUrlDO getByCode(String code);

    @Delete("delete  FROM short_url WHERE id = #{id}")
    void deleteById(int i);
}
