package lesson17.homework4;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validate("https://sd.org//"));
        System.out.println(validate("http://sd.org"));
        System.out.println(validate("https://sd.org"));
        System.out.println(validate("sd.org"));
        System.out.println(validate("sd"));
    }

    //the 4th task
    public static boolean validate(String address) {
        if (address == null || address.isEmpty() || address.isBlank()) {
            return false;
        }

        int protocolLength = calculateProtocolLength(address);
        if (protocolLength == -1) {
            return false;
        }

        int domainLength = calculateDomainLength(address);
        if (domainLength == -1) {
            return false;
        }

        boolean hasSpecChar = checkMiddlePartForSpecialChars(address, protocolLength, domainLength);

        return !hasSpecChar;
    }

    private static int calculateProtocolLength(String address) {
        String[] validProtocols = {"https://", "http://"};

        if (address == null) {
            return -1;
        }

        for (String validProtocol : validProtocols) {
            if (address.startsWith(validProtocol)) {
                return validProtocol.length();
            }
        }
        return -1;
    }

    private static int calculateDomainLength(String address) {
        String[] validDomains = {".com", ".org", ".net"};

        if (address == null) {
            return -1;
        }

        for (String validDomain : validDomains) {
            if (address.endsWith(validDomain)) {
                return validDomain.length();
            }
        }
        return -1;
    }

    private static boolean checkMiddlePartForSpecialChars(String address, int protocolLength, int domainLength) {
        char[] addressChars = address.substring(protocolLength, address.length() - domainLength).toCharArray();

        for (char aChar : addressChars) {
            if (!Character.isLetterOrDigit(aChar)) {
                return true;
            }
        }
        return false;
    }
}
