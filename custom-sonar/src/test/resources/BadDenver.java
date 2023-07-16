public class DisallowDenverInClassName { // Noncompliant {{Do not use 'Denver'}}

    public static void main(String[] args) {
        System.out.println("Here we are in Denver"); // Noncompliant {{Do not use 'Denver'}}
    }
}