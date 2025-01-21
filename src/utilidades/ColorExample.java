package utilidades;

public class ColorExample {
    public static void main(String[] args) {
        // Print text in different colors using the Color enum
        System.out.println(Color.RED.getCode() + "This text is red." + Color.RESET.getCode());
        System.out.println(Color.GREEN.getCode() + "This text is green." + Color.RESET.getCode());
        System.out.println(Color.BLUE.getCode() + "This text is blue." + Color.RESET.getCode());
        System.out.println(Color.YELLOW.getCode() + "This text is yellow." + Color.RESET.getCode());
        System.out.println(Color.PURPLE.getCode() + "This text is purple." + Color.RESET.getCode());
        System.out.println(Color.CYAN.getCode() + "This text is cyan." + Color.RESET.getCode());
        System.out.println(Color.WHITE.getCode() + "This text is white." + Color.RESET.getCode());
        System.out.println(Color.BLACK.getCode() + "This text is black." + Color.RESET.getCode());
    }
}