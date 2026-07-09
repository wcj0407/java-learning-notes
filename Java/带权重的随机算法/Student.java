package IO2;

public class Student {
    private String name;
    private String gender;
    private int age;
    private double weiget;


    public Student() {
    }

    public Student(String name, String gender, int age, double weiget) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weiget = weiget;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return weiget
     */
    public double getWeiget() {
        return weiget;
    }

    /**
     * 设置
     * @param weiget
     */
    public void setWeiget(double weiget) {
        this.weiget = weiget;
    }

    public String toString() {
        return name+"-"+gender+"-"+age+"-"+weiget;
    }
}
