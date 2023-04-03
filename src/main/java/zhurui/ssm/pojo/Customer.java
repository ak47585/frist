package zhurui.ssm.pojo;

import java.util.Date;

public class Customer {
    private Long id;
    private String name;
    private Long userId;
    private Long createId;
    private Long dictSource;
    private Long dictIndustry;
    private Long dictLevel;
    private String linkman;
    private String phone;
    private String address;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getDictSource() {
        return dictSource;
    }

    public void setDictSource(Long dictSource) {
        this.dictSource = dictSource;
    }

    public Long getDictIndustry() {
        return dictIndustry;
    }

    public void setDictIndustry(Long dictIndustry) {
        this.dictIndustry = dictIndustry;
    }

    public Long getDictLevel() {
        return dictLevel;
    }

    public void setDictLevel(Long dictLevel) {
        this.dictLevel = dictLevel;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", createId=" + createId +
                ", dictSource=" + dictSource +
                ", dictIndustry=" + dictIndustry +
                ", dictLevel=" + dictLevel +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
