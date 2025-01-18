
public class Name {
    private String surname;
    private String firstName;
    private String patronymic;

    public Name(String firstName, String surname, String patronymic) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
    }
    public Name() {
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        if (surname != null) {
            result.append(surname).append(" ");
        }
        if (firstName != null) {
            result.append(firstName).append(" ");
        }
        if (patronymic != null) {
            result.append(patronymic).append(" ");
        }
        return result.toString().trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
