public class HumanPrototype implements Cloneable {
    private String name;
    private int age;

    public HumanPrototype(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected HumanPrototype clone() {
        try {
            return (HumanPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HumanPrototype original = new HumanPrototype("John", 30);
        System.out.println("Original: " + original.getName() + ", Age: " + original.getAge());

        // Clone the original human
        HumanPrototype clone = original.clone();
        clone.setName("Jane");
        clone.setAge(25);

        System.out.println("Clone: " + clone.getName() + ", Age: " + clone.getAge());
    }
}
