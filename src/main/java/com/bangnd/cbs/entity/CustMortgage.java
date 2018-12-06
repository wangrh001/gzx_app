package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//客户抵押物表
@Entity
@Table(name="t_cust_mortgage")
public class CustMortgage {
    @Id
    @GeneratedValue
    private long mortgageId;
    @Column
    private long customerId;
    //抵押物类型：1/房；2/车；3/保单；
    @Column
    private int mortgageType;
    //抵押物所在区域
    @Column
    private int estateArea;
    @Column
    private BigDecimal estatePrice;
    //1、住宅；2、别墅；3、经济适用房；4、商住两用；5、纯商业；6、纯商业实际为居住；
    //7、公司名下房产；8、公寓；9、酒店式公寓；10、央产房；11、公寓式酒店
    @Column
    private int estateType;
    //2、二环之内；3、三环之内；4、四环之内；5、五环之内；6、六环之内
    //23、二环三环之间；34、三环四环之间；45、四环五环之间；56、五环六环之间
    //610、六环以外；510、五环以外；410、四环以外；310、三环以外
    //房屋地址
    @Column
    private int houseAddress;

    //抵押物和抵押人关系：1、所有；2、实际控制
    @Column
    private int belongType;

    @Column
    private int estateAge;
    @Column
    private Date createTime;
    @Column
    private int creator;
    @Column
    private Date updateTime;
    @Column
    private int updator;

    public int getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(int houseAddress) {
        this.houseAddress = houseAddress;
    }
    public long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getMortgageType() {
        return mortgageType;
    }

    public void setMortgageType(int mortgageType) {
        this.mortgageType = mortgageType;
    }

    public int getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(int estateArea) {
        this.estateArea = estateArea;
    }

    public BigDecimal getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(BigDecimal estatePrice) {
        this.estatePrice = estatePrice;
    }

    public int getEstateType() {
        return estateType;
    }

    public void setEstateType(int estateType) {
        this.estateType = estateType;
    }

    public int getEstateAge() {
        return estateAge;
    }

    public void setEstateAge(int estateAge) {
        this.estateAge = estateAge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdator() {
        return updator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }

    public int getBelongType() {
        return belongType;
    }

    public void setBelongType(int belongType) {
        this.belongType = belongType;
    }
}
