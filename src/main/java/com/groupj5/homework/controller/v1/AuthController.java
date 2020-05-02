package com.groupj5.homework.controller.v1;

import com.groupj5.homework.auth.CryptService;
import com.groupj5.homework.database.NoSQLDatabaseService;
import com.groupj5.homework.dto.AuthOkResponse;
import com.groupj5.homework.dto.AuthTockenResponse;
import com.groupj5.homework.dto.request.AuthRequestDTO;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.service.AuthService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/rest/Auth")
public class AuthController {

    private final NoSQLDatabaseService noSQLDatabaseService;

    private final AuthService authService;
    private final CryptService cryptService;

    @Autowired
    public AuthController(NoSQLDatabaseService noSQLDatabaseService, AuthService authService, CryptService cryptService) {
        this.noSQLDatabaseService = noSQLDatabaseService;
        this.authService = authService;
        this.cryptService = cryptService;
    }

    @GetMapping("/auth({username})")
    public AuthTockenResponse getRandomString(@PathVariable String username) {
        String generatedString = RandomStringUtils.random(8, true, true);
        noSQLDatabaseService.putValue(username, generatedString);
        return createAuthTockenResponse(username, generatedString);
    }

    @PostMapping("/auth/login")
    public AuthOkResponse login(@RequestBody AuthRequestDTO authRequestDTO) {


        String cryptedPassword = authService.getUserPassword(authRequestDTO.getUsername());
        String originalPassword = cryptService.decrypt(cryptedPassword, CryptService.APP_KEY);

        String tockenWeSendToClient = noSQLDatabaseService.getValue(authRequestDTO.getUsername());
        //pass1
        String cryptTokenResult = cryptService.encrypt(tockenWeSendToClient, originalPassword);

        if (authRequestDTO.getCryptedToken().equals(cryptTokenResult)) {
            AuthOkResponse authOkResponse = new AuthOkResponse();
            authOkResponse.setSecretContnet("main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning\n" +
                    "2020-05-02 13:17:08.153  INFO 7712 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed\n" +
                    "2020-05-02 13:17:08.163  INFO 7712 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)\n" +
                    "2020-05-02 13:17:08.169  INFO 7712 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references\n" +
                    "2020-05-02 13:17:08.304  INFO 7712 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''\n" +
                    "2020-05-02 13:17:08.305  INFO 7712 --- [           main] com.groupj5.homework.Application         : Started Application in 2.717 seconds (JVM running for 3.107)");
            noSQLDatabaseService.remove(authRequestDTO.getUsername());
            return authOkResponse;
        } else {
            noSQLDatabaseService.remove(authRequestDTO.getUsername());
            throw new ServiceException(ErrorCode.GEN_USR_20, new HashMap<>(), "en");
        }

        // User from DB
        // DECRYPT PASSWORD
        // CRYPT SAME TOKEN USING USER PASSWORD
    }


    private AuthTockenResponse createAuthTockenResponse(@PathVariable String username, String generatedString) {
        AuthTockenResponse authTockenResponse = new AuthTockenResponse();
        authTockenResponse.setToken(generatedString);
        authTockenResponse.setUserName(username);
        return authTockenResponse;
    }
}
