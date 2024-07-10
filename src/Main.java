public class Main {
    private static final String VALID_SYMBOLS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";

    public static void main(String[] args) {
        try {
            authenticationUser("123uuyO", "32r2f", "32r2f");
        } catch (WrongLoginException wle) {
            System.out.println("Ошибка в логине");
        } catch (WrongPasswordException wpe) {
            System.out.println("Ошибка в пароле");
        }
    }

    private static void authenticationUser(String login, String password, String confirmPasswordS) {
        for (int i = 0; i < login.length(); i++)
            if (!VALID_SYMBOLS.contains(Character.toString(login.charAt(i))) || login.length() > 20) {
                throw new WrongLoginException();
            }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(password.charAt(i))) || password.length() > 20) {
                throw new WrongPasswordException();
            }
            if (!password.equals(confirmPasswordS)) {
                throw new WrongPasswordException();
            }
        }
    }
}