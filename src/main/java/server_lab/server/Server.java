package server_lab.server;

import server_lab.controllers.group.ControllerGroup;
import server_lab.controllers.student.ControllerStudent;
import server_lab.controllers.teacher.ControllerTeacher;
import server_lab.exception.ServerException;
import server_lab.repositories.DataBase;
import server_lab.repositories.RepositoryGroup;
import server_lab.repositories.RepositoryStudent;
import server_lab.repositories.RepositoryTeacher;
import server_lab.server.handlers.EndpointHandler;
import server_lab.server.handlers.group.*;
import server_lab.server.handlers.student.*;
import server_lab.server.handlers.teacher.AddTeacherHandler;
import server_lab.services.group.*;
import server_lab.services.student.*;
import server_lab.services.teacher.AddTeacherService;
import server_lab.validator.group.*;
import server_lab.validator.primitive.ValidateString;
import server_lab.validator.primitive.ValidatorId;
import server_lab.validator.student.*;
import server_lab.validator.teacher.AddTeacherValidator;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, EndpointHandler> endpointMap;
    private DataBase dataBase;
    private ControllerGroup controllerGroup;
    private ControllerStudent controllerStudent;
    private ControllerTeacher controllerTeacher;

    public Server() {
        this.dataBase = new DataBase();
        this.endpointMap = new HashMap<>();

        System.out.println("Server ON");
    }

    public void initGroup() {
        RepositoryGroup repositoryGroup = new RepositoryGroup(dataBase);

        ValidatorId validatorId = new ValidatorId();
        ValidateString validateString = new ValidateString();

        AddStudentGroupsValidator addStudentGroupsValidator = new AddStudentGroupsValidator(validateString);
        DeleteStudentGroupValidator deleteStudentGroupValidator = new DeleteStudentGroupValidator(validatorId);
        EditStudentGroupsValidator editStudentGroupsValidator = new EditStudentGroupsValidator(validateString, validatorId);
        GetStudentGroupByIdValidator getStudentGroupByIdValidator = new GetStudentGroupByIdValidator(validatorId);

        AddStudentGroupsService addStudentGroupsService = new AddStudentGroupsService(repositoryGroup);
        DeleteStudentGroupService deleteStudentGroupService = new DeleteStudentGroupService(repositoryGroup);
        EditStudentGroupsService editStudentGroupsService = new EditStudentGroupsService(repositoryGroup);
        GetStudentGroupByIdService getStudentGroupByIdService = new GetStudentGroupByIdService(repositoryGroup);
        GetStudentGroupsService getStudentGroupsService = new GetStudentGroupsService(repositoryGroup);

        controllerGroup = new ControllerGroup(addStudentGroupsService,
                deleteStudentGroupService,
                editStudentGroupsService,
                getStudentGroupsService,
                getStudentGroupByIdService,
                addStudentGroupsValidator,
                editStudentGroupsValidator,
                deleteStudentGroupValidator,
                getStudentGroupByIdValidator);

        endpointMap.put("addStudentGroups", new AddStudentGroupsHandler(controllerGroup));
        endpointMap.put("getStudentGroups", new GetStudentGroupsHandler(controllerGroup));
        endpointMap.put("deleteStudentGroup", new DeleteStudentGroupHandler(controllerGroup));
        endpointMap.put("editStudentGroups", new EditStudentGroupsHandler(controllerGroup));
        endpointMap.put("getStudentGroupById", new GetStudentGroupByIdHandler(controllerGroup));

        System.out.println("Group init");
    }
    public void initTeacher() {
        RepositoryTeacher repositoryTeacher = new RepositoryTeacher(dataBase);

        ValidatorId validatorId = new ValidatorId();
        ValidateString validateString = new ValidateString();

        AddTeacherValidator addTeachersValidator = new AddTeacherValidator(validateString);

        AddTeacherService addTeachersService = new AddTeacherService(repositoryTeacher);


        controllerTeacher = new ControllerTeacher(addTeachersService,

                addTeachersValidator);

        endpointMap.put("addTeacher", new AddTeacherHandler(controllerTeacher));


        System.out.println("Teacher init");
    }

    public void initStudent() {
        RepositoryStudent repositoryStudent = new RepositoryStudent(dataBase);

        ValidatorId validatorId = new ValidatorId();
        ValidateString validateString = new ValidateString();

        AddStudentValidator addStudentValidator = new AddStudentValidator(validateString, validatorId);
        DeleteStudentValidator deleteStudentValidator = new DeleteStudentValidator(validatorId);
        EditStudentValidator editStudentValidator = new EditStudentValidator(validateString, validatorId);
        GetStudentByGroupValidator getStudentByGroupValidator = new GetStudentByGroupValidator(validatorId);
        GetStudentByIdValidator getStudentByIdValidator = new GetStudentByIdValidator(validatorId);

        AddStudentService addStudentService = new AddStudentService(repositoryStudent);
        DeleteStudentService deleteStudentService = new DeleteStudentService(repositoryStudent);
        EditStudentService editStudentService = new EditStudentService(repositoryStudent);
        GetStudentByGroupService getStudentByGroupService = new GetStudentByGroupService(repositoryStudent);
        GetStudentByIdService getStudentByIdService = new GetStudentByIdService(repositoryStudent);

        controllerStudent = new ControllerStudent(addStudentService,
                editStudentService,
                deleteStudentService,
                getStudentByIdService,
                getStudentByGroupService,
                addStudentValidator,
                editStudentValidator,
                deleteStudentValidator,
                getStudentByIdValidator,
                getStudentByGroupValidator);

        endpointMap.put("addStudent", new AddStudentHandler(controllerStudent));
        endpointMap.put("getStudentByGroup", new GetStudentByGroupHandler(controllerStudent));
        endpointMap.put("deleteStudent", new DeleteStudentHandler(controllerStudent));
        endpointMap.put("editStudent", new EditStudentHandler(controllerStudent));
        endpointMap.put("getStudentById", new GetStudentByIdHandler(controllerStudent));

        System.out.println("Student init");
    }

    public Writer executeRequest(Reader reader) throws ServerException {
        if (!endpointMap.containsKey(reader.getEndpoint())) {
            throw new ServerException("Неправельный запрос");
        }
        try {
            return new Writer(endpointMap.get(reader.getEndpoint()).handel(reader.getJson()));
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }
}
