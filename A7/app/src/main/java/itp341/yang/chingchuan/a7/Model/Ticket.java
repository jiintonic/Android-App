package itp341.yang.chingchuan.a7.Model;


import java.io.Serializable;

/**
 * Created by Jin Yang on 2/28/2017.
 */

public class Ticket implements Serializable {
    String start;
    String end;
    String type;
    String priority;

    public Ticket(String start, String end, String type, String priority) {
        this.start = start;
        this.end = end;
        this.type = type;
        this.priority = priority;
    }

    public Ticket() {
        this.start = "";
        this.end = "";
        this.type = "";
        this.priority = "";
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getType() {
        return type;
    }

    public String getPriority() {
        return priority;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", type='" + type + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
