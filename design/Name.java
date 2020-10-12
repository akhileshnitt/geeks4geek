package design;

import java.util.Objects;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;


    public Name() {
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = convertToUpper(firstName);
        this.middleName = convertToUpper(middleName);
        this.lastName = convertToUpper(lastName);
        this.suffix = convertToUpper(suffix);
    }


    public String getFirstName() {
        return firstName.trim();
    }

    public String getLastName() {
        return lastName.trim();
    }

    public String getMiddleName() {
        return middleName.trim();
    }

    public String getSuffix() {
        return suffix.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        if (!Objects.equals(firstName, name.firstName) || !Objects.equals(middleName, name.middleName) ||
                !Objects.equals(lastName, name.lastName)) {
            return false;
        }
        return Objects.equals(suffix, name.suffix);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        return result;
    }


    private String convertToUpper(String input) {
        if (!isBlank(input) && !input.equalsIgnoreCase("null")) {
            return upperCase(input);
        } else return " ";
    }

    public void setFirstName(String firstName) {
        this.firstName = convertToUpper(firstName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = convertToUpper(middleName);
    }

    public void setLastName(String lastName) {
        this.lastName = convertToUpper(lastName);
    }

    public void setSuffix(String suffix) {
        this.suffix = convertToUpper(suffix);
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String upperCase(final String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }


    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
