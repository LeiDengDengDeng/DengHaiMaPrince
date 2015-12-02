package src.vo;

/**
 * Created by dell on 2015/11/30.
 * ÓÃÍ¾
 */
public class LogVO {

    String position;
    String name;
    String operation;
    String statement; // ±¸×¢
    String time;

    public LogVO(String position, String name, String operation,
                 String statement, String time) {
        super();
        this.position = position;
        this.name = name;
        this.operation = operation;
        this.statement = statement;
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public String getStatement() {
        return statement;
    }

    public String getTime() {
        return time;
    }
}
