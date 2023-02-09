package hello.springmvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hello");
        return "OK";
    }


    @GetMapping(value = "/hello-basic2")
    public String helloBasic2() {
        log.info("hello");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "OK";
    }

    /**
     * PathVariable 다중 사용
     */
    @GetMapping("/mapping/user/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * @return
     */
    @GetMapping(value = "/mapping-param", params = {"mode=debug", "data=good"})
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더 매핑
     * @return
     */
    @GetMapping(value = "/mapping-header", headers = "mode=run")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑
     * @return
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }

    /**
     * 미디어 타입 조건 매핑 - HTTP  요청 Accept, produce
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }
}
