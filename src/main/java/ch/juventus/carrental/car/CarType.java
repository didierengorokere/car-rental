package ch.juventus.carrental.car;

public enum CarType {
    CABRIO {
        @Override
        public String toString() {
            return "cabrio";
        }
    };

    LIMOUSINE {
        @Override
        public String toString () {
            return "limousine";
        }
    }

    ;

    SUV {
        @Override
        public String toString () {
            return "suv";
        }
    }

    ;

    MINIBUS {
        @Override
        public String toString () {
            return "minibus";
        }
    }

    ;

    COUPE {
        @Override
        public String toString () {
            return "coupe";
        }
    }

    ;

    ESTATE {
        @Override
        public String toString () {
            return "estate";
        }
    }

    ;
}
