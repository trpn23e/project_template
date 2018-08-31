package net.pis.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

@Slf4j
public class JSONResponse {


    protected static final String APPLICATION_JSON = "application/json; charset=UTF-8";


    public static ResponseEntity getJSONResponse(HttpServletRequest req, final Object obj){


        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();

        String jsonStr = gson.toJson(obj);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type",APPLICATION_JSON);

        return new ResponseEntity(jsonStr, responseHeaders, HttpStatus.OK);


    }


}
