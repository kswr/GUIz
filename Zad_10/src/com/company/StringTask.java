package com.company;


public class StringTask implements Runnable{
    private String string;
    private int reps;
    private String concatString;
    private Thread thread;
    private TaskState taskState;

    public enum state {RUNNING, CREATED, ABORTED, READY}

    public void start() {
        this.thread = new Thread(this);
        thread.start();
        this.taskState.setState(state.RUNNING);
    }

    public String getResult() {
        String tempString = "";
        if (this.getState().equals("READY")) {
           tempString = this.getConcatString();
            System.out.println("Task finished, returning product");
        } else {
            System.out.println("Task not finished, can't return product");
        }
        return tempString;
    }

    public void abort() {
        this.thread.interrupt();
    }

    public boolean isDone() {
        boolean isDone;
        String state = this.getState().toString();
        if (state.equals("READY") || state.equals("ABORTED")) {
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
        this.taskState = new TaskState(state.RUNNING);
    }

    public TaskState getState() {
       return getTaskState();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getConcatString() {
        return concatString;
    }

    public void setConcatString(String concatString) {
        this.concatString = concatString;
    }

    public Thread getThread() {
        return thread;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    static class TaskState {
//        enum state {CREATED, RUNNING, ABORTED, READY}
//        private String state;
        private state state;

        public TaskState(state state) {
            this.state = state;
        }

        public void setState(state state) {
            this.state = state;
        }

//        @Override
//        public String toString() {
//            return state;
//        }
    }

    @Override
    public void run() {
        String reversedString = "";
        for (int i =1; i <= this.string.length(); i++){
            reversedString = reversedString + this.string.charAt(this.string.length()-i);
        }
        for (int i = 0; i < this.reps; i++) {
            this.concatString = (this.concatString + reversedString);
            if(this.thread.isInterrupted()) {
                System.out.println("Task has been aborted!");
                this.taskState.setState("ABORTED");
                break;
            } else {
                System.out.println("Task finished succesfully");
                this.taskState.setState("READY");
            }
        }
    }
}

