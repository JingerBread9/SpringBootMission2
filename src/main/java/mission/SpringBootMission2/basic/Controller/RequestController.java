package mission.SpringBootMission2.basic.Controller;

import lombok.extern.slf4j.Slf4j;
import mission.SpringBootMission2.basic.Model.MissionData;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Slf4j
@RestController
public class RequestController {


    //URL QueryString
    @PostMapping("/mission1-1")
    public String mission1_1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        log.info("name = {}",name);
        log.info("age = {}",age);
        log.info("address = {}",address);

        return "ok";

    }

    //form data & x-www-form-urlencoded -> Map
    @PostMapping("/mission1-2")
    public String mission1_2(@RequestParam Map<String,Object> map) {

        log.info("name = {}",map.get("name"));
        log.info("age = {}",map.get("age"));
        log.info("address = {}",map.get("address"));

        return "ok";
    }

    //form data & x-www-form-urlencoded -> Model
    @RequestMapping("/mission1-3")
    public String mission1_3(MissionData missionData) throws IOException {

        log.info("name = {}",missionData.getName());
        log.info("age = {}",missionData.getAge());
        log.info("address = {}",missionData.getAddress());

        return "ok";
    }

    //application/json
    @PostMapping(value="/mission1-4")
    public String mission1_4(@RequestBody MissionData data) {

       log.info("name = {}",data.getName());
       log.info("age = {}",data.getAge());
       log.info("address = {}",data.getAddress());

       return "ok";
    }

}



