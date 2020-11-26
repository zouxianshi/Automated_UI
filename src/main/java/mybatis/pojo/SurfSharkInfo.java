package mybatis.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class SurfSharkInfo {
    private String id;
    private String connectionName;
    private String region;
    private String country;
    private String location;
    private String regionCode;
    private String countryCode;
    private int loads;
    private String latitude;
    private String longitude;
    private String type;
    private Date updatetime;
}
