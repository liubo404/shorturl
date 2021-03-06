短域名服务 
# 基本需求 
1. 短域名查询，接受短域名信息，返回长域名信息
2. 短域名存储，接受长域名信息，返回短域名信息


# 解决思路
1. 假设短链的域名为http://abc.com/

2. 将提交的网址 A 转成短链接编码，假设为:Cso34D

3. 从数据库里或者缓存里，查询C是否已经生成过对应的短链接编码。如果有，直接就取之前生成过的短链接编码；
然后返回短链的假设域名为加上短链码,如http://abc.com/Cso34D

4. 如果没有，则往数据库插入一条记录，记录的内容如下： code（短链code）,url（原始网址）


# 代码说明 
项目化分三层： 
- controller接口层
- service 业务逻辑
- dao 数据访问 

项目技术栈:springboot+mybatis+h2databse+junit+jcoco

启动类：ShortUrlApplication.java


```
├── pom.xml
├── README.md
├── short_url.plantuml
└── src
    ├── main
    │   ├── java
    │   │   └── ot
    │   │       └── devops
    │   │           ├── controller
    │   │           │   └── ShortUrlController.java
    │   │           ├── DAO
    │   │           │   └── ShortUrlDAO.java  数据访问
    │   │           ├── DO
    │   │           │   └── ShortUrlDO.java   实体
    │   │           ├── DTO
    │   │           │   └── ShortUrlDTO.java  查询dto
    │   │           ├── service
    │   │           │   ├── ShortUrlServiceImpl.java  业务逻辑
    │   │           │   └── ShortUrlService.java
    │   │           ├── ShortUrlApplication.java 启动类
    │   │           └── utils
    │   │               ├── ShortUrlUtil.java  短链码生成工具
    │   │               └── UrlConstants.java  常量
    │   └── resources
    │       ├── application.yml
    │       └── sql
    │           ├── data.sql 预设数据
    │           └── init.sql 建表
    └── test
        └── java
            └── ot
                └── devops
                    ├── controller
                    │   └── ShortUrlControllerTest.java 集成测试 
                    ├── DAO
                    │   └── ShortUrlDAOTest.java  单元测试
                    └── service
                        └── ShortUrlServiceTest.java 单元测试
```
  
