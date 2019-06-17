package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//客户抵押物表
@Entity
@Table(name = "t_cust_mortgage")
public class CustMortgage {
    @Id
    @GeneratedValue
    private long mortgageId;
    @Column
    private long customerId;
    @Column
    private long orderId;

    //物业名称
    @Column
    private String propertyName;
    //面积
    @Column
    private float square;

    //房产证号
    @Column
    private String propertyNO;
    //登记价
    @Column
    private String registerPrice;
    //评估价
    @Column
    private float estimatePrice;
    //用途
    @Column
    private String propertyUse;

    //物业业务类型
    //1、无赎楼，无抵押；2、只赎楼；3、只抵押；4、赎楼且抵押
    @Column
    private int propertyType;
    //产权状态
    //1、正常；2、抵押；3、查封；
    @Column
    private int propertyState;


    @Column
    private long orderProductId;
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
    //标准：1、住宅；2、公寓；3、别墅；4、商业；5、办公
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
    private int mortgageCount = 0;

    @Column
    private int estateAge = 0;
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

    public int getMortgageCount() {
        return mortgageCount;
    }

    public void setMortgageCount(int mortgageCount) {
        this.mortgageCount = mortgageCount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getPropertyNO() {
        return propertyNO;
    }

    public void setPropertyNO(String propertyNO) {
        this.propertyNO = propertyNO;
    }

    public String getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(String registerPrice) {
        this.registerPrice = registerPrice;
    }

    public float getEstimatePrice() {
        return estimatePrice;
    }

    public void setEstimatePrice(float estimatePrice) {
        this.estimatePrice = estimatePrice;
    }

    public String getPropertyUse() {
        return propertyUse;
    }

    public void setPropertyUse(String propertyUse) {
        this.propertyUse = propertyUse;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public int getPropertyState() {
        return propertyState;
    }

    public void setPropertyState(int propertyState) {
        this.propertyState = propertyState;
    }
}
