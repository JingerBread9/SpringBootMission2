package mission.SpringBootMission2.basic.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MissionData {
    private String name;
    private Integer age;
    private String address;

    public MissionData(){

    }

    public MissionData(String name, Integer age, String address) {
        this.name=name;
        this.age=age;
        this.address=address;
    }


}
