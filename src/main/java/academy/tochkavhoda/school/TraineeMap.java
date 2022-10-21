package academy.tochkavhoda.school;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {

    private Map<Trainee, String> map;

    public TraineeMap() {
        this.map = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (map.get(trainee) != null) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        map.put(trainee, institute);
    }

    public int getTraineesCount() {
        return map.keySet().size();
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!map.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        map.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (map.get(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        map.remove(trainee);
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (map.get(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return map.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return map.keySet();
    }

    public Set<String> getAllInstitutes() {
        Set<String> str = new LinkedHashSet<>();
        for (Trainee tr : map.keySet()) {
            str.add(map.get(tr));
        }
        return str;
    }

    public boolean isAnyFromInstitute(String institute) {
        return map.containsValue(institute);
    }

}
