package misc;

import design.Name;

public class UdfTest {

    public static void main(String[] args) {
        String s1 = "Brenda,,Mass,Sr.";
        String s2 = "Brenda,T,M,";


        parseNames(s1,s2);


    }

    private static void parseNames(String s1, String s2) {
        int c1 = (int) s1.chars().filter(c -> c == ',') .count();
        int c2 = (int) s2.chars().filter(c -> c == ',') .count();
        if(c1 != 3 || c2 != 3) return;

        Name name1 = constructName(s1);
        Name name2 = constructName(s2);

        System.out.println(name1);
        System.out.println(name2);

        System.out.println(getCombinedName(name1));
        System.out.println(getCombinedName(name2));

    }

    private static Name constructName(String s1) {
        int [] indexes = findIndexes(s1);
        String firstName = s1.substring(0,indexes[0]);
        String middleName = s1.substring(indexes[0]+1,indexes[1]);
        String lastName = s1.substring(indexes[1]+1,indexes[2]);
        String suffix = s1.substring(indexes[2]+1);

        return new Name(firstName,middleName,lastName,suffix);
    }

    private static int [] findIndexes(String s1) {
        int index[] = new  int[3];
        int k=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == ','){
                index[k++] = i;
            }
        }
        return index;
    }

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String getCombinedName(Name name) {
        StringBuffer sb = new StringBuffer();
        if(!isEmpty(name.getFirstName()) && !name.getFirstName().equalsIgnoreCase("null")){
            sb.append(name.getFirstName()).append(" ");
        }
        if(!isEmpty(name.getMiddleName()) && !name.getMiddleName().equalsIgnoreCase("null")){
            sb.append(name.getMiddleName()).append(" ");;
        }
        if(!isEmpty(name.getLastName()) && !name.getLastName().equalsIgnoreCase("null")){
            sb.append(name.getLastName()).append(" ");;
        }
        if(!isEmpty(name.getSuffix()) && !name.getSuffix().equalsIgnoreCase("null")){
            sb.append(name.getSuffix());
        }
        return sb.toString();
    }
}
