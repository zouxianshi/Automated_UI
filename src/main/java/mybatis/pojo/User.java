package mybatis.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class User {
    public String id;
    public String userName;
    public String password;
    public String name;
    public int age;
    public int sex;
    public Date birthday;
    public String created;
    public String updated;
}
