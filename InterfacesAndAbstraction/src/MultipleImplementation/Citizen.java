package MultipleImplementation;

public class Citizen implements Person, Identifiable, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;

    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        setFood(this.food += 10);
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
