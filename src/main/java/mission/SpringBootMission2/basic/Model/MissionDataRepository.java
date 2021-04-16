package mission.SpringBootMission2.basic.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionDataRepository {
    private Map<String, MissionData> store = new HashMap<>();

    private static final MissionDataRepository instance = new MissionDataRepository();

    public static MissionDataRepository getInstance(){
        return instance;
    }

    private MissionDataRepository() {

    }

    public MissionData save(MissionData missionData) {
        store.put("28", missionData);
        return missionData;
    }

    public MissionData findByName(String name) {
        return store.get(name);
    }

    public List<MissionData> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
