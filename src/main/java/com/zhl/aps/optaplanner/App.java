package com.zhl.aps.optaplanner;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program aps
 * @description:
 * @author: meilong
 * @create: 2019/09/20 15:36
 */
public class App {

    public static void main(String[] args) {
        startPlan();
    }

    private static void startPlan() {
        List<Machine> machines = getMachines();
        List<Task> tasks = getTasks();

        InputStream ins = App.class.getResourceAsStream("/taskassignmentConfiguration.xml");
        SolverFactory<TaskAssignment> solverFactory = SolverFactory.createFromXmlInputStream(ins);
        Solver<TaskAssignment> solver = solverFactory.buildSolver();
        TaskAssignment unAssignment = new TaskAssignment(machines, tasks);

        // 启动引擎
        TaskAssignment assigned = solver.solve(unAssignment);

        List<Machine> machinesAssigned = assigned.getTaskList().stream().map(Task::getMachine).distinct().collect(Collectors.toList());
        for (Machine machine : machinesAssigned) {
            System.out.println("\n" + machine + ":");
            List<Task> tasksInMachine = assigned.getTaskList().stream().filter(x -> x.getMachine().equals(machine)).collect(Collectors.toList());
            for (Task task : tasksInMachine) {
                System.out.println("->" + task);
            }
        }
    }

    private static List<Machine> getMachines() {
        // 六个机台
        Machine m1 = new Machine(1L, "Type_A", 300, 100);
        Machine m2 = new Machine(2L, "Type_A", 1000, 100);
        Machine m3 = new Machine(3L, "TYPE_B", 1000, 300);
        Machine m4 = new Machine(4L, "TYPE_B", 1000, 100);
        Machine m5 = new Machine(5L, "Type_C", 1100, 100);
        Machine m6 = new Machine(6L, "Type_D", 900, 100);

        List<Machine> machines = new ArrayList<>();
        machines.add(m1);
        machines.add(m2);
        machines.add(m3);
        machines.add(m4);
        machines.add(m5);
        machines.add(m6);

        return machines;
    }

    private static List<Task> getTasks() {
        // 10个任务
        Task t1 = new Task(1L, "Type_A", 100);
        Task t2 = new Task(2L, "Type_A", 100);
        Task t3 = new Task(3L, "Type_A", 100);
        Task t4 = new Task(4L, "Type_A", 100);
        Task t5 = new Task(5L, "TYPE_B", 800);
        Task t6 = new Task(6L, "TYPE_B", 500);
        Task t7 = new Task(7L, "Type_C", 800);
        Task t8 = new Task(8L, "Type_C", 300);
        Task t9 = new Task(9L, "Type_D", 400);
        Task t10 = new Task(10L, "Type_D", 500);

        List<Task> tasks = new ArrayList<Task>();
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        tasks.add(t6);
        tasks.add(t7);
        tasks.add(t8);
        tasks.add(t9);
        tasks.add(t10);

        return tasks;
    }
}
