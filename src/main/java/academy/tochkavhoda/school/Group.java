package academy.tochkavhoda.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Group {

    private String name;
    private String room;
    private List<Trainee> list = new ArrayList<>();


    public Group(String name, String room) throws TrainingException {
        setRoom(room);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.length() < 1) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.length() == 0) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return list;
    }

    public void addTrainee(Trainee trainee) {
        list.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        int a1 = list.size();
        list.remove(trainee);
        int a2 = list.size();
        if (a1 - a2 == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        try {
            list.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        int count = 0;
        for (Trainee tr : list) {
            if (tr.getFirstName().equals(firstName)) {
                return list.get(count);
            } else {
                count++;
            }
        }
        if (count - list.size() + 1 > 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return null;
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        int count = 0;
        for (Trainee tr : list) {
            if (tr.getFullName().equals(fullName)) {
                return list.get(count);
            } else {
                count++;
            }
        }
        if (count - list.size() + 1 > 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return null;
    }

    public void sortTraineeListByFirstNameAscendant() {

        for (int i = 0; i < this.list.size(); i++) {
            for (int j = i + 1; j < this.list.size(); j++) {
                if (list.get(i).getFirstName().compareTo(list.get(j).getFirstName()) > 0) {
                    Trainee tr = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tr);
                }

            }
        }
    }

    public void sortTraineeListByRatingDescendant() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getRating() < list.get(j).getRating()) {
                    Trainee tr = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tr);
                }
            }
        }
    }

    public void reverseTraineeList() {
        Collections.reverse(list);
//        for (int i = 0; i < list.size() / 2; i++) {
//            Trainee tr = list.get(i);
//            list.set(i, list.get(list.size() - i - 1));
//            list.set(list.size() - 1 - i, tr);
//        }
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(list, positions);
//        List<Trainee> list2 = new ArrayList<>();
//        for (int i=0; i< list.size() ; i++) {
//            int a = i+ positions;
//            if (a>list.size()-1) {
//                a = a - list.size();
//            }
//            list2.add(list.get(a));
//        }
//        list=list2;
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (list.size() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        this.sortTraineeListByRatingDescendant();
        int s = list.size();
        int count = 0;
        for (int i = 1; i < s - count; i++) {
            if (list.get(1).getRating() > list.get(i).getRating()) {
                list.remove(i);
                count++;
                i--;
            }
        }
        return list;
    }

    public boolean hasDuplicates() {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(0).equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!Objects.equals(name, group.name)) return false;
        if (!Objects.equals(room, group.room)) return false;
        return Objects.equals(list, group.list);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }
}
