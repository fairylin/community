package life.fairy.community.model;

public class User {
    private Integer id;
    private String name;
    private String accoutId;
    private String token;
    private Long gmtCreate;
    private Long gmtModefied;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModefied() {
        return gmtModefied;
    }

    public void setGmtModefied(Long gmtModefied) {
        this.gmtModefied = gmtModefied;
    }
}
