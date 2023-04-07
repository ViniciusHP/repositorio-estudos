package br.com.cod3r.chain.process.service;

import br.com.cod3r.chain.process.steps.*;

public class ServicesCatalog {
    public static ProcessStep saveUserProcess = buildChain(
            new CreateMap("input"),
            new ValidateMandatoryField("input.name"),
            new ValidateMandatoryField("input.email"),
            new ValidateMandatoryField("input.password"),
            new SaveUser());
    public static ProcessStep loginProcess = buildChain(
            new CreateMap("input"),
            new ValidateMandatoryField("input.email"),
            new ValidateMandatoryField("input.password"),
            new GetUserByEmail(),
            new CheckPassword(),
            new GetUserToken());
    public static ProcessStep getUsersProcess = buildChain(
            new ValidateToken(),
            new GetUsers());

    private static ProcessStep buildChain(ProcessStep... processSteps) {
        for(int i = 0; i < processSteps.length - 1 ; i++) {
            ProcessStep processStep = processSteps[i];
            processStep.setNextStep(processSteps[i + 1]);
        }

        return processSteps[0];
    }
}
