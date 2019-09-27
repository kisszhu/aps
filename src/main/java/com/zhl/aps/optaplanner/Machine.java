package com.zhl.aps.optaplanner;

/**
 * @program aps
 * @description:表示机台的实体类，它属于ProblemFact，在其中保存了在规划过程中会用到的属性， <P>
 * 此类反映一个机台相关信息的属性：taskType-可处理的任务类型；capacity-当前机台的产能；cost-当前机台的成本
 * @author: meilong
 * @create: 2019/09/20 15:00
 */
public class Machine extends AbstractPersistable {

    private String yarnType;

    private Integer capacity;

    private Integer cost;

    public Machine(Long id, String yarnType, Integer capacity, Integer cost) {
        super(id);
        this.yarnType = yarnType;
        this.capacity = capacity;
        this.cost = cost;
    }

    public String getYarnType() {
        return yarnType;
    }

    public void setYarnType(String yarnType) {
        this.yarnType = yarnType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
