package mission.SpringBootMission2.basic.Controller;

import lombok.extern.slf4j.Slf4j;
import mission.SpringBootMission2.basic.Model.MissionData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class GetController {

    //URL QueryString
    @GetMapping("/mission2-1")
    public String Mission2_1() {
        return "redirect:http://localhost:8080/mission2-1?name=ParkJiSung&age=39&address=Manchester";
    }

    //form data & x-www-form-urlencoded -> String
    @GetMapping("/mission2-2")
    public void Mission2_2(HttpServletResponse response) throws IOException {
        response.getWriter().write("name=Park_Ji_Sung&age=39&address=Manchester");
    }

    //form data & x-www-form-urlencoded -> Response Entity
    @GetMapping("/mission2-3")
    public ResponseEntity<String> Mission2_3() {
        return new ResponseEntity<>("name=Park_Ji_Sung&age=39&address=Manchester",HttpStatus.OK);
    }


    //application/json
    @GetMapping("/mission2-4")
    public ResponseEntity<MissionData> Mission2_4() {
        MissionData missionData = new MissionData();
        missionData.setName("Park Ji Sung");
        missionData.setAge(39);
        missionData.setAddress("Manchester");

        return new ResponseEntity<>(missionData, HttpStatus.OK);

    }
}
