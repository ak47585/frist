package zhurui.ssm.pojo;

public class Dictionary {
    private Long id;
    private String typeName;
    private Long typeCode;
    private String itemName;
    private Long itemCode;
    private Integer sort;
    private Boolean enable;
    private String memo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Long typeCode) {
        this.typeCode = typeCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", typeCode=" + typeCode +
                ", itemName='" + itemName + '\'' +
                ", itemCode=" + itemCode +
                ", sort=" + sort +
                ", enable=" + enable +
                ", memo='" + memo + '\'' +
                '}';
    }
}
