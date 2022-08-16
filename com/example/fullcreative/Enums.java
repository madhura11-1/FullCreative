package com.example.fullcreative;

public class Enums {

    public enum relation {

        noLabel(0), father(1), mother(2), sister(3), brother(4), spouse(5), child(6), friend(7), colleague(8), custom(9);

        private final int rela;

        private relation(int n) {
            this.rela = n;
        }
        public static String getValue(int type) {

            for (relation p : relation.values()) {
                if (p.rela == type) {
                    return p.name();
                }

            }
            return null;

        }

    }

    public enum date {

        noLabel(0), birthday(1), anniversary(2), custom(3);

        private final int datei;

        private date(int n) {
            this.datei = n;
        }

        public static String getValue(int type) {

            for (date p : date.values()) {
                if (p.datei == type) {
                    return p.name();
                }

            }
            return null;

        }
    }

    public enum phoneNumber {

        noLabel(0), work(1), home(2), main(3), custom(4);

        private final int pn;

        private phoneNumber(int n) {
            this.pn = n;
        }

        public static String getValue(int type) {

            for (phoneNumber p : phoneNumber.values()) {
                if (p.pn == type) {
                    return p.name();
                }

            }
            return null;

        }
    }

        public enum email {
            noLabel(0), work(1), custom(2);

            private final int emaili;

            private email(int n) {
                this.emaili = n;
            }

            public static String getValue(int type) {

                for (email p : email.values()) {
                    if (p.emaili == type) {
                        return p.name();
                    }

                }
                return null;

            }
        }

        public enum saveTo {

            sim(0), drive(1);
            private final int saveto;

            private saveTo(int n) {
                this.saveto = n;
            }

            public static String getValue(int type) {

                for (saveTo p : saveTo.values()) {
                    if (p.saveto == type) {
                        return p.name();
                    }

                }
                return null;

            }

        }

    }

