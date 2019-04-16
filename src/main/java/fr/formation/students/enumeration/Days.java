package fr.formation.students.enumeration;

public enum Days {

    //On peut mettre tout sur une ligne si l'enum n'est pas conséquente
    MONDAY(true) {
        @Override
        public double getPlatePrice() {
            return 8.50;
        }

        @Override
        public int getNumberOfPlates() {
            return 3;
        }
    }, TUESDAY(true) {
        @Override
        public double getPlatePrice() {
            return 5.66;
        }
    }, WEDNESDAY(true) {
        @Override
        public double getPlatePrice() {
            return 2.67;
        }
    }, THURSDAY(true) {
        @Override
        public double getPlatePrice() {
            return 1.32;
        }
    }, FRIDAY(true) {
        @Override
        public double getPlatePrice() {
            return 0;
        }
    }, SATURDAY(false) {
        @Override
        public double getPlatePrice() {
            return 10.5;
        }
    }, SUNDAY(false) {
        @Override
        public double getPlatePrice() {
            return 30.5;
        }
    }; //On met le ";" si on déclare un constructeur par la suite

    private boolean workingDay;

    private Days(boolean workingDay) {
        this.workingDay = workingDay;
    }

    public boolean isWorkingDay() {
        return workingDay;
    }

    public abstract double getPlatePrice();

    public int getNumberOfPlates() {
        return 1;
    }
}
