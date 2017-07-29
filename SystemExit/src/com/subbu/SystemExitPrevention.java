package com.subbu;

import java.security.Permission;

public class SystemExitPrevention {
 
    public static void main(String[] args) {
        System.out.println("Preventing System.exit");
        SystemExitControl.forbidSystemExitCall();
 
        try {
            System.out.println("Running a program which calls System.exit");
            ProgramWithExitCall.main(args);
        } catch (SystemExitControl.ExitTrappedException e) {
            System.out.println("Forbidding call to System.exit");
        }
 
        System.out.println("Allowing System.exit");
        SystemExitControl.enableSystemExitCall();
 
        System.out.println("Running the same program without System.exit prevention");
        ProgramWithExitCall.main(args);
 
        System.out.println("This code never executes because the JVM has exited");
    }
}
 
class ProgramWithExitCall {
 
    public static void main(String[] args) {
        System.exit(0);
    }
}
 
class SystemExitControl {
 
    public static class ExitTrappedException extends SecurityException {
    }
 
    public static void forbidSystemExitCall() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
 
    public static void enableSystemExitCall() {
        System.setSecurityManager(null);
    }
}

