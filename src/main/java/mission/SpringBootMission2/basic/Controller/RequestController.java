package mission.SpringBootMission2.basic.Controller;

import lombok.extern.slf4j.Slf4j;
import mission.SpringBootMission2.basic.Model.MissionData;
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

    @PostMapping("/mission1-1")
    public void mission1_1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}",messageBody);

        response.getWriter().write("ok");

    }

    @PostMapping("/mission1-2")
    public String mission1_2(@RequestBody Map<String,String> map) {
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        System.out.println(map.get("address"));

        return "ok";
    }

    //JSON
    @PostMapping(value="/mission1-3")
    public String mission1_2(@RequestBody MissionData data) {
       log.info("messageBody = {}",data);

       return "ok";
    }

}



