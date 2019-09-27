package com.zhl.aps.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * @program aps
 * @description:Task,表示任务的实体类，它被注解为@PlanningEntity，它有三个属性:taskType-当前任务的类型；quantity-生产量；machine-任务将要被分配的机台. <p>
 * 其中machine属性被注解为@PlanningVariable，表示规划过程中，这个属性的值将被plan的，即通过调整这个属性来得到不同的方案。
 * 另外，作为一个Planning Entity，它必须有一个ID属性，用于在规划运行过程中识别不同的对象，这个ID属性被注解为@PlanningId。
 * 本例中所有实体类都继承了一个通用的类 - AbstractPersistable,该父类负责维护此所有对象的ID。
 * Task类也继承于它，因此，将该类的ID属性注解为@PlanningId即可。另外作为Planning Entity，它必须有一无参构造函数，若你在此类实现了有参构造的话，
 * 需要显示地实现一个无参构造函数。
 * @author: meilong
 * @create: 2019/09/20 14:42
 */
@PlanningEntity
public class Task extends AbstractPersistable {

    private String requiredYarnType;

    private Integer amount;

    private Machine machine;

    public Task() {
    }

    public Task(Long id, String requiredYarnType, Integer amount) {
        super(id);
        this.requiredYarnType = requiredYarnType;
        this.amount = amount;
    }

    public String getRequiredYarnType() {
        return requiredYarnType;
    }

    public void setRequiredYarnType(String requiredYarnType) {
        this.requiredYarnType = requiredYarnType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @PlanningVariable(valueRangeProviderRefs = {"machineRange"})
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}