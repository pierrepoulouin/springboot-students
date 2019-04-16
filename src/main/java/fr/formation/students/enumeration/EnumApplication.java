package fr.formation.students.enumeration;

public class EnumApplication {

    public static void main(String[] args) {
        System.out.println(Days.FRIDAY.isWorkingDay());
        System.out.println(Days.SUNDAY.isWorkingDay());

        StringBuilder sb = new StringBuilder();
        Days[] week = Days.values();

        for (Days day : week) {
            String name = day.name();
            sb.append(name);
            sb.append(" = ");
            sb.append(day.isWorkingDay());
            sb.append(System.lineSeparator());
            sb.append("Nombre d'assiette(s) = " + day.getNumberOfPlates());
            sb.append(System.lineSeparator());
            sb.append("Prix = " + day.getPlatePrice() + "€");
            sb.append(System.lineSeparator());
            sb.append("ordinal :");
            sb.append(day.ordinal());
            sb.append(System.lineSeparator());

        }
        System.out.println(sb);
    }
}
