package io.meighen.presenter.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import io.meighen.presenter.entity.ExtModule;
import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.Role;
import io.meighen.presenter.entity.Script;
import io.meighen.presenter.entity.User;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.entity.dto.ScriptDto;
import io.meighen.presenter.entity.dto.UserDto;
import io.meighen.presenter.mapper.ObjectMapper;
import io.meighen.presenter.repository.BackupRepository;
import io.meighen.presenter.repository.ModuleRepository;
import io.meighen.presenter.repository.ObjectRepository;
import io.meighen.presenter.repository.RoleRepository;
import io.meighen.presenter.repository.UserRepository;
import io.meighen.presenter.service.ProducerService;
import io.meighen.presenter.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ModulesController.class, UserService.class, ProducerService.class})
@ExtendWith(SpringExtension.class)
class ModulesControllerTest {
    @MockBean
    private BackupRepository backupRepository;

    @MockBean
    private KafkaTemplate kafkaTemplate;

    @MockBean
    private ModuleRepository moduleRepository;

    @Autowired
    private ModulesController modulesController;

    @MockBean
    private ObjectMapper objectMapper;

    @MockBean
    private ObjectRepository objectRepository;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link ModulesController#createNewModule(String, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateNewModule() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen.presenter.controller.BasicPrivateController.getAuthentificatedUser(BasicPrivateController.java:18)
        //       at io.meighen.presenter.controller.ModulesController.createNewModule(ModulesController.java:196)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ModulesController()).createNewModule("Name", true);
    }

    /**
     * Method under test: {@link ModulesController#deleteModule(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteModule() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArithmeticException
        //       at io.meighen.presenter.controller.ModulesController.deleteModule(ModulesController.java:228)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ModulesController()).deleteModule("01234567-89AB-CDEF-FEDC-BA9876543210");
    }

    /**
     * Method under test: {@link ModulesController#getModuleInfo(String)}
     */
    @Test
    void testGetModuleInfo() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("Call Type");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("Main Method");
        script.setName("Name");
        script.setTopicName("Topic Name");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("Name");

        User user2 = new User();
        user2.setActivationCode("Activation Code");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("Second Name");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("Name");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(moduleRepository.findByUuid((String) any())).thenReturn(resultModule);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/modules/module")
                .param("uuid", "foo");
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":"
                                        + "[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\","
                                        + "\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\""
                                        + ",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1"
                                        + "],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfileImageUrl\":\"https://example.org"
                                        + "/example\"},\"name\":\"Name\",\"iinternal\":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210"
                                        + "\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane"
                                        + "\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\","
                                        + "\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,"
                                        + "\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am"
                                        + " GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https"
                                        + "://example.org/example\"},\"objects\":[],\"firstScript\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210"
                                        + "\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane"
                                        + "\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\","
                                        + "\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,"
                                        + "\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am"
                                        + " GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\"},\"body\":\"Not all who wander are"
                                        + " lost\"}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateCreation(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateCreation() throws Exception {
        when(moduleRepository.findAllByOrderByDateCreationAsc((Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateCreation");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"totalItems\":0,\"objects\":[],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateCreation(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateCreation2() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllByOrderByDateCreationAsc((Pageable) any())).thenReturn(pageImpl);

        Role role3 = new Role();
        role3.setId(1L);
        role3.setName("Name");

        User user3 = new User();
        user3.setActivationCode("Activation Code");
        user3.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setId(1L);
        user3.setLastName("Doe");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("6625550144");
        user3.setRole(role3);
        user3.setSecondName("Second Name");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("Call Type");
        extModule1.setCallUrl("https://example.org/example");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(1L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule1);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateCreation");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":1,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateCreation(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateCreation3() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role3 = new Role();
        role3.setId(2L);
        role3.setName("objects");

        User user3 = new User();
        user3.setActivationCode("objects");
        user3.setCreatedActivationCode("?");
        user3.setEmail("john.smith@example.org");
        user3.setFirstName("John");
        user3.setId(2L);
        user3.setLastName("Smith");
        user3.setPassword("?");
        user3.setPhoneNumber("8605550118");
        user3.setRole(role3);
        user3.setSecondName("objects");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("?");
        user3.setUsername("?");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("objects");
        extModule1.setCallUrl("?");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(2L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("1234");

        Role role4 = new Role();
        role4.setId(2L);
        role4.setName("objects");

        User user4 = new User();
        user4.setActivationCode("objects");
        user4.setCreatedActivationCode("?");
        user4.setEmail("john.smith@example.org");
        user4.setFirstName("John");
        user4.setId(2L);
        user4.setLastName("Smith");
        user4.setPassword("?");
        user4.setPhoneNumber("8605550118");
        user4.setRole(role4);
        user4.setSecondName("objects");
        user4.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setUserProfileImageUrl("?");
        user4.setUsername("?");

        Script script1 = new Script();
        script1.setBody("?");
        script1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setId(2L);
        script1.setLastModifier(user4);
        script1.setMainMethod("objects");
        script1.setName("objects");
        script1.setTopicName("objects");
        script1.setUuid("1234");

        Role role5 = new Role();
        role5.setId(2L);
        role5.setName("objects");

        User user5 = new User();
        user5.setActivationCode("objects");
        user5.setCreatedActivationCode("?");
        user5.setEmail("john.smith@example.org");
        user5.setFirstName("John");
        user5.setId(2L);
        user5.setLastName("Smith");
        user5.setPassword("?");
        user5.setPhoneNumber("8605550118");
        user5.setRole(role5);
        user5.setSecondName("objects");
        user5.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setUserProfileImageUrl("?");
        user5.setUsername("?");

        Module resultModule1 = new Module();
        resultModule1.setBody("?");
        resultModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setExtModule(extModule1);
        resultModule1.setFirstScript(script1);
        resultModule1.setId(2L);
        resultModule1.setIinternal(false);
        resultModule1.setLastModifier(user5);
        resultModule1.setName("objects");
        resultModule1.setObjects(new ArrayList<>());
        resultModule1.setUuid("1234");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule1);
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllByOrderByDateCreationAsc((Pageable) any())).thenReturn(pageImpl);

        Role role6 = new Role();
        role6.setId(1L);
        role6.setName("Name");

        User user6 = new User();
        user6.setActivationCode("Activation Code");
        user6.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setId(1L);
        user6.setLastName("Doe");
        user6.setPassword("iloveyou");
        user6.setPhoneNumber("6625550144");
        user6.setRole(role6);
        user6.setSecondName("Second Name");
        user6.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user6.setUserProfileImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        ExtModule extModule2 = new ExtModule();
        extModule2.setCallType("Call Type");
        extModule2.setCallUrl("https://example.org/example");
        extModule2.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setId(1L);
        extModule2.setLastModifier(user6);
        extModule2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule2);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateCreation");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":2,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "},{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\":true,\"extModule\":{\"id\":1,"
                                        + "\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1"
                                        + ",1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\""
                                        + ":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode"
                                        + "\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode"
                                        + "\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"callType\":\"Call"
                                        + " Type\",\"callUrl\":\"https://example.org/example\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF"
                                        + "-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all"
                                        + " who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\""
                                        + ":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null"
                                        + ",\"role\":null}},\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1"
                                        + ",1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,"
                                        + "\"email\":null,\"phoneNumber\":null,\"role\":null}}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateModification(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateModification() throws Exception {
        when(moduleRepository.findAllByOrderByDateModificationAsc((Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateModification");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"totalItems\":0,\"objects\":[],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateModification(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateModification2() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllByOrderByDateModificationAsc((Pageable) any())).thenReturn(pageImpl);

        Role role3 = new Role();
        role3.setId(1L);
        role3.setName("Name");

        User user3 = new User();
        user3.setActivationCode("Activation Code");
        user3.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setId(1L);
        user3.setLastName("Doe");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("6625550144");
        user3.setRole(role3);
        user3.setSecondName("Second Name");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("Call Type");
        extModule1.setCallUrl("https://example.org/example");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(1L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule1);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateModification");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":1,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByDateModification(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByDateModification3() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role3 = new Role();
        role3.setId(2L);
        role3.setName("objects");

        User user3 = new User();
        user3.setActivationCode("objects");
        user3.setCreatedActivationCode("?");
        user3.setEmail("john.smith@example.org");
        user3.setFirstName("John");
        user3.setId(2L);
        user3.setLastName("Smith");
        user3.setPassword("?");
        user3.setPhoneNumber("8605550118");
        user3.setRole(role3);
        user3.setSecondName("objects");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("?");
        user3.setUsername("?");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("objects");
        extModule1.setCallUrl("?");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(2L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("1234");

        Role role4 = new Role();
        role4.setId(2L);
        role4.setName("objects");

        User user4 = new User();
        user4.setActivationCode("objects");
        user4.setCreatedActivationCode("?");
        user4.setEmail("john.smith@example.org");
        user4.setFirstName("John");
        user4.setId(2L);
        user4.setLastName("Smith");
        user4.setPassword("?");
        user4.setPhoneNumber("8605550118");
        user4.setRole(role4);
        user4.setSecondName("objects");
        user4.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setUserProfileImageUrl("?");
        user4.setUsername("?");

        Script script1 = new Script();
        script1.setBody("?");
        script1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setId(2L);
        script1.setLastModifier(user4);
        script1.setMainMethod("objects");
        script1.setName("objects");
        script1.setTopicName("objects");
        script1.setUuid("1234");

        Role role5 = new Role();
        role5.setId(2L);
        role5.setName("objects");

        User user5 = new User();
        user5.setActivationCode("objects");
        user5.setCreatedActivationCode("?");
        user5.setEmail("john.smith@example.org");
        user5.setFirstName("John");
        user5.setId(2L);
        user5.setLastName("Smith");
        user5.setPassword("?");
        user5.setPhoneNumber("8605550118");
        user5.setRole(role5);
        user5.setSecondName("objects");
        user5.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setUserProfileImageUrl("?");
        user5.setUsername("?");

        Module resultModule1 = new Module();
        resultModule1.setBody("?");
        resultModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setExtModule(extModule1);
        resultModule1.setFirstScript(script1);
        resultModule1.setId(2L);
        resultModule1.setIinternal(false);
        resultModule1.setLastModifier(user5);
        resultModule1.setName("objects");
        resultModule1.setObjects(new ArrayList<>());
        resultModule1.setUuid("1234");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule1);
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllByOrderByDateModificationAsc((Pageable) any())).thenReturn(pageImpl);

        Role role6 = new Role();
        role6.setId(1L);
        role6.setName("Name");

        User user6 = new User();
        user6.setActivationCode("Activation Code");
        user6.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setId(1L);
        user6.setLastName("Doe");
        user6.setPassword("iloveyou");
        user6.setPhoneNumber("6625550144");
        user6.setRole(role6);
        user6.setSecondName("Second Name");
        user6.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user6.setUserProfileImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        ExtModule extModule2 = new ExtModule();
        extModule2.setCallType("Call Type");
        extModule2.setCallUrl("https://example.org/example");
        extModule2.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setId(1L);
        extModule2.setLastModifier(user6);
        extModule2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule2);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byDateModification");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":2,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "},{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\":true,\"extModule\":{\"id\":1,"
                                        + "\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1"
                                        + ",1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\""
                                        + ":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode"
                                        + "\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode"
                                        + "\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"callType\":\"Call"
                                        + " Type\",\"callUrl\":\"https://example.org/example\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF"
                                        + "-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all"
                                        + " who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\""
                                        + ":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null"
                                        + ",\"role\":null}},\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1"
                                        + ",1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,"
                                        + "\"email\":null,\"phoneNumber\":null,\"role\":null}}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByLastModifier(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByLastModifier() throws Exception {
        when(moduleRepository.findAllOrderByLastModifier_FirstNameAsc((Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byModifier");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"totalItems\":0,\"objects\":[],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByLastModifier(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByLastModifier2() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllOrderByLastModifier_FirstNameAsc((Pageable) any())).thenReturn(pageImpl);

        Role role3 = new Role();
        role3.setId(1L);
        role3.setName("Name");

        User user3 = new User();
        user3.setActivationCode("Activation Code");
        user3.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setId(1L);
        user3.setLastName("Doe");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("6625550144");
        user3.setRole(role3);
        user3.setSecondName("Second Name");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("Call Type");
        extModule1.setCallUrl("https://example.org/example");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(1L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule1);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byModifier");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":1,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByLastModifier(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByLastModifier3() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role3 = new Role();
        role3.setId(2L);
        role3.setName("objects");

        User user3 = new User();
        user3.setActivationCode("objects");
        user3.setCreatedActivationCode("?");
        user3.setEmail("john.smith@example.org");
        user3.setFirstName("John");
        user3.setId(2L);
        user3.setLastName("Smith");
        user3.setPassword("?");
        user3.setPhoneNumber("8605550118");
        user3.setRole(role3);
        user3.setSecondName("objects");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("?");
        user3.setUsername("?");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("objects");
        extModule1.setCallUrl("?");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(2L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("1234");

        Role role4 = new Role();
        role4.setId(2L);
        role4.setName("objects");

        User user4 = new User();
        user4.setActivationCode("objects");
        user4.setCreatedActivationCode("?");
        user4.setEmail("john.smith@example.org");
        user4.setFirstName("John");
        user4.setId(2L);
        user4.setLastName("Smith");
        user4.setPassword("?");
        user4.setPhoneNumber("8605550118");
        user4.setRole(role4);
        user4.setSecondName("objects");
        user4.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setUserProfileImageUrl("?");
        user4.setUsername("?");

        Script script1 = new Script();
        script1.setBody("?");
        script1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setId(2L);
        script1.setLastModifier(user4);
        script1.setMainMethod("objects");
        script1.setName("objects");
        script1.setTopicName("objects");
        script1.setUuid("1234");

        Role role5 = new Role();
        role5.setId(2L);
        role5.setName("objects");

        User user5 = new User();
        user5.setActivationCode("objects");
        user5.setCreatedActivationCode("?");
        user5.setEmail("john.smith@example.org");
        user5.setFirstName("John");
        user5.setId(2L);
        user5.setLastName("Smith");
        user5.setPassword("?");
        user5.setPhoneNumber("8605550118");
        user5.setRole(role5);
        user5.setSecondName("objects");
        user5.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setUserProfileImageUrl("?");
        user5.setUsername("?");

        Module resultModule1 = new Module();
        resultModule1.setBody("?");
        resultModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setExtModule(extModule1);
        resultModule1.setFirstScript(script1);
        resultModule1.setId(2L);
        resultModule1.setIinternal(false);
        resultModule1.setLastModifier(user5);
        resultModule1.setName("objects");
        resultModule1.setObjects(new ArrayList<>());
        resultModule1.setUuid("1234");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule1);
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAllOrderByLastModifier_FirstNameAsc((Pageable) any())).thenReturn(pageImpl);

        Role role6 = new Role();
        role6.setId(1L);
        role6.setName("Name");

        User user6 = new User();
        user6.setActivationCode("Activation Code");
        user6.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setId(1L);
        user6.setLastName("Doe");
        user6.setPassword("iloveyou");
        user6.setPhoneNumber("6625550144");
        user6.setRole(role6);
        user6.setSecondName("Second Name");
        user6.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user6.setUserProfileImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        ExtModule extModule2 = new ExtModule();
        extModule2.setCallType("Call Type");
        extModule2.setCallUrl("https://example.org/example");
        extModule2.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setId(1L);
        extModule2.setLastModifier(user6);
        extModule2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule2);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/all/byModifier");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":2,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "},{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\":true,\"extModule\":{\"id\":1,"
                                        + "\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1"
                                        + ",1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\""
                                        + ":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode"
                                        + "\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode"
                                        + "\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"callType\":\"Call"
                                        + " Type\",\"callUrl\":\"https://example.org/example\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF"
                                        + "-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all"
                                        + " who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\""
                                        + ":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null"
                                        + ",\"role\":null}},\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1"
                                        + ",1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,"
                                        + "\"email\":null,\"phoneNumber\":null,\"role\":null}}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByPage(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByPage() throws Exception {
        when(moduleRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"totalItems\":0,\"objects\":[],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByPage(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByPage2() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAll((Pageable) any())).thenReturn(pageImpl);

        Role role3 = new Role();
        role3.setId(1L);
        role3.setName("Name");

        User user3 = new User();
        user3.setActivationCode("Activation Code");
        user3.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setId(1L);
        user3.setLastName("Doe");
        user3.setPassword("iloveyou");
        user3.setPhoneNumber("6625550144");
        user3.setRole(role3);
        user3.setSecondName("Second Name");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("Call Type");
        extModule1.setCallUrl("https://example.org/example");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(1L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule1);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":1,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getModulesByPage(String, int, int, boolean)}
     */
    @Test
    void testGetModulesByPage3() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("?");

        User user = new User();
        user.setActivationCode("?");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("?");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("?");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role1 = new Role();
        role1.setId(1L);
        role1.setName("?");

        User user1 = new User();
        user1.setActivationCode("?");
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("6625550144");
        user1.setRole(role1);
        user1.setSecondName("?");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUsername("janedoe");

        Script script = new Script();
        script.setBody("Not all who wander are lost");
        script.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script.setId(1L);
        script.setLastModifier(user1);
        script.setMainMethod("?");
        script.setName("?");
        script.setTopicName("?");
        script.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role2 = new Role();
        role2.setId(1L);
        role2.setName("?");

        User user2 = new User();
        user2.setActivationCode("?");
        user2.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setPassword("iloveyou");
        user2.setPhoneNumber("6625550144");
        user2.setRole(role2);
        user2.setSecondName("?");
        user2.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user2.setUserProfileImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        Module resultModule = new Module();
        resultModule.setBody("Not all who wander are lost");
        resultModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule.setExtModule(extModule);
        resultModule.setFirstScript(script);
        resultModule.setId(1L);
        resultModule.setIinternal(true);
        resultModule.setLastModifier(user2);
        resultModule.setName("?");
        resultModule.setObjects(new ArrayList<>());
        resultModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        Role role3 = new Role();
        role3.setId(2L);
        role3.setName("objects");

        User user3 = new User();
        user3.setActivationCode("objects");
        user3.setCreatedActivationCode("?");
        user3.setEmail("john.smith@example.org");
        user3.setFirstName("John");
        user3.setId(2L);
        user3.setLastName("Smith");
        user3.setPassword("?");
        user3.setPhoneNumber("8605550118");
        user3.setRole(role3);
        user3.setSecondName("objects");
        user3.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user3.setUserProfileImageUrl("?");
        user3.setUsername("?");

        ExtModule extModule1 = new ExtModule();
        extModule1.setCallType("objects");
        extModule1.setCallUrl("?");
        extModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule1.setId(2L);
        extModule1.setLastModifier(user3);
        extModule1.setUuid("1234");

        Role role4 = new Role();
        role4.setId(2L);
        role4.setName("objects");

        User user4 = new User();
        user4.setActivationCode("objects");
        user4.setCreatedActivationCode("?");
        user4.setEmail("john.smith@example.org");
        user4.setFirstName("John");
        user4.setId(2L);
        user4.setLastName("Smith");
        user4.setPassword("?");
        user4.setPhoneNumber("8605550118");
        user4.setRole(role4);
        user4.setSecondName("objects");
        user4.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user4.setUserProfileImageUrl("?");
        user4.setUsername("?");

        Script script1 = new Script();
        script1.setBody("?");
        script1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        script1.setId(2L);
        script1.setLastModifier(user4);
        script1.setMainMethod("objects");
        script1.setName("objects");
        script1.setTopicName("objects");
        script1.setUuid("1234");

        Role role5 = new Role();
        role5.setId(2L);
        role5.setName("objects");

        User user5 = new User();
        user5.setActivationCode("objects");
        user5.setCreatedActivationCode("?");
        user5.setEmail("john.smith@example.org");
        user5.setFirstName("John");
        user5.setId(2L);
        user5.setLastName("Smith");
        user5.setPassword("?");
        user5.setPhoneNumber("8605550118");
        user5.setRole(role5);
        user5.setSecondName("objects");
        user5.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user5.setUserProfileImageUrl("?");
        user5.setUsername("?");

        Module resultModule1 = new Module();
        resultModule1.setBody("?");
        resultModule1.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        resultModule1.setExtModule(extModule1);
        resultModule1.setFirstScript(script1);
        resultModule1.setId(2L);
        resultModule1.setIinternal(false);
        resultModule1.setLastModifier(user5);
        resultModule1.setName("objects");
        resultModule1.setObjects(new ArrayList<>());
        resultModule1.setUuid("1234");

        ArrayList<Module> resultModuleList = new ArrayList<>();
        resultModuleList.add(resultModule1);
        resultModuleList.add(resultModule);
        PageImpl<Module> pageImpl = new PageImpl<>(resultModuleList);
        when(moduleRepository.findAll((Pageable) any())).thenReturn(pageImpl);

        Role role6 = new Role();
        role6.setId(1L);
        role6.setName("Name");

        User user6 = new User();
        user6.setActivationCode("Activation Code");
        user6.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setId(1L);
        user6.setLastName("Doe");
        user6.setPassword("iloveyou");
        user6.setPhoneNumber("6625550144");
        user6.setRole(role6);
        user6.setSecondName("Second Name");
        user6.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user6.setUserProfileImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        ExtModule extModule2 = new ExtModule();
        extModule2.setCallType("Call Type");
        extModule2.setCallUrl("https://example.org/example");
        extModule2.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule2.setId(1L);
        extModule2.setLastModifier(user6);
        extModule2.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule2);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        when(objectMapper.modelToDto((Module) any())).thenReturn(moduleDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/");
        MockHttpServletRequestBuilder paramResult = getResult.param("page", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("size", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"totalItems\":2,\"objects\":[{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\""
                                        + ":true,\"extModule\":{\"id\":1,\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second"
                                        + " Name\",\"lastName\":\"Doe\",\"username\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
                                        + "\"phoneNumber\":\"6625550144\",\"activationCode\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},"
                                        + "\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfi"
                                        + "leImageUrl\":\"https://example.org/example\"},\"callType\":\"Call Type\",\"callUrl\":\"https://example.org/example"
                                        + "\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main"
                                        + " Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],"
                                        + "\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\""
                                        + ":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}},\"body\":\"Not all who wander are"
                                        + " lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\""
                                        + ":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null,\"role\":null}"
                                        + "},{\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"name\":\"Name\",\"iinternal\":true,\"extModule\":{\"id\":1,"
                                        + "\"uuid\":\"01234567-89AB-CDEF-FEDC-BA9876543210\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1"
                                        + ",1],\"lastModifier\":{\"id\":1,\"firstName\":\"Jane\",\"secondName\":\"Second Name\",\"lastName\":\"Doe\",\"username\""
                                        + ":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"phoneNumber\":\"6625550144\",\"activationCode"
                                        + "\":\"Activation Code\",\"role\":{\"id\":1,\"name\":\"Name\"},\"timeOfAccountCreation\":[1,1,1,1,1],\"createdActivationCode"
                                        + "\":\"Jan 1, 2020 8:00am GMT+0100\",\"userProfileImageUrl\":\"https://example.org/example\"},\"callType\":\"Call"
                                        + " Type\",\"callUrl\":\"https://example.org/example\"},\"objects\":[],\"firstScript\":{\"uuid\":\"01234567-89AB-CDEF"
                                        + "-FEDC-BA9876543210\",\"name\":\"Name\",\"mainMethod\":\"Main Method\",\"topicName\":\"Topic Name\",\"body\":\"Not all"
                                        + " who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1,1,1,1,1],\"lastModifier\":{\"id\""
                                        + ":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,\"email\":null,\"phoneNumber\":null"
                                        + ",\"role\":null}},\"body\":\"Not all who wander are lost\",\"dateCreation\":[1,1,1,1,1],\"dateModification\":[1"
                                        + ",1,1,1,1],\"lastModifier\":{\"id\":0,\"firstName\":null,\"secondName\":null,\"lastName\":null,\"username\":null,"
                                        + "\"email\":null,\"phoneNumber\":null,\"role\":null}}],\"totalPages\":1,\"currentPage\":0}"));
    }

    /**
     * Method under test: {@link ModulesController#getPagesCount(Integer)}
     */
    @Test
    void testGetPagesCount() throws Exception {
        when(moduleRepository.count()).thenReturn(3L);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/modules/count_pages");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("onOnePage", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"countPages\":3}"));
    }

    /**
     * Method under test: {@link ModulesController#updateModule(String, ModuleDto)}
     */
    @Test
    void testUpdateModule() throws Exception {
        Role role = new Role();
        role.setId(1L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("6625550144");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        ExtModule extModule = new ExtModule();
        extModule.setCallType("Call Type");
        extModule.setCallUrl("https://example.org/example");
        extModule.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        extModule.setId(1L);
        extModule.setLastModifier(user);
        extModule.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ScriptDto scriptDto = new ScriptDto();
        scriptDto.setBody("Not all who wander are lost");
        scriptDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        scriptDto.setLastModifier(new UserDto());
        scriptDto.setMainMethod("Main Method");
        scriptDto.setName("Name");
        scriptDto.setTopicName("Topic Name");
        scriptDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setBody("Not all who wander are lost");
        moduleDto.setDateCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setDateModification(LocalDateTime.of(1, 1, 1, 1, 1));
        moduleDto.setExtModule(extModule);
        moduleDto.setFirstScript(scriptDto);
        moduleDto.setIinternal(true);
        moduleDto.setLastModifier(new UserDto());
        moduleDto.setName("Name");
        moduleDto.setObjects(new ArrayList<>());
        moduleDto.setUuid("01234567-89AB-CDEF-FEDC-BA9876543210");
        String content = (new com.fasterxml.jackson.databind.ObjectMapper()).writeValueAsString(moduleDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/modules/module")
                .param("uuid", "foo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(modulesController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

