

public class PersonName{
    private Name name;
    private int height;
    private PersonName father;

    public PersonName(Name name, int height) {
        this.name = name;
        this.height = height;
    }
    public PersonName(Name name, int height, PersonName father) {
        this.name = name;
        this.height = height;
        this.father = father;

        if (name.getSurname() == null && father != null && father.name.getSurname() != null) {
            name.setSurname(father.name.getSurname());
        }
        if(name.getPatronymic()== null && father != null && father.name.getFirstName() != null) {
            name.setPatronymic(father.name.getFirstName() + "ович");
        }
    }


    @Override public String toString() {
        return name + ", рост: " + height;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}