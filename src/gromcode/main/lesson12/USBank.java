package gromcode.main.lesson12;

public class USBank extends Bank {
    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
//        if (getCurrency() == Currency.USD) {
//            return 1000;
//        }
//        return 1200;

        return getCurrency() == Currency.USD ? 1000 : 1200;
    }

    @Override
    public int getLimitOfFunding() {
//        if (getCurrency() == Currency.EUR) {
//            return 10_0000;
//        }
//        return Integer.MAX_VALUE;

        return getCurrency() == Currency.EUR ? 10_0000 : Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() {
//        if (getCurrency() == Currency.EUR) {
//            return 0.02;
//        } else {
//            return 0.01;
//        }

        return getCurrency() == Currency.EUR ? 0.02 : 0.01;

    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD) {
//            if (amount <= 1000) {
//                return 0.05;
//            } else {
//                return 0.07;
//            }

            return amount <= 1000 ? 0.05 : 0.07;
        } else {
//            if (amount <= 1000) {
//                return 0.06;
//            } else {
//                return 0.08;
//            }
            return amount <= 1000 ? 0.06 : 0.08;
        }
    }
}
