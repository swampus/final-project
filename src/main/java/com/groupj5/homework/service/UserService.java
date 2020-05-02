package com.groupj5.homework.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.groupj5.homework.database.NoSQLDatabaseService;
import com.groupj5.homework.dto.UserDTO;
import com.groupj5.homework.dto.mapper.UserMapper;
import com.groupj5.homework.exceptions.ServiceException;
import com.groupj5.homework.handler.ErrorCode;
import com.groupj5.homework.model.v1.User;
import com.groupj5.homework.repository.UserRepository;
import com.groupj5.homework.service.validator.TestValidator;
import com.groupj5.homework.service.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service("viens")
public class UserService {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;
    private final NoSQLDatabaseService noSQLDatabaseService;


    @Autowired
    private TestValidator testValidator;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserMapper userMapper, UserValidator userValidator, ObjectMapper objectMapper,
                       NoSQLDatabaseService noSQLDatabaseService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
        this.objectMapper = objectMapper;
        this.noSQLDatabaseService = noSQLDatabaseService;
    }

    public void userAuth(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new ServiceException(ErrorCode.GEN_USR_20,
                    ImmutableMap.of("email", email),
                    "en");
        }
    }

    public List<UserDTO> getAllUsers() {

        try {

            String strkey="blowfish";
            SecretKeySpec key = null;
            key = new SecretKeySpec(strkey.getBytes(StandardCharsets.UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            String encryptedData = null;
            encryptedData = new String(cipher.doFinal("encrypt".getBytes(StandardCharsets.UTF_8)));

            System.out.println("ENCRYPTES: " + encryptedData);
            System.out.println("ENCRYPTES: " + Base64.getEncoder()
                    .encodeToString(encryptedData.getBytes()));
            System.out.println("ENCRYPTES: " +
                    Arrays.toString(Base64.getEncoder()
                            .encodeToString(encryptedData.getBytes()).getBytes()));
            System.out.println("ENCRYPTES: " + Arrays.toString(encryptedData.getBytes(StandardCharsets.UTF_8)));
            cipher.init(Cipher.DECRYPT_MODE, key);


        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        }


        return userRepository.findAll().stream()
                .map(userMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {

        userValidator.checkNotAdmin(id);
        userValidator.checkNonUnlakcyUser(id);

        try {
            User user = userRepository.getOne(id);
            String hash = noSQLDatabaseService.getValue(user.getUserPk());
            return userMapper.userToDto(user, hash);
        } catch (EntityNotFoundException e) {
            throw new ServiceException(ErrorCode.GEN_USR_01,
                    ImmutableMap.of("id", String.valueOf(id)),
                    "en");
        }
    }

    public UserDTO createUser(UserDTO userDTO, String hashPassword) {
        User user = userMapper.fromDTO(userDTO);
        user.setPassword(hashPassword);
        noSQLDatabaseService.putValue(user.getUserPk(), "32487290374928742972938");
        User userCreated = userRepository.save(user);
        return userMapper.userToDto(userCreated);
    }

    public void updateUser(UserDTO userDTO) {
        User user = userMapper.fromDTO(userDTO);
        userRepository.save(user);
    }


    public UserDTO findByUserPersonalCode(String pk) {
        return userMapper.userToDto(userRepository.findOne(Example.of(User.from(pk))).orElseThrow(
                () -> new ServiceException(ErrorCode.GEN_USR_01,
                        ImmutableMap.of("pk", String.valueOf(pk)),
                        "en")));
    }

    public UserDTO findByUserPkAndStatus(String pk, Integer status) {


        User user = userRepository.findByUserPkAndStatus(pk, status);
        return userMapper.userToDto(user);
    }

}
