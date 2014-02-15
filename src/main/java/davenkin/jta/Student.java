package davenkin.jta;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 1/4/14
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return id + ":" + name;
    }
}
