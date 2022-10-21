package academy.tochkavhoda.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {

    Set<Group> set = new HashSet<>();
    private String name;
    private int year;

    public School(String name, int year) throws TrainingException {
        setYear(year);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.length() < 2) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return set;
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group gr : set) {
            if (gr.getName().compareTo(group.getName()) == 0) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        set.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        int size1 = set.size();
        set.remove(group);
        int size2 = set.size();
        if (size2 - size1 == 0) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        int size1 = set.size();
        for (Group gr : set) {
            if (gr.getName().compareTo(name) == 0) {
                set.remove(gr);
            }
        }
        int size2 = set.size();
        if (size2 - size1 == 0) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean containsGroup(Group group) {
        return set.contains(group);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        School school = (School) o;

        if (year != school.year) return false;
        if (!Objects.equals(name, school.name)) return false;
        return Objects.equals(set, school.set);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (set != null ? set.hashCode() : 0);
        return result;
    }

}
