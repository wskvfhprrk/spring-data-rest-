# spring boot jpa rest h2
学习jpa,rest,h2

## pom配置
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
```
h2可以建立后可以浏览器查看：
**http://localhost:8080/h2-console/**
注意jdbc URl、username、password要与配置文件一致
## application.properties配置
```properties
#打开h2控制台
spring.h2.console.enabled=true
#数据库连接配置
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:h2test;
spring.datasource.username=sa
spring.datasource.password=
#jpa配置
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## 添加实体类
```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    private String username;
    private String email;
}
```
## 添加Repository
```java
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @RestResource(path = "findByUsername", rel = "findByUsername")
    public Page findByUsernameContaining(String username, Pageable p);
}
```
## 添加hal-explorer页面管理
### pom.xml
```xml
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-rest-hal-explorer</artifactId>
            <version>3.5.4</version>
        </dependency>
```
### 直接在打开服务的根路径即可以看到hal-explorer页面
## 未解决的问题：
**多条件分布查询**