package academy.tochkavhoda.school;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Trainee implements Serializable {

    @Serial
    private static final long serialVersionUID = -611809904446739235L;
    private String firstname, lastname;

    private int rating;

    public Trainee(String firstname, String lastname, int rating) throws TrainingException {
        setFirstName(firstname);
        setLastName(lastname);
        setRating(rating);
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) throws TrainingException{
        if (firstName==null || firstName.length()<1) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        }
        this.firstname=firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) throws TrainingException{
        if (lastName==null || lastName.length()<1) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        }
        this.lastname=lastName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws TrainingException {
        if (rating>5 | rating<1) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        }
        this.rating=rating;
    }

    public String getFullName() {
        return firstname+" "+lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (rating != trainee.rating) return false;
        if (!Objects.equals(firstname, trainee.firstname)) return false;
        return Objects.equals(lastname, trainee.lastname);
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + rating;
    }
}
