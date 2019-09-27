package com.zhl.aps.optaplanner;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

/**
 * @program aps
 * @description:此类用来描述整个解决方案的固定类，它的结构描述了问题的各种信息，在Optaplanner术语中，在执行规划之前，它的对象被称作一个Problem, <p>
 * 完成规划并获得输出之后，输出的TaskAssignment对象被称作一个Solution。它具有固定的特性要求：必须被注解为@PlanningSolution；
 * 本例中它至少有三个属性:machineList-机台列表，就是可以用于分配任务的机台；taskList-任务列表，这个属性需要被注解为@PlanningEntityCollectionPropery,
 * 还有一个是score属性，它用于在规划过程中对各种约束的违反情况进行打分，因为本例中存在了硬约束与软约束，因此我们使用的score为hardSoftScore。
 * @author: meilong
 * @create: 2019/09/20 15:16
 */
@PlanningSolution
public class TaskAssignment extends AbstractPersistable {

    private HardSoftScore score;

    private List<Machine> machineList;

    private List<Task> taskList;

    public TaskAssignment() {
    }

    public TaskAssignment(List<Machine> machineList, List<Task> taskList) {
        //super(0);
        this.machineList = machineList;
        this.taskList = taskList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "machineRange")
    public List<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(List<Machine> machineList) {
        this.machineList = machineList;
    }

    @PlanningEntityCollectionProperty
    @ValueRangeProvider(id = "taskRange")
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}

