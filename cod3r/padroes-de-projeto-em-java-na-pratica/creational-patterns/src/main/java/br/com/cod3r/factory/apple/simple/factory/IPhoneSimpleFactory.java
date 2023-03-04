package br.com.cod3r.factory.apple.simple.factory;

import br.com.cod3r.factory.apple.model.*;

public class IPhoneSimpleFactory {

    public static IPhone orderIphone(String generation, String level) {
        IPhone device = createIphone(generation, level);

        if (device != null) {
            device.getHardware();
            device.assemble();
            device.certificates();
            device.pack();
        }

        return device;
    }

    private static IPhone createIphone(String generation, String level) {

        if(isGeneration11(generation)) {
            return createGeneration11(level);
        } else if(isGenerationX(generation)) {
            return createGenerationX(level);
        }

        return null;
    }

    private static boolean isGeneration11(String generation) {
        return "11".equals(generation);
    }

    private static boolean isGenerationX(String generation) {
        return "X".equals(generation);
    }

    private static IPhone createGeneration11(String level) {
        if("standard".equals(level)) {
            return new IPhone11();
        } else if("highEnd".equals(level)) {
            return new IPhone11Pro();
        }

        return null;
    }

    private static IPhone createGenerationX(String level) {
        if("standard".equals(level)) {
            return new IPhoneX();
        } else if("highEnd".equals(level)) {
            return new IPhoneXSMax();
        }

        return null;
    }
}
