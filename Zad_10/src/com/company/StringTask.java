package com.company;

import static com.company.TaskState.READY;
import static com.company.TaskState.RUNNING;
import static com.company.TaskState.ABORTED;
import static com.company.TaskState.CREATED;

enum TaskState {RUNNING, CREATED, ABORTED, READY};

public class StringTask implements Runnable{
    private String string;
    private int reps;
    private String concatString;
    private Thread thread;
    private TaskState state;


    public void start() {
        this.thread = new Thread(this);
        this.state = RUNNING;
        System.out.println("Task is now running");
        thread.start();
    }

    public String getResult() {
        return this.getConcat();
    }

    public void abort() {
        this.thread.interrupt();
        this.state = ABORTED;
    }

    public boolean isDone() {
        boolean isDone;
        TaskState state = this.getState();
        if (state == READY|| state == ABORTED) {
           isDone = true;
        } else {
            isDone = false;
        }
        return isDone;
    }

    public StringTask(String string, int reps) {
        this.string = string;
        this.reps = reps;
        this.concatString = "";
        this.state = CREATED;
    }

    public TaskState getState() {
        return state;
    }

    public Thread getThread() {
        return thread;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public String getConcat() {
        return concatString;
    }

    public String getTxt() {
        return string;
    }

    @Override
    public void run() {
        String reversedString = "";
//        String info = "Task finished succesfully";
        for (int i =1; i <= this.string.length(); i++){
            reversedString = reversedString + this.string.charAt(this.string.length()-i);
        }
        for (int i = 0; i < this.reps; i++) {
            this.concatString = (this.concatString + reversedString);
            if(this.thread.isInterrupted()) {
//                info = "Task has been aborted";
                this.state = ABORTED;
                break;
            }
        }
        if (this.state != ABORTED){
            this.state = READY;
        }
    }
}

